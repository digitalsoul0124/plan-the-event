package plantheevent

import geb.spock.GebSpec

class OverBookingSpec extends GebSpec {

	def "イベント詳細画面表示"() {
		when:
			go "/PlanTheEvent/event/show"
		then:
			$("h1").text() == "イベント情報"
			$("td#detail").text() == "レッツゴーデベロッパー"
			$("td#participantsCount").text() == 0

	}
	
	def "申し込みボタン押下"() {
		when:
			go "/PlanTheEvent/event/show"
    		$("input#apply").click()
		then:
			$("h1").text() == "申し込み"
	}
	
	def "登録ボタン押下"() {
		when:
			go "/PlanTheEvent/participant/apply"
			$("form").twitterId = "@digitalsoul"
			$("form").message = "よろしくお願いします"
			$("input#register").click()
		then:
			$("h1").text() == "イベント情報"
	}
	
	String getBaseUrl() {
		"http://localhost:8080/PlanTheEvent"
	}
}