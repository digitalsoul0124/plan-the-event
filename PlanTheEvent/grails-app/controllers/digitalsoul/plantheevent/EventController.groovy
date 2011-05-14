package digitalsoul.plantheevent

class EventController {

    def show = { }
    
    def apply = { 
    	redirect(controller: "participant", action: "apply")
    }
}
