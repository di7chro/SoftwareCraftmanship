package session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	public StringCalculator calculator = new StringCalculator();

	@Test
	public void empty_String_Return_Zero() {
		// Arrange
		String numbers = "";

		// Act
		int result = calculator.add(numbers);

		// Assert
		assertEquals(0, result);
	}

	@Test
	public void non_Empty_String_Return_3() throws Exception {
		String numbers = "3";
		
		int result = calculator.add(numbers);
		
		assertEquals(3, result);
	}
	@Test
	public void comma_Separated_Return_Sum() throws Exception {
		String numbers = "2,3";
		
		int result = calculator.add(numbers);
		
		assertEquals(5, result);
	}
	
	@Test
	public void handle_Newlines_As_Commas() throws Exception {
		String numbers = "4\n3";
		
		int result = calculator.add(numbers);
		
		assertEquals(7, result);
	}
	
	@Test
	public void double_Separators_Throws_Exception() throws Exception {
		try {
			calculator.add("4\n,5");
			fail();
		}catch (CalculateException e) {
			assertEquals("Two separators found.", e.getMessage());
		}
	}
	@Test
	public void handle_Other_Delimiters() throws Exception {
		String numbers = "//;\n5;6"; 
		
		int result = calculator.add(numbers);
		
		assertEquals(11, result);
	}
	@Test
	public void no_Negatives_Allowed() throws Exception {
		try {
			calculator.add("3,-4");
			fail();
		}catch (CalculateException e) {
			assertEquals("Negatives not allowed", e.getMessage());
		}
	}
}
