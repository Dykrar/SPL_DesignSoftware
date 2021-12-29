package eventos.zirk;

import java.time.LocalDateTime;


public class DetetorMovimentoEvent extends DispositivoEvent {
	
	private static final long serialVersionUID = 1L;
	private final String areaDetecao;

	/**
	 * @param areaDetecao
	 * @param detected
	 * @param timestamp
	 */
	public DetetorMovimentoEvent(String areaDetecao, LocalDateTime timestamp) {
		super(TipoEvento.DETECAO_MOVIMENTO, timestamp);
		this.areaDetecao = areaDetecao;
	}

	/**
	 * @return the detectionArea
	 */
	public String getDetectionArea() {
		return areaDetecao;
	}
}
