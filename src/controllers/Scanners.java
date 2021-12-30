package controllers;

import static i18n.Messages.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;


import i18n.I18N;

public class Scanners {
	
	//SCANNERS
	public static void createNotificationWarning(boolean speak, NotificationWarningCatalog nwc, ContactCatalog cc){
		OutputController co = new OutputController(I18N.getString(INSERT_ALERT_NAME), speak);
    	co.sendMessage();
    	
    	NotificationWarning nw;
    	Contact c;
		
    	Scanner sc = new Scanner(System.in);
    	String name = sc.nextLine();
    	
    	co.setMessage(I18N.getString(INSERT_INITIAL_DATE));
    	co.sendMessage();
    	LocalDateTime initial = LocalDateTime.parse(sc.next());
    	Date initialDate = java.sql.Timestamp.valueOf(initial);
    	
    	co.setMessage(I18N.getString(INSERT_FINAL_DATE));
    	co.sendMessage();
    	LocalDateTime dateTime = LocalDateTime.parse(sc.next());
    	Date finalDate = java.sql.Timestamp.valueOf(dateTime);
    	
    	co.setMessage(I18N.getString(INSERT_FREQUENCY));
    	co.sendMessage();
    	int freq = sc.nextInt();
    	
    	co.setMessage(I18N.getString(ADD_CONTACT));
    	co.sendMessage();
    	String bool = sc.next();
    	
    	if(bool.equals(I18N.getString(YES))) {
    		co.setMessage(I18N.getString(INSERT_CONTACT_NAME_ALERT));
        	co.sendMessage();
        	String contactName = sc.next();
        	c = cc.getcontactByName(contactName);
        	nw = Functionalities.createNotificationWarning(name, initialDate, finalDate, freq, c);
    	} else {
    		nw = Functionalities.createNotificationWarning(name, initialDate, finalDate, freq);
    	}
    	
    	nwc.addWarningToCatalog(nw);
    	co.setMessage(I18N.getString(ALERT_INSERTED));
    	co.sendMessage();
    	co.setMessage(I18N.getString(ALERT_TOSTRING, String.valueOf(nw.getInitial_date()), nw.getName()));
    	co.sendMessage();
    	
	}
}
