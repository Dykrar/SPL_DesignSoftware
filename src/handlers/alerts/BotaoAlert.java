package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

public class BotaoAlert extends Alert {

	public BotaoAlert() {
		super(AlertType.BOTAO_AL);
	}

	public void alert(String location) {
		String defaultMessage = "Botao Alert!";
    	String message = I18N.getString(Messages.BOTAO_ALERT, defaultMessage);
    	AlertHandler.getInstance().alert(message);
	}
}
