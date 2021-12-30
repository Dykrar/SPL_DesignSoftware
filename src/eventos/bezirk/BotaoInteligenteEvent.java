package eventos.bezirk;

import java.time.LocalDateTime;

public class BotaoInteligenteEvent extends DispositivoEvent {

	private static final long serialVersionUID = 1L;

	/**
	 * @param eventType
	 * @param dateTime
	 */
	public BotaoInteligenteEvent(LocalDateTime timeStamp) {
		super(TipoEvento.SMART_BUTTON, timeStamp);
	}

	

}
