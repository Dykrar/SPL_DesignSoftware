package aj.files;


import handlers.messages.SendMessage;;

public aspect  SMS {

	before() : execution(* *.main(..)) {
		SendMessage.setInstance(new SendMessage("SMS"));
		System.err.println("USING SMS"); //TODO: CHANGE TO PT/EN MESSAGES
	}
}