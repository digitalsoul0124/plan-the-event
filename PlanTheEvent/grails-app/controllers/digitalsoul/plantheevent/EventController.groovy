package digitalsoul.plantheevent

import org.springframework.context.*
import digitalsoul.plantheevent.repositories.*

class EventController implements ApplicationContextAware {

    def index = {
        redirect(action: "show")
    }

    // 初期表示
    def show = {
        def event = eventRepository().find()
        def overbookingPolicy = new OverbookingPolicy()
        def fullToCapacity = overbookingPolicy.fullToCapacity(event)
        render(view: "show", model:[event: event, fullToCapacity: fullToCapacity])
    }

    // 申し込みボタン押下
    def apply = {
        redirect(controller: "participant", action: "apply")
    }

    // 参加者一覧ボタン押下
    def participantsList = {
        redirect(controller: "participant", action: "list")
    }

    ApplicationContext applicationContext
    private EventRepository eventRepository() {
        applicationContext.getBean("eventRepository")
    }
}
