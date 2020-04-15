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
	
	@Test  (expected = IllegalArgumentException.class)
	public void TestisPrime() {
		math.isPrime(1);
	}
	
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_true() {
		Assert.assertEquals(true, math.isPrime(9));
	}
	
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_false() {
		Assert.assertEquals(false,math.isPrime(5));
	}
	
	@Test
	public void TestisPrime_returns_true() {
		Assert.assertEquals(true,math.isPrime(13));
	}
	
	@Test
	public void TestisPrime_returns_false() {
		Assert.assertEquals(false,math.isPrime(9));
	}
	
}
