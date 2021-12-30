package zirk.eventos;

import java.time.LocalDateTime;

public class AlertButtonEvent extends DispositivoEvent {

	private static final long serialVersionUID = 1L;

	/**
	 * @param eventType
	 * @param dateTime
	 */
	public AlertButtonEvent(LocalDateTime timeStamp) {
		super(TipoEvento.ALERT_BUTTON, timeStamp);
	}

	

}
