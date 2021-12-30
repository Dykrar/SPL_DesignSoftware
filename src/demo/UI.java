package demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

import demo.InputController;

public class UI {

	public static void main(String[] args) { 
		try {
			
			//turn off verbose
			Logger cmRootLogger = Logger.getLogger("default.config");
			cmRootLogger.setLevel(java.util.logging.Level.OFF);
			String conFile = System.getProperty("java.util.logging.config.file");
			if (conFile == null) {
			      System.setProperty("java.util.logging.config.file", "ignoreAllSphinx4LoggingOutput");
			}
			  
            Thread.sleep(350);
            System.out.println("Bem vindo ao nosso projeto!");
            System.out.println("Pode agora escolher o producto a exprimentar para tal basta escrever o p + numero(EX: p3).");
            System.out.println("Os produtos sao:");
            System.out.println("1. ---> Campainha");
            System.out.println("2. ---> Botao");
            System.out.println("3. ---> Detetor Movimento");
            System.out.println("4. ---> Lampada");
            System.out.println("Escolha um numero ou escreva exit.");

            @SuppressWarnings({ "resource"})
			Scanner in = new Scanner(System.in); 
            String s = "";
            s = in.nextLine(); 

            String[] strings = {"p1", "p2", "p3", "p4", "exit"};

            if(Arrays.stream(strings).anyMatch(s::equals)) {
                System.out.println("Voce escolheou " + s);
                new InputController(s);
            } else {
                System.out.println("Escolha um produto valido.");
                while(!Arrays.stream(strings).anyMatch(s::equals)) {
                    @SuppressWarnings("resource")
					Scanner in2 = new Scanner(System.in); 
                    s = in2.nextLine();

                    if(Arrays.stream(strings).anyMatch(s::equals)) {
                        System.out.println("Voce escolheou " + s);
                        new InputController(s);
                    } else {
                        System.out.println("Escolha um produto valido.");
                    }

                }
            }
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}
	
	public static void printMessage(String mgs) {
        {
            System.out.println(mgs);
        }
    }
}
