package rohzek.projects;

import java.awt.EventQueue;

/**
 * Main driver class
 * @author Rohzek
 *
 */
public class Main 
{
	public static Calculator gui;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					gui = new Calculator();
					gui.setHistory(Utility.load());
				} 
				catch (Exception e) 
				{
					System.out.println("Failed to create GUI");
				}
			}
		});
	}
}
