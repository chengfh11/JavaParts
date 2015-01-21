package parts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.Fraction;
import org.apache.commons.lang.math.NumberUtils;

public class SectionItemTest
{

	public static void main(String[] args)
	{
		String s1 = "Section 1: ";
		String s2 = "Section 2: ";
		String s3 = "Section 3: ";
		String s4 = "Section 4: ";
		String s5 = "Section 5: ";
		String s6 = "Section 6: ";
		String s7 = "Section 7: ";
		String s8 = "Section 8: ";
		String s9 = "Section 9: ";
		String s10 = "Section 10:";

		List<String> sections = new ArrayList<String>();
		sections.add(s1);
		sections.add(s2);
		sections.add(s3);
		sections.add(s4);
		sections.add(s5);
		sections.add(s6);
		sections.add(s7);
		sections.add(s8);
		sections.add(s9);
		sections.add(s10);

		String answer = "0 < X < 0.5714";
		String actual = "0.572";

		/*
		 * for(Double str:getNumbersFromString(answer)){
		 * System.out.println("values: "+str);
		 * }
		 */

		// System.out.println("Correct? "+isCorrectAnswer(answer,getNumbersFromString(answer),Double.valueOf(actual)));
		// System.out.println("Time = "+(end-start)/10);

		String[][] testFractions = { { "1/2", "0.5" }, { "1/3", "0.333" }, { "1/4", "0.25" }, { "1/5", "0.20" }, { "1/6", "0.167" }, { "1/7", "0.142" }, { "1/8", "0.125" }, { "1/9", "0.11" },
				{ "2/3", "0.67" }, { "2/7", "0.2857" }, { "2/9", "0.222" }, { "3/7", "0.429" }, { "3/8", "0.375" }, { "3/9", "0.33" }, { "4/3", "1.33" }, { "107/250", "0.428" }, { "0.428", "0.428" },
				{ "5/4", "1.25" } };

		SectionItemTest test = new SectionItemTest();
		for (int i = 0; i < testFractions.length; i++)
		{
			System.out.println(test.isIntOrFractionAnswerCorrect(testFractions[i][1].trim(), testFractions[i][0].trim()));
		}

		/*
		 * for(String s:sections){
		 * String sectionIdStr = s.trim();
		 * System.out.println("l:"+sectionIdStr.length());
		 * if (sectionIdStr.length() == 10){
		 * sectionIdStr = s.substring(8, 9);
		 * }
		 * if (sectionIdStr.length() == 11){
		 * sectionIdStr = s.substring(8, 10);
		 * }
		 * int sectionId = 0;
		 * if (NumberUtils.isNumber(sectionIdStr))
		 * sectionId = Integer.parseInt(sectionIdStr);
		 * System.out.println(sectionId);
		 * }
		 */

	}

	public static List<Double> getNumbersFromString(String answer)
	{
		String[] answers = null;
		String splitCharacter = "or,<";
		String removeCharacter = "X,=,or,<";
		for (String str : Arrays.asList(splitCharacter.split(",")))
		{
			if (answer.contains(str))
			{
				answers = answer.split(str);
				break;
			}
		}
		List<Double> a = new ArrayList<Double>();
		if (answers != null)
		{
			for (String str : Arrays.asList(answers))
			{
				for (String removeStr : Arrays.asList(removeCharacter.split(",")))
				{
					str = StringUtils.remove(str, removeStr);
				}
				str = str.trim();
				if (NumberUtils.isNumber(str))
				{
					a.add(Double.valueOf(str.trim()));
				}
			}
		}
		return a;
	}

	public static boolean isCorrectAnswer(String correctAnswer, List<Double> correctAnswers, Double actualAnswer)
	{
		if (correctAnswer.contains("<") && correctAnswers.size() == 2)
		{
			for (Double dbl : correctAnswers)
			{
				if (dbl.equals(actualAnswer))
				{
					return false;
				}
			}
			correctAnswers.add(actualAnswer);
			Collections.sort(correctAnswers);
			return correctAnswers.get(1).equals(actualAnswer);
		}
		else
		{
			for (Double dbl : correctAnswers)
			{
				if (dbl.equals(actualAnswer))
				{
					return true;
				}
			}
		}
		return false;
	}

	public boolean isEqualToFraction(String actualAnswer, String correctAnswer, Double hola)
	{
		// System.out.println("correctAnswer: "+correctAnswer);
		// System.out.println("actualAnswer: "+actualAnswer);
		if (NumberUtils.isNumber(actualAnswer) && NumberUtils.isNumber(correctAnswer))
		{
			return Double.valueOf(actualAnswer).equals(Double.valueOf(correctAnswer));
		}
		int decimalPlaces = 2;
		String deltaString = ".";
		if (correctAnswer.split("\\.").length == 2)
		{
			decimalPlaces = correctAnswer.split("\\.")[1].length();
		}
		for (int i = 1; i < decimalPlaces; i++)
		{
			deltaString += "0";
		}
		deltaString += "1";

		// System.out.println("delta String:"+deltaString);

		String[] fractionParts = actualAnswer.trim().split("/");
		if (fractionParts.length != 2)
		{
			System.out.println("False");
		}
		else if (NumberUtils.isDigits(fractionParts[0]) && NumberUtils.isDigits(fractionParts[1]))
		{

			Fraction userFraction = Fraction.getFraction(Integer.valueOf(fractionParts[0]), Integer.valueOf(fractionParts[1]));
			DecimalFormat threePlaces = new DecimalFormat("#.####");
			// System.out.println("correctAnswer: "+correctAnswer);
			Double correctRespDec = Double.valueOf(correctAnswer);
			Double decimalValue = Double.valueOf(threePlaces.format(userFraction.doubleValue()));
			hola = decimalValue;
			Double roundedCorrectResp = Double.valueOf(threePlaces.format(correctRespDec));
			// System.out.println("roundedCorrectResp "+roundedCorrectResp);
			if (decimalValue.equals(roundedCorrectResp) || Math.abs(decimalValue - roundedCorrectResp) <= Double.valueOf(deltaString))
			{
				// System.out.println("True");
				// System.out.println("decimalValue: "+(decimalValue));
				// System.out.println("correctRespDec: "+correctRespDec);
				// System.out.println("delta: "+Math.abs(decimalValue - correctRespDec));
				return true;
			}
			else
			{
				// System.out.println("False");
				// System.out.println("decimalValue: "+(decimalValue));
				// System.out.println("correctRespDec: "+correctRespDec);
				// System.out.println("correctAnswer.contains(decimalValue.toString()) : "+correctAnswer.contains(decimalValue.toString()));
				// System.out.println("delta: "+Math.abs(decimalValue - correctRespDec));
				return false;
			}
		}
		// System.out.println("NaN");
		return false;
	}

