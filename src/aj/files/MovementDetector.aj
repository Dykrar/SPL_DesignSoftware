package aj.files;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import handlers.devices.DeviceHandler;
import handlers.alerts.AlertHandler;
import zirk.eventos.DispositivoEvent;
import zirk.eventos.DetetorMovimentoEvent;

public aspect MovementDetector {
	
	pointcut movementDetectionEventDetected(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

	void around(DispositivoEvent event, ZirkEndPoint sender): movementDetectionEventDetected(event, sender) {
        if (event instanceof DetetorMovimentoEvent) {
        	AlertHandler.getInstance().handleMotionDetection((DetetorMovimentoEvent)event);
        }
	}
}
