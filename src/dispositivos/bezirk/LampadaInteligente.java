package dispositivos.bezirk;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import dispositivos.TipoProduto;
import eventos.bezirk.DispositivoEvent;
import eventos.bezirk.LuzEvent;
import handlers.devices.DeviceHandler;

public class LampadaInteligente extends Dispositivo {

	public LampadaInteligente(Bezirk bezirk) {
		super(bezirk, TipoProduto.LAMPADA_INTELIGENTE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(LuzEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                deviceHandler.handleEvent((DispositivoEvent)event, sender);
            }
        };
        events.setEventReceiver(eventReceiver);
        this.bezirk.subscribe(events);
	}
	
	
}
