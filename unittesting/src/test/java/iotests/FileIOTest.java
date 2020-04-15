package iotests;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import io.FileIO;

public class FileIOTest{
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	FileIO files = new FileIO();
	int testarray[] = {5,7,7,3,2,9,4};

	@Test
	public void TestFileIO_validation() {
		String path = "src/test/resources/fileiotest.txt";
		Assert.assertArrayEquals(testarray, files.readFile(path));
	}
	
	@Test
	public void TestFileIO_input() {
		String path ="src/test/resources/fileiotestwithstring.txt";
		files.readFile(path);
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
	
	
	
}