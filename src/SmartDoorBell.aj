

import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import zirk.eventos.CampainhaEvent;
import zirk.eventos.DispositivoEvent;

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
