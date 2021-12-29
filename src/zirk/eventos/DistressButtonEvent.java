//REMOVE
/**
 * 
 */
package zirk.eventos;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class DistressButtonEvent extends DispositivoEvent {

	private static final long serialVersionUID = 1L;

	/**
	 * @param eventType
	 * @param dateTime
	 */
	public DistressButtonEvent(LocalDateTime timeStamp) {
		super(TipoEvento.DISTRESS_BUTTON, timeStamp);
	}

	

}
