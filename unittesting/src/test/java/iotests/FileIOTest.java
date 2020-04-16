package iotests;


import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import io.FileIO;
import math.MyMath;


public class FileIOTest{
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	MyMath maths = new MyMath();
	FileIO files = new FileIO();

	

	int testarray[] = {5,7,7,3,2,9,4};
	
	/*Test case to check if FileIO returns correct array
	 * 
	 */
	@Test
	public void TestFileIO_validation() {
		String path = "src/test/resources/fileiotest.txt";
		Assert.assertArrayEquals(testarray, files.readFile(path));
	}
	
	/*Test case to check if FileIO is correctly functional
	 * 
	 */
	@Test
	public void TestFileIO() {
		String path = "src/test/resources/fileiotest.txt";
		files.readFile(path);
	}
	
	/*Test case to check if FileIO will throw
	 * exception when path is incorrect
	 * 
	 */
	@Test 
	public void TestFileIO_not_exist() {
		String path = "src/test/resources/whatever";
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		files.readFile(path); 
	}
	
	/*Test case to check if FileIO will throw exception
	 * when file is empty
	 * 
	 */
	@Test 
	public void TestFileIO_is_empty() {
		String path = "src/test/resources/fileioisempty.txt";
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		files.readFile(path);
		
	
	}
	
	/*Test case to check that FileIO will ignore chars and doubles
	 * 
	 */
	@Test 
	public void testReadFileContainsInvalidEntries() {
		String path = "src/test/resources/fileioinvalidentries.txt";
		for (int i : files.readFile(path)) {
			assertThat(i,is(int.class));
	 	}
	} 
	 
	

	
	
}