package dispositivos;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import eventos.bezirk.BotaoInteligenteEvent;

public class BotaoInteligente extends RegistaDispositivo {

	public BotaoInteligente() {
		super(TipoProduto.BOTAO_INTELIGENTE);
	}

	public static void main(String[] args) {

		BotaoInteligente botaoInteligenteBezirk = new BotaoInteligente();
		System.out.println("Botao inteligente ativo");
		EventSet botaoEvents = new EventSet(BotaoInteligenteEvent.class);
		EventReceiver eventReceiver = new EventSet.EventReceiver() {
			@Override
			public void receiveEvent(Event event, ZirkEndPoint sender) {
				if (event instanceof BotaoInteligenteEvent) {
					System.out.println("Recebido o evento do botao inteligente");
				}
			}
		};
		botaoEvents.setEventReceiver(eventReceiver);
		botaoInteligenteBezirk.bezirk.subscribe(botaoEvents);
		System.out.println("Subscrito aos eventos do botao inteligente");
	}
}
