

import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import zirk.eventos.DetetorAberturaPortaEvent;
import zirk.eventos.DispositivoEvent;

public aspect OpeningSmartDoor {
	
	pointcut openingSmartDoor(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

/*	void around(DispositivoEvent event, ZirkEndPoint sender): openingSmartDoor(event, sender) {
        if (event instanceof DetetorAberturaPortaEvent) {
        	String defaultMessage = "Button pressed!";
        	String message = I18N.getString(Messages.BOTAO_ALERT, defaultMessage);
        	AlertHandler.getInstance().alert(message);
        }
	}*/
}
