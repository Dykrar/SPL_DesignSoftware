import java.time.LocalDateTime;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.devices.DeviceHandler;
import eventos.bezirk.LuzEvent;
import eventos.bezirk.DispositivoEvent;
import dispositivos.bezirk.Dispositivo;

public aspect SmartLights {
	pointcut lightSignalEventDetected(DispositivoEvent event, Dispositivo dispositivo):
		call(void DeviceHandler.sendEvent(DispositivoEvent, ZirkEndPoint)) && args(event, dispositivo);
	
	void around(DispositivoEvent event, Dispositivo dispositivo): lightSignalEventDetected(event, dispositivo) {
        if (event instanceof LuzEvent) {
        	DeviceHandler.getInstance().sendEvent(new LuzEvent(LocalDateTime.now()), dispositivo);
        } 
	}
}
