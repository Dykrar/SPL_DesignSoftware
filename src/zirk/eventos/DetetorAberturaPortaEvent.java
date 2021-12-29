package zirk.eventos;

import java.time.LocalDateTime;

public class DetetorAberturaPortaEvent {

	private final int tempoAberta;


	public DetetorAberturaPortaEvent(int tempoAberta, LocalDateTime timestamp) {
		super(TipoEvento.OPEN_DOOR, timestamp);
		this.tempoAberta = tempoAberta;
	}

	public int getTempoAberta() {
		return tempoAberta;
	}
	
}
