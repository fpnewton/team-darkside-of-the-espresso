/**
 * System Logger
 * 
 * Receives all system log messages and stores them in a XML file according to the current date.
 * 
 * @author	Fraser P. Newton
 * @date	March 1, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.SystemLog;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;


public class SystemLog
{
	/**
	 * Sends log messages to a file with the current date as the file name.
	 * 
	 * @param Message	Message to send to the log
	 * @param LogLevel	Severity level of the log message
	 */
	public static boolean LogMessage(String Message, Level LogLevel)
	{
		boolean			doesFileExist		= false;
		
		BufferedWriter	writer 				= null;
		Date			date				= new Date();
		DateFormat		dateFormat			= new SimpleDateFormat("MM-dd-yy");
		File			file				= null;
		String			filePath			= "Logs/" + dateFormat.format(date) + ".xml";
		
		
		// Checks if the file exists
		file = new File(filePath);
		
		if (!file.exists())
		{
			doesFileExist = true;
		}
		
		// Attempt to create the buffered writer objects
		try
		{
			writer = new BufferedWriter(new FileWriter(filePath, true));
			
			
			if (doesFileExist)
			{
				writer.append(XmlFormatter.getXmlIDTag());
			}
			
			writer.append(XmlFormatter.getHead("log"));
			
			dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
			
			writer.append(XmlFormatter.FormatData("date", dateFormat.format(date)));
			
			dateFormat = new SimpleDateFormat("hh:mm:ss a z");
			
			writer.append(XmlFormatter.FormatData("time", dateFormat.format(date)));
			writer.append(XmlFormatter.FormatData("level", LogLevel.getName()));
			writer.append(XmlFormatter.FormatData("message", Message));
			
			writer.append(XmlFormatter.getTail("log"));
			
			
			writer.flush();
		}
		catch (IOException e)
		{
			// TODO Output error message
			e.printStackTrace();
		}
		
		return true;
	}
}
