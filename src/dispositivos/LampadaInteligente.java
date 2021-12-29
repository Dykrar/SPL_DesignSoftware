package dispositivos;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import eventos.zirk.CoresLuzesEvent;

public class LampadaInteligente extends RegistaDispositivo {

	public LampadaInteligente() {
		super(TipoProduto.LAMPADA_INTELIGENTE);
	}

	public static void main(String[] args) {
		LampadaInteligente smartBulbZirk = new LampadaInteligente();
		System.out.println("Running Smart Bulb Simulator");
        EventSet lightSignalEvents = new EventSet(CoresLuzesEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                if (event instanceof CoresLuzesEvent) {
                	System.out.println("Received Light Signal event");
                }
            }
        };
        lightSignalEvents.setEventReceiver(eventReceiver);
        smartBulbZirk.bezirk.subscribe(lightSignalEvents);
        System.out.println("Subscribed to Smart Bulb events");
	}

}
