package handlers.warnings;

import eventos.zirk.MostrarMensagem;

public class WarningHandler {

	private static WarningHandler instance;
	private WarningCatalog warnings;

	private WarningHandler() {
		this.warnings = new WarningCatalog();
	}

	public static WarningHandler getInstance() {
		if (instance == null) {
			instance = new WarningHandler();
		}
		return instance;
	}

	public WarningCatalog getWarnings() {
		return this.warnings;
	}

	public void warn(String message) {
		MostrarMensagem.getInstance().showWarning(message);
	}

}