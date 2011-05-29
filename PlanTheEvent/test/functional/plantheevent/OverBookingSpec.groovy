package plantheevent

import grails.plugin.geb.GebSpec
import plantheevent.pages.*

class OverBookingSpec extends GebSpec {

    def "イベント画面初期表示"() {
        when:
            to ShowEventPage
        then:
            at ShowEventPage
            detail == "レッツゴーデベロッパー"
            participantsCount == "0"
            roomsCapacity == "10"
    }

    def "申し込み画面へ移動"() {
        when:
                    to ShowEventPage
                    apply.click()
        then:
                    at ApplyParticipantPage
    }

    def "参加者一件登録"() {
        when:
            to ApplyParticipantPage
            twitterId = "@digitalsoul0124"
            message = "よろしくお願いします"
            register.click()
        then:
            at ShowEventPage
            detail == "レッツゴーデベロッパー"
            participantsCount == "1"
    }

    def "参加者上限設定"() {
        when:
            to ApplyParticipantPage
            for(i in 2..11){
                assert at(ApplyParticipantPage)
                twitterId = "@" + i
                register.click()

                assert at(ShowEventPage)
                if(i != 11){
                    apply.click()
                }
            }
        then:
            fullToCapacityMessage == "満席になりました"
    //        $("#register"). // FIXME

    }

    def "参加者一覧確認"() {
        when:
            to ShowEventPage
            participantsList.click()
        then:
            at ListParticipantPage
            participantsSize == 11
            twitterId(0) == "@digitalsoul0124"
            twitterId(1) == "@2"
            twitterId(2) == "@3"
            twitterId(3) == "@4"
            twitterId(4) == "@5"
            twitterId(5) == "@6"
            twitterId(6) == "@7"
            twitterId(7) == "@8"
            twitterId(8) == "@9"
            twitterId(9) == "@10"
            twitterId(10) == "@11"
    }

    def "参加者一覧確認終了"() {
        when:
            to ShowEventPage
            participantsList.click()
            assert at(ListParticipantPage)
            back.click()
        then:
            at ShowEventPage

    }
}
