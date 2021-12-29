import handlers.messages.SendMessage;

public aspect Whatsapp {

	before() : execution(* *.main(..)) {
		SendMessage.setInstance(new SendMessage("WHATSAPP"));
		System.err.println("USING WHATSAPP"); //TODO: CHANGE TO PT/EN MESSAGES
	}
}
