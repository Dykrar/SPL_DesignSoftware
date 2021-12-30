package zirk.devices;

import dispositivos.TipoProduto;
import handlers.devices.DeviceHandler;

public class LampadaInteligente extends Dispositivo {

	public LampadaInteligente(Bezirk bezirk) {
		super(bezirk, TipoProduto.LAMPADA_INTELIGENTE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(LuzEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                deviceHandler.handleEvent((DeviceEvent)event, sender);
            }
        };
        events.setEventReceiver(eventReceiver);
        this.bezirk.subscribe(events);
	}
	
	
}
