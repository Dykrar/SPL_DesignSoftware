package aj.files;


import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import zirk.eventos.DispositivoEvent;
import zirk.eventos.DistressButtonEvent;
import handlers.devices.DeviceHandler;


public aspect SmartButton {
	
	pointcut distressButtonEventDetected(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

	void around(DeviceEvent event, ZirkEndPoint sender): distressButtonEventDetected(event, sender) {
        if (event instanceof DistressButtonEvent) {
        	String defaultMessage = "Button pressed!";
        	String message = I18N.getString(Messages.DISTRESS_BUTTON_DETECTED, defaultMessage);
        	// AlertHandler.getInstance().alert(message); TODO: ADD SEND MESSAGE
        }
	}
}
