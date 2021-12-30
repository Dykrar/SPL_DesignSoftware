package controllers;

import static i18n.Messages.*;


import i18n.I18N;

public class Functionalities {

    public static void sendMessage() {
    	OutputController oc = new OutputController(I18N.getString(MENSAGEM));
    	oc.sendMessage();
    }
    public static void setTiming() {
    	OutputController oc = new OutputController(I18N.getString(TEMPO_DETECAO));
    	oc.sendMessage();
    }
}
