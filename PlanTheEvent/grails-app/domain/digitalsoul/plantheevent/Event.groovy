package digitalsoul.plantheevent

class Event {
	
	// 詳細
	String detail
	
	// 参加者
	List<Participant> participants
	
	// 会場
	Room room

        // イベントキャパシティ
        boolean overCapacity() {
            participantsCount() > (roomsCapacity() * 1.1)
        }

	// 会場キャパシティ取得
	int roomsCapacity() {
		room.capacity
	}
	
	// 参加者追加
	void addParticipant(Participant participant) {
		participants.add(participant)
	}
	
	// 参加者数取得
	int participantsCount() {
		participants.size()
	}
	

}
