package eventos.bezirk;

import java.time.LocalDateTime;


 public class DetetorAberturaPortaEvent extends DispositivoEvent {


	private static final long serialVersionUID = 1L;
	private final int tempoAberta;

	public DetetorAberturaPortaEvent(int tempoAberta, LocalDateTime timestamp) {
		super(TipoEvento.OPEN_DOOR, timestamp);
		this.tempoAberta = tempoAberta;
	}

	public int getTempoAberta() {
		return tempoAberta;
	}
	
}
