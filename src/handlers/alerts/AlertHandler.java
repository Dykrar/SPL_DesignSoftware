package handlers.alerts;

import eventos.bezirk.DetetorMovimentoEvent;
import eventos.bezirk.MostrarMensagem;

public class AlertHandler {

	private static AlertHandler instance;
	private AlertCatalog alerts;

	private AlertHandler() {
		this.alerts = new AlertCatalog();
	}

	public static AlertHandler getInstance() {
		if (instance == null) {
			instance = new AlertHandler();
		}
		return instance;
	}
	
	public AlertCatalog getAlerts() {
		return this.alerts;
	}

	public void alert(String message) {
		MostrarMensagem.getInstance().showAlert(message);
	}

	public void handleDetecaoMovimento(DetetorMovimentoEvent event) {
		for (Alert alert: this.alerts.getAlertList()) {
			if (alert instanceof DetecaoMovimentoAlert) {
				((DetecaoMovimentoAlert) alert).alert();
			}
		}
	}
}
