import java.util.*;
import java.io.*;

public class CreditCardValidator
{
	public static void main(String[] args)
	{
		Scanner file = null;
		try
		{
			int validCount = 0;
			int invalidCount = 0;
			file = new Scanner( new File( "numbers.txt" ) );
			while(file.hasNext())
			{
				String input = file.nextLine();
				boolean isValid = validateCreditCardNumber(input);
				if(isValid)
				{
					validCount++;
				}
				
				else
				{
					invalidCount++;
				}
			}
			
			System.out.println("The amount of LEGAL numbers is, " + validCount + " and the amount of ILLEGAL numbers is, " + invalidCount);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			return;

		}
		finally
		{
			if (null != file)
			{
				file.close();
			}
		}

	}

	//Help from previous Codingbats and A+

	public static boolean validateCreditCardNumber(String str)
	{

		int[] ints = new int[str.length()];
		for(int i = 0; i < str.length(); i++)
		{
			ints[i] = Integer.parseInt(str.substring(i, i + 1));
		}

		for(int i = ints.length - 2; i >= 0; i = i - 2)
		{
			int j = ints[i];
			j = j * 2;
			if(j > 9)
			{
				j = j % 10 + 1;
			}

			ints[i] = j;
		}

		int sum = 0;

		for(int k = 0; k < ints.length; k++)
		{
			sum += ints[k];
		}

		return sum % 10 == 10;
	}
}
