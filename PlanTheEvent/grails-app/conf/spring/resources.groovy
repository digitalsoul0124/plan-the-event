// Place your Spring DSL code here
beans = {
	eventRepository(digitalsoul.plantheevent.repositories.MemoryEventRepository) { bean ->
		bean.scope = "singleton"
	}
}
