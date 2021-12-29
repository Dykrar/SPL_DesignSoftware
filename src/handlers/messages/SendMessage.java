package handlers.messages;


public class SendMessage {

	public SendMessage(String messageApp) {
			//TODO
		
	}
/*
	private String getString(Messages key) {
		return bundle.getString(key.toString());
	}
	*/
	/***  SINGLETON ***/
	
	private static SendMessage instance;

	public static void setInstance(SendMessage messageApp) {
		 instance = messageApp;
	}
	
	public static SendMessage getInstance() {
		return instance;
	}

	/***  SERVICES  ***/
/*
	public static String getString(Messages key, String... args) {
		return MessageFormat.format(instance.getString(key), (Object[]) args);
	}*/
}
