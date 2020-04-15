package unittesting;

import math.MyMath;
import org.junit.Test;

public class MyMathTest {

	MyMath math = new MyMath();
	
	/* A test which will check if the 
	 * correct exception will be thrown if we give a negative
	 * number
	 */
	
	@Test(expected = IllegalArgumentException.class )
	public void test_negativeNumberFactorial() {
		math.factorial(-5);
	}
	
	
	/* A test which will check if if the
	 * correct exception will be thrown
	 * if we give a number bigger than 12
	 */
	@Test(expected = IllegalArgumentException.class )
	public void test_BiggerNumFactorial() {
		math.factorial(13);
	}
}
