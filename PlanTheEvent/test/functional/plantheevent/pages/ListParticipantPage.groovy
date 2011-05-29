package plantheevent.pages

import geb.Page

class ListParticipantPage extends Page {

    static url = 'participant/list'

    static at = { $("h1").text() == "参加者一覧" }

    static content = {
        twitterId { index -> $("td.twitterId", index).text() }
        participantsSize { $('table tbody tr').size() }

        back { $("input#back") }
    }
}