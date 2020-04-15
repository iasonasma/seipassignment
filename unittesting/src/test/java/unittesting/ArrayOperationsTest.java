package unittesting;


import math.ArrayOperations;
import math.MyMath;

import static org.junit.Assert.*;

import org.junit.Test;

import io.FileIO;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	FileIO files = new FileIO();
	MyMath maths = new MyMath();
	String source = "";
	ArrayOperations arrayoper = new ArrayOperations(files,source,maths);
	
	@Test
	public void test_emptyFileReverse_Mocking() {
		arrayoper.findPrimesInFile(files, "src/test/resources/fileiotest.txt", maths);
	}
	

}
