package handlers.eventos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import i18n.I18N;
import i18n.Messages;

public class Evento {

	private String name;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Frequency frequency;
	private int frequencyNumber;
	private Timer timer;
	private LocalDateTime advanceTime;//NOT USED !!!!
	/**
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param frequency
	 * @param frequencyNumber
	 */
	public Evento(String name, LocalDateTime startDate, LocalDateTime endDate, Frequency frequency, LocalDateTime advancetime) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequency = frequency;
		this.advanceTime = advancetime;
		Evento w = this;
		TimerTask start = new TimerTask() {
			public void run() {
				w.start();
			}
		};
		
		// TODO ADVANCE TIME!
		
		new Timer().schedule(start, Duration.between(startDate, LocalDateTime.now()).toMillis());
		TimerTask stop = new TimerTask() {
			public void run() {
				w.timer.cancel();
			}
		};
		new Timer().schedule(stop, Duration.between(endDate, LocalDateTime.now()).toMillis());
	}

	public String getEventoName() {
		return this.name;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public Frequency getFrequency() {
		return this.frequency;
	}

	public int getFrequencyNumber() {
		return this.frequencyNumber;
	}

	//ver como eh o formato
	private void start() {
		TimerTask task = new TimerTask() {
			public void run() {
				String defaultMessage = "Evento! {0}";
				String message = I18N.getString(Messages.EVENTO, defaultMessage, startDate.toString());
				EventoHandler.getInstance().avisaEvento(message);
			}
		};
		int time = 1000;
		switch (this.frequency) {
		case MINUTE:
			time *= 60;
		case HOUR:
			time *= 60;
		case DAY:
			time *= 24;
		case WEEK:
			time *= 7;
		case YEAR:
			time *= 52;
		default:
			break;
		}
		this.timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, time * this.frequencyNumber);
	}

}
