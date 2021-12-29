package zirk.devices;

import handlers.devices.DeviceHandler;

public class CampainhaInteligente extends Device {

	public CampainhaInteligente(Bezirk bezirk) {
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
