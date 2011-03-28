/**
 * Hospital Client Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package client;


import java.awt.EventQueue;

import ui.LoginWindow;



public class Main
{	
	/**
	 * Hospital Client application entry point
	 * 
	 * @param args	Application arguments
	 * @throws		IOException 
	 */
	public static void main(String[] args)
	{
		ClientThread ct = new ClientThread();
		ct.start();
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LoginWindow window = new LoginWindow();
					
					window.getFrmLoginWindow().setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public String toString()
	{
		return "";
	}
}
