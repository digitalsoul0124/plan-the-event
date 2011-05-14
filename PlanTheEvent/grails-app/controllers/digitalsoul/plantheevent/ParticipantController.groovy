package digitalsoul.plantheevent

import org.springframework.context.*

class ParticipantController implements ApplicationContextAware {
	ApplicationContext applicationContext

    def apply = { }
    
    def register = {
        def eventRepository = applicationContext.getBean("eventRepository")
        
    	def event = eventRepository.find()
    	event.addParticipant(params.participant)
    	eventRepository.save(event)

    	redirect(controller: "event", action: "show")
    }
}
