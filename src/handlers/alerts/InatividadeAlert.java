package handlers.alerts;

import java.util.Timer;
import java.util.TimerTask;

import i18n.I18N;
import i18n.Messages;

public class InatividadeAlert extends Alert {
	
	private final int duration;
	private final Timer timer;

	/**
	 * @param alertType
	 */
	public InatividadeAlert(int duration) {
		super(AlertType.INATIVIDADE);
		this.duration = duration;
		this.timer = new Timer();
		timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	String defaultMessage = "Inactivity Alert! {0} minutes";
            	int minutes = duration / 1000 / 60;
            	String message = I18N.getString(Messages.INATIVIDADE_ALERT, defaultMessage, Integer.toString(minutes));
            	AlertHandler.getInstance().alert(message);
            }
        }, this.duration);
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	public void cancel() {
		this.timer.cancel();
	}

}
