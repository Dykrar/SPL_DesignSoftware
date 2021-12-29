/**
 * 
 */
package zirk.eventos;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public class CoresLuzesEvent extends DispositivoEvent {
	
	private static final long serialVersionUID = 1L;
	
	private CoresLuzes corLuz;

	
	public CoresLuzesEvent(LocalDateTime dateTime, CoresLuzes corLuz) {
		super(TipoEvento.COR_LUZ, dateTime);
		this.corLuz = corLuz;
	}


	public CoresLuzes getCorLuz() {
		return corLuz;
	}

}
