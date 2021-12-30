package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import dispositivos.CampainhaInteligente;
import dispositivos.bezirk.Dispositivo;
import eventos.bezirk.DispositivoEvent;
/**
 * import com.google.inject.Inject;
import com.google.inject.name.Named;
 */

/**
 * import zirk.devices.Device;
import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;
import zirk.events.DeviceEvent;
 */
import dispositivos.bezirk.*;


public class DeviceHandler {

	private static DeviceHandler instance;
	/**
	 * 	@Inject @Named("MovementDetector")
    private static DetetorMovimento detetorMovimento;

    @Inject @Named("SmartLights")
    private static LampadaInteligente lampadaInteligente;

    @Inject @Named("SmartButton")
    private static BotaoInteligente botaoInteligente;

    @Inject @Named("SmartDoorBell")
    private static  CampainhaInteligente campainhaInteligente ;

    @Inject @Named("SmartOpenCloseDoor")
    private static DetetorAberturaPorta detetorAberturaPorta;
	
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
	}

	public void sendEvent(DispositivoEvent event, Dispositivo device) {
	}

}
