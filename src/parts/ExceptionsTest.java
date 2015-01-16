package junk;

import java.io.IOException;

public class ExceptionsTest
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		try
		{
			System.out.println("Try");
			throw new IllegalStateException();
		}
		catch (IllegalStateException ex)
		{
			System.out.println("Catch: " + ex);
			throw new IOException();
		}
		finally
		{
			System.out.println("Finally");
		}

	}

}
