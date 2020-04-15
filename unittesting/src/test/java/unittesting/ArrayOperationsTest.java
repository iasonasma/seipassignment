package unittesting;


import math.ArrayOperations;
import math.MyMath;

import static org.junit.Assert.*;

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
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void TestfindPrimesInFile_mocking() {
		int[] mockingarray = new int[] {5,3,3,4,3};
		when(files.readFile("list")).thenReturn(mockingarray);
		arrayoper.findPrimesInFile(files, "list", maths);
	}
	


}
