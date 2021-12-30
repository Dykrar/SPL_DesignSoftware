package handlers.eventos;

import eventos.bezirk.MostrarMensagem;

public class EventoHandler {

	private static EventoHandler instance;
	private EventoCatalog eventos;

	private EventoHandler() {
		this.eventos = new EventoCatalog();
	}

	public static EventoHandler getInstance() {
		if (instance == null) {
			instance = new EventoHandler();
		}
		return instance;
	}

	public EventoCatalog getEventos() {
		return this.eventos;
	}

	public void avisaEvento(String message) {
		MostrarMensagem.getInstance().showEvento(message);
	}

}
