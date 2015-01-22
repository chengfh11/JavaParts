package parts;

import java.util.Scanner;

/**
 * @author fcheng
 * @date Jan 22, 2015
 */
public class FloydTriangle
{
	public static void main(String[] args)
	{
		System.out.println("check");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		try
		{
			int rows = in.nextInt();
			System.out.println("input > " + rows);
			printFloydTriangle(rows);
		}
		catch (Exception e)
		{
			System.out.println("error");
		}
	}

	protected static void printFloydTriangle(int rows)
	{
		for (int i = 1; i <= rows; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print("*");

			}
			System.out.println();
		}
	}
}