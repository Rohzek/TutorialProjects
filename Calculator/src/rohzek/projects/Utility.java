package rohzek.projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles file IO
 * @author Rohzek
 *
 */
public class Utility 
{
	static File file = new File("history.txt");
	
	public static void save(String history)
	{
		// Always initialize the writer as null beforehand
		FileWriter writer = null;
		
		try 
		{
			writer = new FileWriter(file);
			writer.write(history);
		}
		catch(IOException e)
		{
			System.out.println("Failed writing to file.");
		}
		finally // Always try to close the writer
		{
			try 
			{
				writer.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Failed closing writer.");
			}
		}
	}
	public static String load()
	{
		String history = "", line = null;
		// Always initialize the readers as null beforehand
		FileReader reader = null;
		BufferedReader bReader = null;
		
		try
		{
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			
			while((line = bReader.readLine()) != null) 
			{
                history += line + '\n';
            } 
		}
		catch(FileNotFoundException e)
		{
			System.out.println("x0: Failed to read file.");
		} 
		catch (IOException e) 
		{
			System.out.println("x1: Failed to read file.");
		}
		finally // Always try to close the reader
		{
			try 
			{
				/*
				 * As the BufferedReader is a wrapper for the FileReader itself
				 * then closing the BufferedReader ALSO closes the FileReader at the same time
				 * so you only need to close the outer wrapper.
				 */
				bReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Failed closing reader.");
			}
		}
		
		return history;
	}
}
