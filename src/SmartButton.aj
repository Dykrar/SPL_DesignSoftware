


import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import zirk.eventos.DispositivoEvent;
import zirk.eventos.BotaoInteligenteEvent;//Classe foi eliminada
import handlers.devices.DeviceHandler;


public aspect SmartButton {
	
	pointcut smartButtonEventDetected(DispositivoEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DispositivoEvent, ZirkEndPoint)) && args(event, sender);

	void around(DispositivoEvent event, ZirkEndPoint sender): smartButtonEventDetected(event, sender) {
        if (event instanceof BotaoInteligenteEvent) {
        	String defaultMessage = "Button pressed!";
        	String message = I18N.getString(Messages.BOTAO_ALERT, defaultMessage);
        	AlertHandler.getInstance().alert(message);
        	 // TODO: ADD SEND MESSAGE
        }
	}
}
