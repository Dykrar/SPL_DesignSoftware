package zirk.eventos;

import java.time.LocalDateTime;


public class DetetorMovimentoEvent extends DispositivoEvent {
	
	private static final long serialVersionUID = 1L;
	private final String areaDetecao;

	public DetetorMovimentoEvent(String areaDetecao, LocalDateTime timestamp) {
		super(TipoEvento.MOVEMENT_DETECTION, timestamp);
		this.areaDetecao = areaDetecao;
	}

	public String getDetectionArea() {
		return areaDetecao;
	}
}
