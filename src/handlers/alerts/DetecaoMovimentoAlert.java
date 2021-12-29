package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

public class DetecaoMovimentoAlert extends Alert {

	private String location;

	public DetecaoMovimentoAlert() {
		super(AlertType.DETECAO_MOVIMENTO);
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}

	public void alert() {
		String defaultMessage = "Motion Detection Alert! {0}";
    	String message = I18N.getString(Messages.DETECAO_MOVIMENTO_ALERT, defaultMessage, this.location);
    	AlertHandler.getInstance().alert(message);
	}

}
