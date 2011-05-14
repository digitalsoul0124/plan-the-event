package digitalsoul.plantheevent.repositories

import digitalsoul.plantheevent.Event

interface EventRepository {

	Event find()
	
	void save(Event event)

}