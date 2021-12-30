package zirk.eventos;

import java.time.LocalDateTime;

public class CampainhaEvent extends DispositivoEvent{

	private static final long serialVersionUID = 1L;

	private final int tempoDpsToque;
	


	public CampainhaEvent(int tempoDpsToque, LocalDateTime timeStamp) {
		super(TipoEvento.DOOR_BELL, timeStamp);
		this.tempoDpsToque = tempoDpsToque;
	}

	

}
