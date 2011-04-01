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

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The message Key. */
    private MessageKey key; // Message Key - Describes how the message should be
			    // handled

    /** The message Data. */
    private String data; // Message Data - Describes what the message is for

    /** The message Attachment. */
    private Object attachment; // Message Attachment - Any object(s) that should
			       // be transfered with the message

    /**
     * Constructor.
     */
    public Message() {
	key = MessageKey.NULL;
	data = null;

	attachment = null;
    }

    /**
     * Instantiates a new message.
     * 
     * @param key
     *            The message key
     * @param data
     *            The message data
     */
    public Message(MessageKey key, String data) {
	this.key = key;
	this.data = data;

	attachment = null;
    }

    /**
     * Instantiates a new message.
     * 
     * @param key
     *            The message key
     * @param data
     *            The message data
     * @param attachment
     *            The message attachment
     */
    public Message(MessageKey key, String data, Object attachment) {
	this.key = key;
	this.data = data;

	this.attachment = attachment;
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
    public String getData() {
	return data;
    }

    /**
     * Gets the message attachment.
     * 
     * @return The message attachment
     */
    public Object getAttachment() {
	return attachment;
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
    public void setData(String data) {
	this.data = data;
    }

    /**
     * Sets the message attachment.
     * 
     * @param attachment
     *            The new message attachment
     */
    public void setAttachment(Object attachment) {
	this.attachment = attachment;
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
