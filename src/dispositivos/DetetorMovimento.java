package dispositivos;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import eventos.bezirk.DetetorMovimentoEvent;

public class DetetorMovimento extends RegistaDispositivo {

	public DetetorMovimento() {
		super(TipoProduto.DETETOR_MOVIMENTO);
	}

	public static void main(String[] args) {
		DetetorMovimento detetorMovimentoBezirk = new DetetorMovimento();
		System.out.println("Detetor movimento ativo");
        TimerTask task = new TimerTask() {
            public void run() {
            	String areaDetecao = "Area";
                LocalDateTime timestamp = LocalDateTime.now();
                DetetorMovimentoEvent DetetorMovimentoEvent = new DetetorMovimentoEvent(areaDetecao, timestamp);
                detetorMovimentoBezirk.bezirk.sendEvent(DetetorMovimentoEvent);
                System.err.println("Enviado evento de detecao de movimento");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 8000);
	}
}
