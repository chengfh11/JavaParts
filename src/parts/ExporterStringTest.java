package parts;

import java.util.ArrayList;
import java.util.List;

public class ExporterStringTest
{

	private static boolean openI = false;
	private static boolean openU = false;

	public static void main(String[] args)
	{

		/*
		 * String s1 = "<i> The following passage is";
		 * String s2 = "an excerpt from the writings of a self-taught";
		 * String s3 = "naturalist who studied wolves in the wild.</i>";
		 */

		String s1 = "<b>A Picnic at the Orchestra</b>";

		String s2 = "Central Park in New York City has a proud";
		String s3 = "tradition of hosting <u>concerts for the public in the summer.(1) </u> <u>In";
		String s4 = "the 1880''s several years after the 843-acre park opened in the middle of";
		String s5 = "Manhattan (2)</u> working-class citizens effectively campaigned to hold Sunday";
		String s6 = "concerts in their park. They argued that music should be available to <u>";
		String s7 = "everyone. Not (3)</u> just to those who had the leisure of not working during";
		String s8 = "the week. Today, I enjoy the musical benefits <u>secured (4)</u>by those long-";
		String s9 = "ago New York City residents. There are two evenings of music in the park to";
		String s10 = "which I look forward more than any <u>other, of which these are: (5)</u>the";
		String s11 = "dates the New York Philharmonic performs on the Great Lawn. ";

		String s12 = "The Great Lawn is";
		String s13 = "an expanse of green grass in the heart of the park, which is itself surrounded";
		String s14 = "by skyscrapers. (6) Softball players young and old make use of the diamonds";
		String s15 = "that dot the edges of the <u>Lawn and families (7)</u> with small children";
		String s16 = "stretch out nearby for a picnic. Kite flyers and Frisbee throwers share space";
		String s17 = "in the middle of the Lawn. ";

		String s18 = "Two nights every summer, though, the Great Lawn";
		String s19 = "becomes a theater. The north end of the Lawn is transformed into a giant stage,";
		String s20 = "and the rest becomes seating for the audience. Early <u>in the afternoon, ";
		String s21 = "(8)</u> people begin to arrive with blankets and picnic baskets in tow. What begins";
		String s22 = "as a trickle turns into a flood of bodies streaming into the lawn. (9) Cell";
		String s23 = "phones chirp and buzz as friends locate each other among the thousands of";
		String s24 = "groups seated upon the Lawn. ";

		String s25 = "<u>The following day, (10)</u> just as dusk";
		String s26 = "arrives, the members of the New York Philharmonic take the stage and begin to";
		String s27 = "to tune their instruments. The orchestra strikes up the opening notes of a";
		String s28 = "Tchaikovsky concerto or a Dvorak symphony, and a hush falls over the";
		String s29 = "picnickers. For the next two hours, thousands of New Yorkers quietly munch on";
		String s30 = "sandwiches and salads as waves of music produced by one of the world''s greatest";
		String s31 = "orchestras wash over them. At the end of the performance I silently thank the";
		String s32 = "New Yorkers who, more than one hundred years ago, worked to make music in the";
		String s33 = "park accessible to everyone.";

		/*
		 * String s1 = "In recent years, however, a number of psychologists <u>have turned there</u>";
		 * String s2 = "attention away from illness and depression, choosing to focus instead on health";
		 * String s3 = "and happiness. Their work has gained the attention <u>of that group of people";
		 * String s4 = "we call the public. Kay Redfield Jamison, in Exuberance: The Passion for";
		 * String s5 = "Life, describes exuberance as a temperamental </u>trait. Through a series of";
		 * String s6 = "biographical <u>sketches fo both famous and less</u> <u>well-known figures,";
		 * String s7 = "Jamison</u> explores the nature of exuberance. <u>Her subjects, what </u>";
		 * String s8 = "<u>they have in common being</u> energy, passion, and a sense of plkay and joy";
		 * String s9 = "that guides their work and even recreation throughout their lives.";
		 * String s10 = "At one time, the word psychologist <u>may have evoked</u> an image of a";
		 * String s11 = "bespectacled and bearded doctor encouraging a reclining patient to explore her";
		 * String s12 = "deepest fears, <u>desires </u> <u>that felt repressed</u>, and darkest dreams.";
		 * String s13 = "The groundbreaking work of Dr. Sigmund Freud did indeed have a negative";
		 * String s14 = "orientation, focused on treating <u>patients who\'s</u> behavior showed symptoms";
		 * String s15 = "of emotional or mental illness. This orientation toward pathology directed the";
		 * String s16 = "work of psychologists for many decades.";
		 * String s17 = "<u>Another investigating psychologist, who finds value in healthy metal";
		 * String s18 = "states, </u> <u>Martin Seligman is one.</u> Seligman\'s work is guided by the";
		 * String s19 = "idea that the role of the psychologist is not simply to help people <u>in the";
		 * String s20 = "effort of avoiding</u> pain and pathology, but to help them attain feelings of";
		 * String s21 = "happiness, engagement, and fulfillment. Seligman <u>has </u> <u>encouraged</u>";
		 * String s22 = "his colleagues in academic psychology to focus research on these areas. He has";
		 * String s23 = "also written books accessible to a law audience, including Authentic Happiness,";
		 * String s24 = "Learned Optimism and the Optimistic Child.";
		 */

		List<String> paraPassage = new ArrayList<String>();
		paraPassage.add(s1);
		paraPassage.add(s2);
		paraPassage.add(s3);
		paraPassage.add(s4);
		paraPassage.add(s5);
		paraPassage.add(s6);
		paraPassage.add(s7);
		paraPassage.add(s8);
		paraPassage.add(s9);
		paraPassage.add(s10);
		paraPassage.add(s11);
		paraPassage.add(s12);
		paraPassage.add(s13);
		paraPassage.add(s14);
		paraPassage.add(s15);
		paraPassage.add(s16);
		paraPassage.add(s17);
		paraPassage.add(s18);
		paraPassage.add(s19);
		paraPassage.add(s20);
		paraPassage.add(s21);
		paraPassage.add(s22);
		paraPassage.add(s23);
		paraPassage.add(s24);
		paraPassage.add(s25);
		paraPassage.add(s26);
		paraPassage.add(s27);
		paraPassage.add(s28);
		paraPassage.add(s29);
		paraPassage.add(s30);
		paraPassage.add(s31);
		paraPassage.add(s32);
		paraPassage.add(s33);

		for (String fragment : paraPassage)
		{
			// System.out.println(paraPassage);
			fragment = balanceTags(fragment, "u");
			fragment = balanceTags(fragment, "i");

			System.out.println(fragment);
		}
	}

