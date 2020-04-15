package iotests;


import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import io.FileIO;
import math.ArrayOperations;
import math.MyMath;


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
			assertThat(i,is(int.class));
	 	}
	} 
	 
	

	
	
}