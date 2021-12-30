package eventos.bezirk;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public abstract class DispositivoEvent extends Event {

	private static final long serialVersionUID = 1L;
	protected final TipoEvento eventType;
	protected final LocalDateTime timestamp;

	public DispositivoEvent(TipoEvento eventType, LocalDateTime dateTime) {
		super();
		this.eventType = eventType;
		this.timestamp = dateTime;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	/**
	 * @return the eventType
	 */
	public TipoEvento getEventType() {
		return eventType;
	}
}
