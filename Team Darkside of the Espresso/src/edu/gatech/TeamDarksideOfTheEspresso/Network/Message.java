/**
 * Network Protocol Message
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.Network;


public class Message
{	
	private String	Key;		// Message Key - Describes how the message should be handled
	private String	Data;		// Message Data - Describes what the message is for
	
	private Object	Attachment;	// Message Attachment - Any object(s) that should be transfered with the message
	
	
	/**
	 * Constructor
	 */
	public Message()
	{
		Key			= Network.MessageNull;
		Data		= Network.MessageNull;
		
		Attachment	= null;
	}
	
	
	/**
	 * 
	 * 
	 * @param Key
	 * @param Data
	 */
	public Message(String Key, String Data)
	{
		this.Key	= Key;
		this.Data	= Data;
		
		Attachment	= null;
	}
	
	
	public Message(String Key, String Data, Object Attachment)
	{
		this.Key		= Key;
		this.Data		= Data;
		
		this.Attachment = Attachment;
	}
	
	
	public String getKey()
	{
		return Key;
	}
	
	
	public String getData()
	{
		return Data;
	}
	
	
	public Object getAttachment()
	{
		return Attachment;
	}
	
	
	public void setKey(String Key)
	{
		this.Key = Key;
	}
	
	
	public void setData(String Data)
	{
		this.Data = Data;
	}
	
	
	public void setAttachment(Object Attachment)
	{
		this.Attachment = Attachment;
	}
}
