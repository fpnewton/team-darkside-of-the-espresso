package edu.gatech.TeamDarksideOfTheEspresso.SystemLog;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;


public class SystemLog
{
	private static Logger SystemLogger = Logger.getLogger("edu.gatech.TeamDarksideOfTheEspresso");
	private static FileHandler	OutputFileHandler = null;
	
	
	public static void InitializeLogger()
	{
		ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
//        myLogger.addHandler(ch);
//        myLogger.setLevel(Level.ALL);
//        myLogger.setUseParentHandlers(false);
//        
//        
//        myLogger.info("In main");
	}
	
	
	public static void LogMessage(String Message) throws SecurityException, IOException
	{
		OutputFileHandler = new FileHandler();
	}
}
