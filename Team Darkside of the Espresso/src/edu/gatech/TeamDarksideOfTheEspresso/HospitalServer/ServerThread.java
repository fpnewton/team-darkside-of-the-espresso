
package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


public class ServerThread extends Thread
{
	private volatile boolean	isDone;


	public ServerThread()
	{
		isDone = false;
	}


	public void run()
	{
		// TODO Implement method
	}


	public boolean isRunning()
	{
		return !isDone;
	}
}
