package plantheevent

import geb.spock.GebSpec

class OverBookingSpec extends GebSpec {

	def "イベント詳細画面表示"() {
		when:
			go "/PlanTheEvent/event/show"
		then:
			$("h1").text() == "イベント情報" &&
			$("td#EVENT_LAVEL").text() == "詳細"
	}
	
	def "申し込みボタン押下"() {
		when:
			go "/PlanTheEvent/event/show"
    		$("input#apply").click()
		then:
			$("h1").text() == "申し込み"
	}
	
	String getBaseUrl() {
		"http://localhost:8080/PlanTheEvent"
	}
}