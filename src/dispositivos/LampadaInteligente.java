package dispositivos;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import zirk.eventos.CoresLuzesEvent;

public class LampadaInteligente extends RegistaDispositivo {

	public LampadaInteligente() {
		super(TipoProduto.LAMPADA_INTELIGENTE);
	}

	public static void main(String[] args) {
		
		LampadaInteligente smartBulbZirk = new LampadaInteligente();
		System.out.println("Lampada inteligente ativa");
        EventSet lightSignalEvents = new EventSet(CoresLuzesEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                if (event instanceof CoresLuzesEvent) {
                	System.out.println("Recebido o evento da cor da luz");
                }
            }
        };
        lightSignalEvents.setEventReceiver(eventReceiver);
        smartBulbZirk.bezirk.subscribe(lightSignalEvents);
        System.out.println("Subscrito aos eventos da luz inteligente");
	}

}
