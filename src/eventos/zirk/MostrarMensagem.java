package eventos.zirk;

public class MostrarMensagem {

	private static MostrarMensagem instance;

	private MostrarMensagem() {
		
	}

	public static MostrarMensagem getInstance() {
		if (instance == null) {
			instance = new MostrarMensagem();
		}
		return instance;
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public void showWarning(String message) {
		System.err.println(message);
	}

	public void showAlert(String message) {
		System.err.println(message);
	}

}
