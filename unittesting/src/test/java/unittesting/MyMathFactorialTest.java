package unittesting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import math.MyMath;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MyMathFactorialTest { 

	@Parameter (value = 0)
	public int number;
	@Parameter (value = 1)
	public int expected;
	
	
	MyMath math = new MyMath();
	
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][] {{0 , 1},{1 , 1},{2 , 2},{12 , 479001600}};
		
		return Arrays.asList(data);
		
	}
	
	/* This test will check for the numbers 0,1,2,12 
	 * to see if we get the expected results
	 */
	@Test 
	public void getfactorialOfNeg() {
		Assert.assertEquals(expected, math.factorial(number));
		
	}

}