package plantheevent.pages

import geb.Page

class ApplyParticipantPage extends Page {

    static url = 'participant/apply'

    static at = { $("#pageTitle").text() == "申し込み" }

    static content = {
        twitterId { $('input[name=twitterId]') }
        message { $('input[name=messag"]') }
        register { $("#register") }
    }
}