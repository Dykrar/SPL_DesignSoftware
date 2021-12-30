import com.bezirk.middleware.addressing.ZirkEndPoint;

import eventos.bezirk.DetetorMovimentoEvent;
import eventos.bezirk.DispositivoEvent;
import handlers.devices.DeviceHandler;
import handlers.alerts.AlertHandler;

public aspect MovementDetector {
	
	pointcut movementDetectionEventDetected(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

	void around(DispositivoEvent event, ZirkEndPoint sender): movementDetectionEventDetected(event, sender) {
        if (event instanceof DetetorMovimentoEvent) {
        	AlertHandler.getInstance().handleDetecaoMovimento((DetetorMovimentoEvent)event);
        }
	}
}
