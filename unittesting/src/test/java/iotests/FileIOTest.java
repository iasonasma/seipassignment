package iotests;


import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import io.FileIO;
import math.MyMath;

import java.util.stream.IntStream; 
public class FileIOTest{
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	MyMath maths = new MyMath();
	FileIO files = new FileIO();
	int testarray[] = {5,7,7,3,2,9,4};

	@Test
	public void TestFileIO_validation() {
		String path = "src/test/resources/fileiotest.txt";
		Assert.assertArrayEquals(testarray, files.readFile(path));
	}
	
	@Test
	public void TestFileIO() {
		String path = "src/test/resources/fileiotest.txt";
		files.readFile(path);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void TestFileIO_not_exist() {
		String path = "src/test/resources/whatever";
		files.readFile(path);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void TestFileIO_is_empty() {
		String path = "src/test/resources/fileioisempty.txt";
		files.readFile(path);
		
	}
	
	@Test 
	public void testReadFileContainsInvalidEntries() {
		String path = "src/test/resources/fileioinvalidentries.txt";
		for (int i : files.readFile(path)) {
			assertThat(i,isA(int.class));
		}
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void TestisPrime() {
		maths.isPrime(1);
	}
	
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_true() {
		Assert.assertEquals(true, maths.isPrime(9));
	}
	
	@Test (expected = AssertionError.class)
	public void TestisPrime_returns_opposite_false() {
		Assert.assertEquals(false,maths.isPrime(5));
	}
	
	@Test
	public void TestisPrime_returns_true() {
		Assert.assertEquals(true,maths.isPrime(13));
	}
	
	@Test
	public void TestisPrime_returns_false() {
		Assert.assertEquals(false,maths.isPrime(9));
	}
	
}