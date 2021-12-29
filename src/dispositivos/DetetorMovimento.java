package dispositivos;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import zirk.eventos.DetetorMovimentoEvent;

public class DetetorMovimento extends RegistaDispositivo {

	public DetetorMovimento() {
		super(TipoProduto.DETETOR_MOVIMENTO);
	}

	public static void main(String[] args) {
		DetetorMovimento detetorMovimentoZirk = new DetetorMovimento();
		System.out.println("Running Motion Detector Simulator");
        TimerTask task = new TimerTask() {
            public void run() {
            	String areaDetecao = "Area";
                LocalDateTime timestamp = LocalDateTime.now();
                DetetorMovimentoEvent motionDetectionEvent = new DetetorMovimentoEvent(areaDetecao, timestamp);
                detetorMovimentoZirk.bezirk.sendEvent(motionDetectionEvent);
                System.err.println("Published Motion Detection event");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 5000);
	}

}
