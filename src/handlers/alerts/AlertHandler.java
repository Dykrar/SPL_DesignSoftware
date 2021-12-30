package handlers.alerts;

import handlers.contacts.ContactHandler;
import zirk.eventos.DetetorMovimentoEvent;
import zirk.eventos.MostrarMensagem;

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
		ContactHandler.getInstance().sendEmergencySMS(message);
	}

	public void handleDetecaoMovimento(DetetorMovimentoEvent event) {
		for (Alert alert: this.alerts.getAlertList()) {
			if (alert instanceof DetecaoMovimentoAlert) {
				((DetecaoMovimentoAlert) alert).alert();
			}
			if (alert instanceof InatividadeAlert) { 
				((InatividadeAlert) alert).cancel();
			} //Classe InatividadeAlert foi eliminada
		}
	}
}
