package controllers;

import static i18n.Messages.*;


import i18n.I18N;

public class Functionalities {

    public static void sendSMS(boolean speak) {
    	OutputController co = new OutputController(I18N.getString(MENSAGEM));
    	co.sendMessage();
    }
    
    /*public static NotificationWarning createNotificationWarning(String name, Date d, Date finald, int freq, Contact c) {
    	NotificationWarning nw = new NotificationWarning(name, d, finald, freq, c);
    	return nw;
    }
    public static NotificationWarning createNotificationWarning(String name, Date d, Date finald, int freq) {
    	NotificationWarning nw = new NotificationWarning(name, d, finald, freq);
    	return nw;
    }
    
    public static void sendEmergencyAlert(String m, ContactCatalog cc, boolean speak) {
    	EmergencyAlert ea = new EmergencyAlert(m, cc);
    	OutputController co = new OutputController(ea.toString(), speak);
    	co.sendMessage();
    }
    
    public static void sendEmergencyAlertPattern(String m, ContactCatalog cc, String local, String patName, boolean speak){
    	EmergencyAlert ea = new EmergencyAlert(m, cc, local, patName);
    	OutputController co = new OutputController(ea.toString(), speak);
    	co.sendMessage();
    }*/
}
