package dispositivos;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import eventos.bezirk.DetetorAberturaPortaEvent;

public class DetetorAberturaPorta extends RegistaDispositivo {
	
	public DetetorAberturaPorta() {
		super(TipoProduto.DETETOR_ABERTURA_FECHO_PORTA);
	}
	
	public static void main(String[] args) {
		DetetorAberturaPorta detetorAberturaPortaBezirk = new DetetorAberturaPorta();
		System.out.println("Detetor abertura porta ativo");
        TimerTask task = new TimerTask() {
            public void run() {
            	int tempoAberta = 0;
                LocalDateTime timestamp = LocalDateTime.now();
                DetetorAberturaPortaEvent detetorAberturaPortaEvent = new DetetorAberturaPortaEvent(tempoAberta, timestamp);
                detetorAberturaPortaBezirk.bezirk.sendEvent(detetorAberturaPortaEvent);
                System.err.println("Enviado evento de detecao de abertura de porta");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 5000);
	}
}
