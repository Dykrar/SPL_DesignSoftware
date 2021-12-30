import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import handlers.devices.DeviceHandler;
import eventos.bezirk.LuzEvent;
import eventos.bezirk.DispositivoEvent;
import dispositivos.bezirk.Dispositivo;

public aspect SmartLights {
	pointcut lightSignalEventDetected(DispositivoEvent event, Dispositivo dispositivo):
		call(void DeviceHandler.sendEvent(DeviceEvent, ZirkEndPoint)) && args(event, device);
	
	void around(DispositivoEvent event, Dispositivo dispositivo): lightSignalEventDetected(event, device) {
        if (event instanceof LuzEvent) {
        	DeviceHandler.getInstance().sendEvent(new LuzEvent(LocalDateTime.now(), ((LightSignalEvent) event).getLightSignal()), device);
        }
	
	}
