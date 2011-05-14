package digitalsoul.plantheevent.repositories

import digitalsoul.plantheevent.Event
import digitalsoul.plantheevent.Participant

class MemoryEventRepository {

	private Event event = new Event(detail:"レッツゴーデベロッパー", 
		participants:new ArrayList<Participant>())

	Event find() {
		return event
	}
	
	void save(Event event) {
		this.event = event
	}

}