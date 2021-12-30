package demo;

public class OutputController {
	private String message;

    public OutputController(String mgs) {
        this.message = mgs;
    }

    public void sendMessage(){
        UI.printMessage(this.message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
