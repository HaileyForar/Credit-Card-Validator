import java.util.*;
import java.io.*;

public class CreditCardValidator
	{

		public static void main(String[] args)
			{
//			  Scanner file = new Scanner( new File( "prnumbers.txt.dat" ) );
//			  int numberOfLines = file.nextInt();      
//			  file.nextLine();
//			  for(int i = 0; i < numberOfLines; i++ )
//			     {
//			       String input = file.nextLine();
//			     }

			}
//Help from previous Codingbats and A+
		
		public static void validateCreditCardNumber(String str)
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
			
			if(sum % 10 == 0)
				{
					System.out.println("This number, " + str + " is a legal number.");
				}
			
			else
				{
					System.out.println("This number," + str + " is NOT a legal number");
				}
		}

	}
