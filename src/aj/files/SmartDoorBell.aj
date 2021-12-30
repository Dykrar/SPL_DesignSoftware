package aj.files;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import handlers.devices.DeviceHandler;
import eventos.bezirk.CampainhaEvent;
import eventos.bezirk.DispositivoEvent;

public aspect SmartDoorBell {
	
	pointcut smartDoorBell(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

	void around(DispositivoEvent event, ZirkEndPoint sender): smartDoorBell(event, sender) {
        if (event instanceof CampainhaEvent) {
        	String defaultMessage = "Bell pressed!";
        	String message = I18N.getString(Messages.BOTAO_ALERT, defaultMessage);
        	AlertHandler.getInstance().alert(message);
        	 
        }
	}
}
