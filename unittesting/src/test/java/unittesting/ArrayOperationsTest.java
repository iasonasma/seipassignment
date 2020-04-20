package unittesting;


import math.ArrayOperations;
import math.MyMath;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import io.FileIO;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	FileIO files = mock(FileIO.class);
	MyMath maths = mock(MyMath.class);
	String source = "";
	ArrayOperations arrayoper = new ArrayOperations(files,source,maths);
	
	/** Test case for findPrimeInFile, using mocking
	 * to check that it will return the valid array list
	 * 
	 */
	@Test  
	public void testFindPrimesInFileMockingValid() {
		when(files.readFile("test")).thenReturn(new int[] {7,11,13});
		when(maths.isPrime(7)).thenReturn(true);
		when(maths.isPrime(11)).thenReturn(true);
		when(maths.isPrime(13)).thenReturn(true);
		Assert.assertArrayEquals(new int[] {7, 11,13},arrayoper.findPrimesInFile(files, "test",maths));
	}

	
	/** Test case for findPrimeInfile , using mocking
	 * to check a list with non prime numbers too
	 *
	 */
	
	@Test 
	public void testFindPrimesInFileMockingInvalid() {
		when(files.readFile("test")).thenReturn(new int[] {7,6,12,13});
		when(maths.isPrime(7)).thenReturn(true);
		when(maths.isPrime(6)).thenReturn(false);
		when(maths.isPrime(12)).thenReturn(false);
		when(maths.isPrime(13)).thenReturn(true);
		Assert.assertArrayEquals(new int[] {7,13},arrayoper.findPrimesInFile(files, "test", maths));
		
	}



}
