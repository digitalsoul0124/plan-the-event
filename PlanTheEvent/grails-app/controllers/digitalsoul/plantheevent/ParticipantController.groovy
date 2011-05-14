package digitalsoul.plantheevent

class ParticipantController {

    def apply = { }
    
    def register = {
    	redirect(controller: "event", action: "show")
    }
}
