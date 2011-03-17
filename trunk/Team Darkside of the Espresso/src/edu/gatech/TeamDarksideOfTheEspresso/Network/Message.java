/**
 * The Network Protocol Message Class.
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.Network;

import java.io.Serializable;


public class Message implements Serializable
{	
	
	/** The message Key. */
	private MessageKey	Key;		// Message Key - Describes how the message should be handled
	
	/** The message Data. */
	private String		Data;		// Message Data - Describes what the message is for
	
	/** The message Attachment. */
	private Object		Attachment;	// Message Attachment - Any object(s) that should be transfered with the message
	
	
	/**
	 * Constructor.
	 */
	public Message()
	{
		Key			= MessageKey.NULL;
		Data		= null;
		
		Attachment	= null;
	}
	
	
	/**
	 * Instantiates a new message.
	 *
	 * @param Key The message key
	 * @param Data The message data
	 */
	public Message(MessageKey Key, String Data)
	{
		this.Key	= Key;
		this.Data	= Data;
		
		Attachment	= null;
	}
	
	
	/**
	 * Instantiates a new message.
	 *
	 * @param Key The message key
	 * @param Data The message data
	 * @param Attachment The message attachment
	 */
	public Message(MessageKey Key, String Data, Object Attachment)
	{
		this.Key		= Key;
		this.Data		= Data;
		
		this.Attachment = Attachment;
	}
	
	
	/**
	 * Gets the message key.
	 *
	 * @return The message key
	 */
	public MessageKey getKey()
	{
		return Key;
	}
	
	
	/**
	 * Gets the message data.
	 *
	 * @return The message data
	 */
	public String getData()
	{
		return Data;
	}
	
	
	/**
	 * Gets the message attachment.
	 *
	 * @return The message attachment
	 */
	public Object getAttachment()
	{
		return Attachment;
	}
	
	
	/**
	 * Sets the message key.
	 *
	 * @param Key The new message key
	 */
	public void setKey(MessageKey Key)
	{
		this.Key = Key;
	}
	
	
	/**
	 * Sets the message data.
	 *
	 * @param Data The new message data
	 */
	public void setData(String Data)
	{
		this.Data = Data;
	}
	
	
	/**
	 * Sets the message attachment.
	 *
	 * @param Attachment The new message attachment
	 */
	public void setAttachment(Object Attachment)
	{
		this.Attachment = Attachment;
	}
	
	
	/**
	 * Returns a String with the message's Key and Data.
	 * 
	 * @return A formatted String with the message's Key and Data
	 */
	public String toString()
	{
		return "Key: " + Key.toString() + "\tData: " + Data;
	}
}
