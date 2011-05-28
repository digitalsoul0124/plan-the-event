package plantheevent

import geb.spock.GebSpec

class OverBookingSpec extends GebSpec {

    def "イベント画面初期表示"() {
        when:
            go "/PlanTheEvent/event/show"
        then:
            $("#pageTitle").text() == "イベント情報"
            $("#detail").text() == "レッツゴーデベロッパー"
            $("#participantsCount").text() == "0"
            $("#roomsCapacity").text() == "10"
    }

    def "申し込み画面へ移動"() {
        when:
                    go "/PlanTheEvent/event/show"
                    $("#apply").click()
        then:
                    $("#pageTitle").text() == "申し込み"
    }

    def "参加者一件登録"() {
        when:
            go "/PlanTheEvent/participant/apply"
            $("form").twitterId = "@digitalsoul0124"
            $("form").message = "よろしくお願いします"
            $("#register").click()
        then:
            $("#pageTitle").text() == "イベント情報"
            $("#detail").text() == "レッツゴーデベロッパー"
            $("#participantsCount").text() == "1"
    }

    def "参加者上限設定"() {
        when:
            go "/PlanTheEvent/participant/apply"
            for(i in 2..11){
                $("form").twitterId = "@" + i
                $("#register").click()
                if(i != 11){
                    $("#apply").click()
                }
            }
        then:
            $("#fullToCapacityMessage").text() == "満席になりました"
    //        $("#register"). // FIXME

    }

    def "参加者一覧確認"() {
        when:
            go "/PlanTheEvent/event/show"
            $("input#participantsList").click()
        then:
            $("h1").text() == "参加者一覧"
            $("td.twitterId", 0).text() == "@digitalsoul0124"
            $("td.twitterId", 1).text() == "@2"
            $("td.twitterId", 2).text() == "@3"
            $("td.twitterId", 3).text() == "@4"
            $("td.twitterId", 4).text() == "@5"
            $("td.twitterId", 5).text() == "@6"
            $("td.twitterId", 6).text() == "@7"
            $("td.twitterId", 7).text() == "@8"
            $("td.twitterId", 8).text() == "@9"
            $("td.twitterId", 9).text() == "@10"
            $("td.twitterId", 10).text() == "@11"
            $("td.twitterId", 11).isEmpty()

    }

    def "参加者一覧確認終了"() {
        when:
            go "/PlanTheEvent/event/show"
            $("input#participantsList").click()
            $("input#back").click()
        then:
            $("h1").text() == "イベント情報"

    }

    String getBaseUrl() {
        "http://localhost:8080/PlanTheEvent"
    }

}
