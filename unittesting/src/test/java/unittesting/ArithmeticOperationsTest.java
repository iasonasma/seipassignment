package unittesting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import math.ArithmeticOperations;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations oper = new ArithmeticOperations();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/** Test case for Divide method.
	 * Will check if method divide will
	 * throw exception if denomitor is 0
	 */
	
	@Test(expected = ArithmeticException.class)
	public void GetZeroOnDivide() {
		oper.divide(3,0);
	}
	
	
	/** This test case will check if the
	 * correct exception will be thrown if
	 * we give a negative number
	 */
	@Test 
	public void getNegativeNumberX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		oper.multiply(-5, 3);
	}
	
	/**Test case to check if multiply will return exceptional
	 * if Y is negative
	 * 
	 */
	
	@Test 
	public void getNegativeNumberY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		oper.multiply(5, -3); 
	}
	
	/** Test case will check if multiply method
	 * will return the expected number
	 */
	
	@Test
	public void testMultiply() {
		Assert.assertEquals(4, oper.multiply(2,2));
	}
	
	
	/** Test case will check if multiply method
	 * can multtiply with 0 with a big integer
	 * 
	 */
	@Test
	public void testMultiplyWithZeroMaxValue() {
		Assert.assertEquals(0,oper.multiply(0, Integer.MAX_VALUE));
	}
	
	
	/** Test case to check if we will get return 0
	 * if we multiply a number with 0
	 */
	@Test
	public void testMultiplyWithZero() {
		Assert.assertEquals(0,oper.multiply(4, 0));
	}
	
	/** Test case will check if divide method
	 * will return the expected number
	 */
	
	@Test
	public void testDivide() {
		Assert.assertEquals(9, oper.divide(18,2),0);
	}
	 
	/**Test case to check if multiply will throw exception if
	 * number is too high to fit in a variable
	 * 
	 */
	@Test
	public void testMaxInteger() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		oper.multiply(3,Integer.MAX_VALUE);
		
	}
	

}
