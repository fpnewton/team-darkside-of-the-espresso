/*
 * The Network Protocol Message Class.
 */

package network;

import java.io.Serializable;

/**
 * The Network Protocol Message Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Message implements Serializable {

	/** The message Key. */
	private MessageKey key; // Message Key - Describes how the message should be
	// handled

	/** The message Data. */
	private Object data; // Message Data - Describes what the message is for

	/**
	 * Constructor.
	 */
	public Message() {
		key = MessageKey.NULL;
		data = null;
	}

	/**
	 * Instantiates a new message.
	 * 
	 * @param key
	 *            The message key
	 */
	public Message(MessageKey key) {
		this.key = key;

		this.data = null;
	}

	/**
	 * Instantiates a new message.
	 * 
	 * @param key
	 *            The message key
	 * @param data
	 *            The message data
	 */
	public Message(MessageKey key, Object data) {
		this.key = key;
		this.data = data;
	}

	/**
	 * Gets the message key.
	 * 
	 * @return The message key
	 */
	public MessageKey getKey() {
		return key;
	}

	/**
	 * Gets the message data.
	 * 
	 * @return The message data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the message key.
	 * 
	 * @param key
	 *            The new message key
	 */
	public void setKey(MessageKey key) {
		this.key = key;
	}

	/**
	 * Sets the message data.
	 * 
	 * @param data
	 *            The new message data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets a String with the message's Key and Data.
	 * 
	 * @return A formatted String with the message's Key and Data
	 */
	public String toString() {
		return "Key: " + key.toString() + "\tData: " + data;
	}
}
