package session1;

public class StringCalculator {
	public int add(String numbers) throws CalculateException {
		// Did we get some input? Good! Lets calculate!
		if (numbers != "") {
			
			// Look for negative numbers
			if (numbers.contains("-")) {
				throw new CalculateException("Negatives not allowed");
			}

			// Do we need another delimiter?
			if (numbers.contains("//")) {
				numbers = numbers.replace("\n", "");
				String delimiter = String.valueOf(numbers.charAt(2));
				String[] split = numbers.split(delimiter);
				return Integer.parseInt(split[1]) + Integer.parseInt(split[2]);
			}

			// Replace all those \n with the standard delimiter
			numbers = numbers.replace("\n", ",");

			// Two delimiters? We can't have that
			if (numbers.contains(",,")) {
				throw new CalculateException("Two separators found.");
			}

			// A standard delimiter? Go ahead and calculate
			if (numbers.contains(",")) {
				String[] split = numbers.split(",");
				return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
			}
			
			// No delimiters? OK, you can have your number back them
			else {
				return Integer.parseInt(numbers);
			}
		}

		// No input? Then I got nothing to do.
		else {
			return 0;
		}
	}
}
