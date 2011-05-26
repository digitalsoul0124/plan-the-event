package digitalsoul.plantheevent

class OverbookingPolicy {

    // 部屋の上限
    int limitFor(Room room) {
        room.capacity * 1.1
    }

    // 満席判定
    boolean fullToCapacity(Event event) {
        event.participantsCount() >= limitFor(event.room)
    }

}
