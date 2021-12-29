package zirk.devices;

import handlers.devices.DeviceHandler;

public class LampedaInteligente extends Device {

	public DetetorAberturaPorta(Bezirk bezirk) {
		super(bezirk, DeviceType.MOTION_DETECTOR);
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
