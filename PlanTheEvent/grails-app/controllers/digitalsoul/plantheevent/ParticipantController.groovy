package digitalsoul.plantheevent

import org.springframework.context.*
import digitalsoul.plantheevent.repositories.*

class ParticipantController implements ApplicationContextAware {
   

    // 申し込み画面初期表示
    def apply = { 
        
    }

    // 登録ボタン押下
    def register = {

        def participant = new Participant(twitterId:params.twitterId, message:params.message)

        def eventRepository = eventRepository()
    	def event = eventRepository.find()
    	event.addParticipant(participant)
    	eventRepository.save(event)

    	redirect(controller: "event", action: "show")
    }
    
    // 参加者一覧画面初期表示
    def list = {
        def event = eventRepository().find()
        def participants = event.participants
        render(view: "list", model:[participantInstanceList: participants]);
    }

    ApplicationContext applicationContext
    private EventRepository eventRepository() {
        applicationContext.getBean("eventRepository")
    }
}
