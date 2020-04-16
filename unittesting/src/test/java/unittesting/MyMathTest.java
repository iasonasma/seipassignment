package unittesting;

import math.MyMath;

import org.junit.Assert;
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
	
	
	/* A test which will check if it will cause a exception
	 * from having a number less than 2
	 */
	@Test  (expected = IllegalArgumentException.class)
	public void TestisPrime() {
		math.isPrime(1);
	}
	
	
	/* (Optional test) A test which will check if
	 *  method isPrime will cause  a exception from having 
	 *  non prime number
	 */
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_true() {
		Assert.assertEquals(true, math.isPrime(9));
	}
	
	/* (Optional Test) A test will check if 
	 * method isPrime will work correctly 
	 */
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_false() {
		Assert.assertEquals(false,math.isPrime(5));
	}
	
	//Test case to see if isPrime returns true,to a prime number
	
	
	@Test
	public void TestisPrime_returns_true() {
		Assert.assertEquals(true,math.isPrime(13));
	}
	
	/*Test case to check if isPrime will return
	 * false to a non prime number
	 */
	@Test
	public void TestisPrime_returns_false() {
		Assert.assertEquals(false,math.isPrime(9));
	}
	
}