	public static String balanceTags(String s, String tag)
	{

		int fromIndex = 0;
		int uIndex = 0;
		int uCloseIndex = 0;
		boolean openTag = tag == "u" ? openU : openI;

		if (openTag && !s.contains("<" + tag + ">") && !s.contains("</" + tag + ">"))
		{
			s = "<" + tag + ">" + s + "</" + tag + ">";
		}
		while (uIndex != -1 && uCloseIndex != -1)
		{

			uIndex = s.indexOf("<" + tag + ">", fromIndex);
			uCloseIndex = s.indexOf("</" + tag + ">", fromIndex);
			if (uIndex == -1 && uCloseIndex != -1)
			{
				// apppend <u> at the beginning
				s = "<" + tag + ">" + s;
				openTag = false;
			}
			else if (uIndex != -1 && uCloseIndex == -1)
			{
				// apppend </u> at the end
				s = s + "</" + tag + ">";
				openTag = true;
			}
			else if (uIndex != -1 && uCloseIndex != -1)
			{
				if (uCloseIndex < uIndex)
				{
					// apppend <u> at the beginning
					s = "<" + tag + ">" + s;
					openTag = false;
				}
				fromIndex = Math.max(uCloseIndex, uIndex) + 1;
			}
		}
		openU = tag == "u" ? openTag : openU;
		openI = tag == "i" ? openTag : openI;
		return s;
	}

	public void main()
	{
		String s = "biographical <u>sketches fo both famous and less</u> <u>well-known figures,";
		int fromIndex = 0;
		int uIndex = 0;
		int uCloseIndex = 0;
		boolean openUnderline = true;

		if (openUnderline && !s.contains("<i>") && !s.contains("</i>"))
		{
			s = "<u>" + s + "</u>";
		}

		while (uIndex != -1 && uCloseIndex != -1)
		{

			uIndex = s.indexOf("<u>", fromIndex);
			uCloseIndex = s.indexOf("</u>", fromIndex);
			if (uIndex == -1 && uCloseIndex != -1)
			{
				// apppend </u> at the end
				s = "<u>" + s;
			}
			else if (uIndex != -1 && uCloseIndex == -1)
			{
				// apppend <u> at the beginning
				s = s + "</u>";
			}
			else if (uIndex != -1 && uCloseIndex != -1)
			{
				if (uCloseIndex < uIndex)
				{
					// apppend <u> at the beginning
					s = "<u>" + s;
				}
				fromIndex = Math.max(uCloseIndex, uIndex) + 1;
			}
		}
		System.out.println(s);
	}
}
