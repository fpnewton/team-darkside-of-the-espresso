/*
 * System Logger
 * 
 * Receives all system log messages and stores them in a XML file
 *  according to the current date.
 */

package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * System Logger
 * 
 * Receives all system log messages and stores them in 
 * a XML file according to the current date.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class SystemLog {
	/**
	 * Sends log messages to a file with the current date as the file name.
	 * 
	 * @param message
	 *            Message to send to the log
	 * @param logLevel
	 *            Severity level of the log message
	 *            @return True, if successful
	 */
	public static boolean canLogMessage(String message, Level logLevel) {
		boolean doesFileExist = false;

		BufferedWriter writer = null;
		final Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
		File file = null;
		final String filePath = "Logs/" + dateFormat.format(date) + ".xml";

		// Checks if the file exists
		file = new File(filePath);

		if (!file.exists()) {
			doesFileExist = true;
		}

		// Attempt to create the buffered writer objects
		try {
			writer = new BufferedWriter(new FileWriter(filePath, true));

			if (doesFileExist) {
				writer.append(XmlFormatter.getXmlIDTag());
			}

			writer.append(XmlFormatter.getHead("log"));

			dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

			writer.append(XmlFormatter.formatData("date",
					dateFormat.format(date)));

			dateFormat = new SimpleDateFormat("hh:mm:ss a z");

			writer.append(XmlFormatter.formatData("time",
					dateFormat.format(date)));
			writer.append(XmlFormatter.formatData("level", logLevel.getName()));
			writer.append(XmlFormatter.formatData("message", message));

			writer.append(XmlFormatter.getTail("log"));

			writer.flush();
		} catch (IOException e) {
			// TODO Output error message
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return true;
	}

	/**
	 * toString() override.
	 * 
	 * @return A string.
	 */
	public String toString() {
		return this.getClass().getName();
	}
}
