/*
 * The Class XmlFormatter.
 */

package log;

/**
 * The Class XmlFormatter.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class XmlFormatter {

	/**
	 * Format data.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatData(String key, String value) {
		final StringBuffer temp = new StringBuffer();

		temp.append("\t<" + key + ">");
		temp.append(value);
		temp.append("</" + key + ">\n");

		return temp.toString();
	}

	/**
	 * Gets the head.
	 * 
	 * @param value
	 *            the value
	 * @return the head
	 */
	public static String getHead(String value) {
		return "<" + value + ">\n";
	}

	/**
	 * Gets the tail.
	 * 
	 * @param value
	 *            the value
	 * @return the tail
	 */
	public static String getTail(String value) {
		return "</" + value + ">\n\n";
	}

	/**
	 * Gets the xml id tag.
	 * 
	 * @return the xml id tag
	 */
	public static String getXmlIDTag() {
		return 
		"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n";
	}

	/**
	 * toString() override.
	 * 
	 * @return A string
	 */
	public String toString() {
		return this.getClass().getName();
	}
}
