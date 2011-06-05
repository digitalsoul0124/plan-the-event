package plantheevent.pages

import geb.Page

class ShowEventPage extends Page {

    static url = 'event/show'

    static at = { $("#pageTitle").text() == "イベント情報" }

    static content = {
        detail { $("#detail").text() }
        participantsCount { $("#participantsCount").text() }
        roomsCapacity { $("#roomsCapacity").text() }
        fullToCapacityMessage { $("#fullToCapacityMessage").text() }

        apply { $("#apply") }
        participantsList { $("input#participantsList") }
    }
}