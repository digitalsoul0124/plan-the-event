package digitalsoul.plantheevent

import org.springframework.context.*

class EventController implements ApplicationContextAware {
	ApplicationContext applicationContext

    def show = { 
    	def eventRepository = applicationContext.getBean("eventRepository")
    	def event = eventRepository.find()    	
    	render(view: "show", model:[event: event]);
    }
    
    def apply = { 
    	redirect(controller: "participant", action: "apply")
    }
}
