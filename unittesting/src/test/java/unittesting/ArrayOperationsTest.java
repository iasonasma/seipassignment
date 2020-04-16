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
	
	/* Test case for findPrimeInFile, using mocking
	 * to check that it will return the valid array list
	 * 
	 */
	@Test 
	public void TestfindPrimesInFile_mocking() {
		when(files.readFile("test")).thenReturn(new int[] {7,11,13});
		when(maths.isPrime(7)).thenReturn(true);
		when(maths.isPrime(11)).thenReturn(true);
		when(maths.isPrime(13)).thenReturn(true);
		Assert.assertArrayEquals(new int[] {7, 11,13},arrayoper.findPrimesInFile(files, "test",maths));
	}

	
	/* Test case for findPrimeInFile, using mocking
	 * to check if it will return IllegalArgumentException when having
	 * number less than 2
	 */
	@Test  (expected = IllegalArgumentException.class)
	public void TestfindPrimeInFile_mocking_negative() {
		when(files.readFile("test")).thenReturn(new int[] {1,0,3});
		when(maths.isPrime(1)).thenThrow(new IllegalArgumentException());
		when(maths.isPrime(0)).thenThrow(new IllegalArgumentException());
		when(maths.isPrime(3)).thenReturn(true);
		arrayoper.findPrimesInFile(files, "test",maths);
	}
	


}
