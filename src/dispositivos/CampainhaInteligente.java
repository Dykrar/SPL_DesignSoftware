package dispositivos;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import eventos.bezirk.CampainhaEvent;

public class CampainhaInteligente extends RegistaDispositivo {

    public CampainhaInteligente() {
        super(TipoProduto.CAMPAINHA_PORTA_INTELIGENTE);
    }
    public static void main(String[] args) {

        CampainhaInteligente campainhaInteligenteBezirk = new CampainhaInteligente();
        System.out.println("Campainha inteligente ativa");
        EventSet campainhaEvents = new EventSet(CampainhaEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                if (event instanceof CampainhaEvent) {
                    System.out.println("Recebido o evento de Campainha inteligente");
                }
            }
        };
        campainhaEvents.setEventReceiver(eventReceiver);
        campainhaInteligenteBezirk.bezirk.subscribe(campainhaEvents);
        System.out.println("Subscrito aos eventos da campainha inteligente");
    }
}