package digitalsoul.plantheevent.repositories

import digitalsoul.plantheevent.Event
import digitalsoul.plantheevent.Participant
import digitalsoul.plantheevent.Room

class MemoryEventRepository implements EventRepository {

	private Event event = defaultEvent()

	Event find() {
		return event
	}
	
	void save(Event event) {
		this.event = event
	}

	Event defaultEvent() {
	    new Event(
                    detail:"レッツゴーデベロッパー",
	            participants:new ArrayList<Participant>(),
	            room:new Room(capacity:10))
	}

}