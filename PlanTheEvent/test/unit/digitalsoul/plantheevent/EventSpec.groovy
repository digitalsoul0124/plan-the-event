package digitalsoul.plantheevent

import grails.plugin.spock.UnitSpec
import digitalsoul.plantheevent.repositories.*

class EventSpec extends UnitSpec {

    def "キャパシティ内限界値／オーバーブッキング含めて10人まではOK"() {
        when:
            def event = new MemoryEventRepository().find()
            for(i in 1..10){
                event.addParticipant(new Participant())
            }
        then:
            !event.fullToCapacity()

    }

    def "満席／11人で満席"() {
        when:
            def event = new MemoryEventRepository().find()
            for(i in 1..11){
                event.addParticipant(new Participant())
            }
        then:
            event.fullToCapacity()
    }

}
