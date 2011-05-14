package digitalsoul.plantheevent.repositories

import grails.plugin.spock.UnitSpec
import digitalsoul.plantheevent.Participant

class EventRepositorySpec extends UnitSpec {
	
	def "イベント初期情報確認"() {
		when:
			def eventRepository = new MemoryEventRepository()
		then:
			def event = eventRepository.find()
			event.detail == "レッツゴーデベロッパー"
			event.participantsCount() == 0
	}
	
	def "参加者情報更新"() {
		when:
			def eventRepository = new MemoryEventRepository()
			def event = eventRepository.find()
			event.participants.add(new Participant())
			eventRepository.save(event)
		then:
			def newEvent = eventRepository.find()
			newEvent.participantsCount() == 1
	}

}
