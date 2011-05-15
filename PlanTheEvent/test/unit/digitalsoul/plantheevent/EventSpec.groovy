package digitalsoul.plantheevent

import grails.plugin.spock.UnitSpec
import digitalsoul.plantheevent.repositories.*

class EventSpec extends UnitSpec {

    def "キャパシティ内限界値／オーバーブッキング含めて11人まではOK"() {
        when:
            def event = new MemoryEventRepository().find()
            for(i in 1..11){
                event.addParticipant(new Participant())
            }
        then:
            !event.overCapacity()

    }

    def "キャパシティオーバー時／12人めからアウト"() {
        when:
            def event = new MemoryEventRepository().find()
            for(i in 1..12){
                event.addParticipant(new Participant())
            }
        then:
            event.overCapacity()
    }

}
