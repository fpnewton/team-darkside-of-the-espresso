/**
 * Hospital Client Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.HospitalClient;


import java.awt.EventQueue;

import edu.gatech.TeamDarksideOfTheEspresso.UI.LoginWindow;


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