	public boolean isCorrectTextAnswer(String correctAnswer, List<Double> correctAnswers, String actualAnswer)
	{
		System.out.println("isCorrectTextAnswer");
		Double numericActualAnswer = 0D;
		if (NumberUtils.isNumber(actualAnswer))
		{
			System.out.println("is number: " + numericActualAnswer);
			numericActualAnswer = Double.valueOf(actualAnswer);
		}
		else if (actualAnswer.contains("/"))
		{
			numericActualAnswer = getDecimalFromFraction(actualAnswer);
			System.out.println("is fraction: " + numericActualAnswer);
		}
		if (correctAnswer.contains("<") && correctAnswers.size() == 2)
		{
			System.out.println("is range check!");
			for (Double dbl : correctAnswers)
			{
				System.out.println("range value: " + dbl);
				if (dbl.toString().contains(numericActualAnswer.toString()) || Math.abs(numericActualAnswer - dbl) <= 0.001)
				{
					System.out.println("is equal to end, return false");
					return false;
				}
			}
			System.out.println("lets add the value to the collection!");
			correctAnswers.add(numericActualAnswer);
			System.out.println("collection unsorted!");
			Collections.sort(correctAnswers);
			System.out.println("collection sorted!");
			return correctAnswers.get(1).equals(numericActualAnswer);
		}
		else
		{
			System.out.println("its a direct value comparison!");
			for (Double dbl : correctAnswers)
			{
				System.out.println("value: " + dbl + " equal to: " + numericActualAnswer + "?");
				if (dbl.toString().contains(numericActualAnswer.toString()) || Math.abs(numericActualAnswer - dbl) <= 0.001)
				{
					System.out.println("value were equal, return true!");
					return true;
				}
			}
		}
		System.out.println("value weren't equal, return false!");
		return false;
	}

	public Double getDecimalFromFraction(String actualAnswer)
	{
		String[] fractionParts = actualAnswer.trim().split("/");
		if (fractionParts.length != 2)
		{
			// if(log.isWarnEnabled()) log.warn("The expression is not a fraction but still has a / in it");
			System.out.println("The expression is not a fraction but still has a / in it");
			return 0D;
		}
		else if (NumberUtils.isDigits(fractionParts[0]) && NumberUtils.isDigits(fractionParts[1]))
		{

			Fraction userFraction = Fraction.getFraction(Integer.valueOf(fractionParts[0]), Integer.valueOf(fractionParts[1]));
			DecimalFormat threePlaces = new DecimalFormat("#.####");
			Double decimalValue = Double.valueOf(threePlaces.format(userFraction.doubleValue()));
			// if(log.isInfoEnabled()) log.info("The fraction: "+actualAnswer+" has a decimal value of: "+decimalValue);
			return decimalValue;
		}
		// if(log.isInfoEnabled()) log.info("The string was NaN!");
		return 0D;
	}

	public boolean isIntOrFractionAnswerCorrect(String actualAnswer, String correctAnswer)
	{

		if (NumberUtils.isNumber(actualAnswer) && NumberUtils.isNumber(correctAnswer))
		{
			return Double.valueOf(actualAnswer).equals(Double.valueOf(correctAnswer));
		}
		int decimalPlaces = 2;
		String deltaString = ".";
		if (correctAnswer.split("\\.").length == 2)
		{
			decimalPlaces = correctAnswer.split("\\.")[1].length();
		}
		for (int i = 1; i < decimalPlaces; i++)
		{
			deltaString += "0";
		}
		deltaString += "1";

		Double decimalValue = getDecimalFromFraction(actualAnswer);
		System.out.println("decimalValue: " + decimalValue);

		if (decimalValue == 0D)
		{
			return false;
		}
		DecimalFormat threePlaces = new DecimalFormat("#.####");
		Double correctRespDec = Double.valueOf(correctAnswer);
		Double roundedCorrectResp = Double.valueOf(threePlaces.format(correctRespDec));
		/*
		 * System.out.println("roundedCorrectResp: "+roundedCorrectResp);
		 * System.out.println("delta: "+Math.abs(decimalValue-roundedCorrectResp));
		 * System.out.println("precision: "+deltaString);
		 */

		if (decimalValue.equals(roundedCorrectResp) || Math.abs(decimalValue - roundedCorrectResp) <= Double.valueOf(deltaString))
		{
			return true;
		}
		return false;
	}

}
