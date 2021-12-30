package zirk.eventos;

import java.time.LocalDateTime;

import zirk.devices.Dispositivo;

public class DetetorAberturaPortaEvent {//Needs Extend

	private final int tempoAberta;

	public DetetorAberturaPortaEvent(int tempoAberta, LocalDateTime timestamp) {
		super(TipoEvento.OPEN_DOOR, timestamp);
		this.tempoAberta = tempoAberta;
	}

	public int getTempoAberta() {
		return tempoAberta;
	}
	
}
