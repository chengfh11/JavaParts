package parts;


public class Regex
{

	public static void main(String[] args)
	{				
		String input = "Print this";
		System.out.println(!input.matches("[^a-zA-Z0-9\\s]"));
	}
}
