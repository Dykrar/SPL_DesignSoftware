package zirk.devices;

import dispositivos.TipoProduto;
import handlers.devices.DeviceHandler;

public class BotaoInteligente extends Device {
	
	public BotaoInteligente(Bezirk bezirk) {
		super(bezirk, TipoProduto.BOTAO_INTELIGENTE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(MotionDetectionEvent.class);
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
