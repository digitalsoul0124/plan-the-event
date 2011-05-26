package digitalsoul.plantheevent

import grails.plugin.spock.UnitSpec
import digitalsoul.plantheevent.repositories.*

class EventSpec extends UnitSpec {


    def "満席"() {
        when:
            def overbookingPolicy = new OverbookingPolicy()
            def room = new Room(capacity:10)
            def LIMIT = overbookingPolicy.limitFor(room)
            def event = new Event(room:room)
            for(i in 1..LIMIT){
                event.addParticipant(new Participant())
            }
        then:
            overbookingPolicy.fullToCapacity(event)
    }


    def "部屋上限ならまだセーフ"() {
        when:
            def overbookingPolicy = new OverbookingPolicy()
            def room = new Room(capacity:10)
            def LIMIT = overbookingPolicy.limitFor(room)
            def event = new Event(room:room)
            for(i in 1..room.capacity){
                event.addParticipant(new Participant())
            }
        then:
            !overbookingPolicy.fullToCapacity(event)

    }


}
