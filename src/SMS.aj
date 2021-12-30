import handlers.messages.SendMessage;;

public class   SMS {

	void b()                           {
		SendMessage.setInstance(new SendMessage("SMS"));
		System.err.println("USING SMS"); //TODO: CHANGE TO PT/EN MESSAGES
	}
}
