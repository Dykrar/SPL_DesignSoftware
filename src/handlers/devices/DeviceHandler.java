package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import dispositivos.bezirk.Dispositivo;
import eventos.bezirk.DispositivoEvent;
/**
 * import zirk.devices.Device;
import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;
import zirk.events.DeviceEvent;
 */


public class DeviceHandler {

	private static DeviceHandler instance;
	
	private DeviceHandler() {
	}

	public static DeviceHandler getInstance() {
		if (instance == null) {
			instance = new DeviceHandler();
		}
		return instance;
	}

	public void handleEvent(DispositivoEvent event, ZirkEndPoint sender) {
	}

	public void sendEvent(DispositivoEvent event, Dispositivo device) {
	}

}
