package zirk.devices;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import dispositivos.TipoProduto;
import handlers.devices.DeviceHandler;
import zirk.events.DeviceEvent;
import zirk.events.MotionDetectionEvent;


public class DetetorMovimento extends Device {

	public DetetorMovimento(Bezirk bezirk) {
		super(bezirk, DeviceType.MOTION_DETECTOR);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(DetecaoMovimentoEvent.class);
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