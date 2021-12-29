package handlers.eventos;

import java.util.ArrayList;

public class EventoCatalog {
	
	private ArrayList<Evento> eventos;
	
	public EventoCatalog() {
		this.eventos = new ArrayList<Evento>();
	}

	public ArrayList<Evento> getEventos() {
		return this.eventos;
	}

	public Evento addEvento(Evento evento) {
		this.eventos.add(evento);
		return evento;
	}

	public Evento removeEvento(Evento evento) {
		this.eventos.remove(evento);
		return evento;
	}

}
