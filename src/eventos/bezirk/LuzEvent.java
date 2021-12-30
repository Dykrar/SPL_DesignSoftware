package eventos.bezirk;

import java.time.LocalDateTime;

public class LuzEvent extends DispositivoEvent {
	
	private static final long serialVersionUID = 1L;

	public LuzEvent(LocalDateTime dateTime) {
		super(TipoEvento.LUZ, dateTime);
	}

	public Object getLightSignal() {
		// TODO Auto-generated method stub
		return null;
	}
}
