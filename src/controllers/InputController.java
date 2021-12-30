package controllers;

import i18n.I18N;

import static i18n.Messages.*;

import java.text.ParseException;
import java.util.Scanner;

import com.bezirk.middleware.Bezirk;

import dispositivos.BotaoInteligente;
import dispositivos.CampainhaInteligente;
import dispositivos.DetetorMovimento;
import dispositivos.LampadaInteligente;


public class InputController {
	private String input;
	
    public InputController(String mgs) throws ParseException {
        this.input = mgs;

        switch(input) {
            case "p1":
            	runProduct1();
                break;
            case "p2":
            	runProduct2();
                break;
            case "p3":
            	runProduct3();
                break;
            case "p4":
            	runProduct4();
                break;
            case "exit":
                System.out.println("Programa a terminar");
                System.exit(0);
                break;
        }

    }
    
    public void switchPT() {
        System.out.println("\n");
    }

    public void switchUS() {
        System.out.println("\n");
    }
    
    
    // RUNNERS
    
    public void runProduct1() throws ParseException {
    	switchPT();
    	String [] lista_func = {I18N.getString(TOCAR_CAMPAINHA),
    			I18N.getString(TEMPO_DETECAO)};
    	executeProduct(lista_func);
    }
    
    public void runProduct2() throws ParseException {
    	switchPT();
    	String [] lista_func = {};
    	executeProduct(lista_func);
    }
    
    public void runProduct3() throws ParseException {
    	switchUS();
    	String [] lista_func = {};
    	executeProduct(lista_func);
    }
    
    public void runProduct4() throws ParseException {
    	switchUS();
    	String [] lista_func = {};
    	executeProduct(lista_func);
    }
    
    
    public void executeProduct(String [] list_func) throws ParseException {
    	
      	
		OutputController co = new OutputController(I18N.getString(FUNCIONALIDADES_MSG));
    	co.sendMessage();
      	
      	for (int i=0; i<list_func.length; i++) {
      		co.setMessage("- " + list_func[i]);
      		co.sendMessage();
      	}
      	
      	co.setMessage(I18N.getString(ESCOLHA));
      	co.sendMessage();
      	      	
      	Scanner scanner = new Scanner(System.in);
      	String string;
      	
      	while(true) {
      		string = scanner.nextLine();
      		switch(string) {
      			case "Tocar a Campainha":
      			case "Ring the bell":
      				new CampainhaInteligente();
      			break;
	      		case "Enviar Alerta com botao":
	      		case "Send Emergency Alert with button":
	      			new BotaoInteligente();
	      			break;
	      		case "Enviar Alerta Baseando no movimento":
	      		case "Send Alert Based on activity":
	      			new DetetorMovimento();
	      			break;
	      		case "Ligar a Luz automaticamente":
	      		case "Turn on lamp automatically":
	      			new LampadaInteligente();
	      			break;
	      		case "exit":
	      		case "sair":
	      			System.exit(0);
	      		default:
	      			co.setMessage(I18N.getString(CLOSING));
	      			co.sendMessage();
      		}
      	}  	
      	
    }
}
