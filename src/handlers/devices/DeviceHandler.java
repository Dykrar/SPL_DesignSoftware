package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import dispositivos.Dispositivo;
import eventos.zirk.DispositivoEvent;
/**
 * import zirk.devices.Device;
import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;
import zirk.events.DeviceEvent;
 */


public class DeviceHandler {

	private static DeviceHandler instance;
	/**
	 * 	@Inject @Named("MotionDetector")
	private static MotionDetector motionDetector;
	
	@Inject @Named("SmartBulb")
	private static SmartBulb bulb;
	
	@Inject @Named("Wearable")
	private static Wearable wearable;
	 */


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
