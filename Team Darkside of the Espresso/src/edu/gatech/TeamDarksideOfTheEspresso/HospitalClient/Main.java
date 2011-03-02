package edu.gatech.TeamDarksideOfTheEspresso.HospitalClient;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;


public class Main
{
	private static Logger myLogger = Logger.getLogger("edu.gatech.TeamDarksideOfTheEspresso");
	
	
	public static void main(String[] args)
	{
		ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        myLogger.addHandler(ch);
        myLogger.setLevel(Level.ALL);
        myLogger.setUseParentHandlers(false);
        
        
        myLogger.info("In main");
	}
}
