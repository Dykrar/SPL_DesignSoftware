package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import dispositivos.Dispositivo;
import zirk.eventos.DispositivoEvent;
/**
 * import zirk.devices.Device;
import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;
import zirk.events.DeviceEvent;
 */


public class DeviceHandler {

	private static DeviceHandler instance;
	
	
	@Inject @Named("MovementDetector")
	private static MovementDetector movementDetector;
	
	@Inject @Named("SmartLights")
	private static SmartLights smartLights;
	
	@Inject @Named("SmartButton")
	private static SmartButton smartButton;
	
	@Inject @Named("SmartDoorBell")
	private static SmartDoorBell smartDoorOpen;
	
	@Inject @Named("SmartOpenCloseDoor")
	private static SmartOpenCloseDoor smartOpenCloseDoor;
	
	 


	private DeviceHandler() {
		
	}

	public static DeviceHandler getInstance() {
		if (instance == null) {
			instance = new DeviceHandler();
		}
		return instance;
	}

	public void handleEvent(DispositivoEvent event, ZirkEndPoint sender) {
		// This method is implemented in aspects
	}

	public void sendEvent(DispositivoEvent event, Dispositivo device) {
		// This method is implemented in aspects
	}

}
