package digitalsoul.plantheevent

class EventController {

    def show = { 
    	render(view: "show", model:[event: new Event(detail:"レッツゴーデベロッパー", participantsCount:0)]);
    }
    
    def apply = { 
    	redirect(controller: "participant", action: "apply")
    }
}
