package dispositivos.bezirk;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import dispositivos.TipoProduto;
import eventos.bezirk.DetetorMovimentoEvent;
import eventos.bezirk.DispositivoEvent;
import handlers.devices.DeviceHandler;

public class CampainhaInteligente extends Dispositivo {

	public CampainhaInteligente(Bezirk bezirk) {
		super(bezirk, TipoProduto.CAMPAINHA_PORTA_INTELIGENTE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(DetetorMovimentoEvent.class);
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
