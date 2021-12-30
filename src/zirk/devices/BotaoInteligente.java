package zirk.devices;

import dispositivos.TipoProduto;
import handlers.devices.DeviceHandler;
import zirk.eventos.DispositivoEvent;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;


public class BotaoInteligente extends Device {
	
	public BotaoInteligente(Bezirk bezirk) {
		super(bezirk, TipoProduto.BOTAO_INTELIGENTE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(MotionDetectionEvent.class);
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
