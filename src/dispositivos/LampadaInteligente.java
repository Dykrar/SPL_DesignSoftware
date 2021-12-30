package dispositivos;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import eventos.bezirk.LuzEvent;

public class LampadaInteligente extends RegistaDispositivo {

	public LampadaInteligente() {
		super(TipoProduto.LAMPADA_INTELIGENTE);
	}

	public static void main(String[] args) {
		
		LampadaInteligente lampadaInteligenteBezirk = new LampadaInteligente();
		System.out.println("Lampada inteligente ativa");
        EventSet luzEvents = new EventSet(LuzEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                if (event instanceof LuzEvent) {
                	System.out.println("Recebido o evento da cor da luz");
                }
            }
        };
        luzEvents.setEventReceiver(eventReceiver);
        lampadaInteligenteBezirk.bezirk.subscribe(luzEvents);
        System.out.println("Subscrito aos eventos da luz inteligente");
	}
}
