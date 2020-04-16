package math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	private FileIO fileIo;
	private MyMath maths;
	private String source;

	
	public ArrayOperations(FileIO fileIo, String source , MyMath maths) {
		this.fileIo = fileIo;
		this.maths = maths;
		this.source = source;
	}
	
	/*Functions reads a text file with FileIO and returns
	 * and a array of only prime numbers from the text.
	 * @param FileIO object, filepath of text , MyMath Object
	 *@exception IllegalArgumentException if a number is less than 2
	 *@exception IllegalArgumentException when the given file does not exist
	 *@exception IllegalArgumentException when the given file is empty
	 *@exception IOException when an IO interruption occurs (not required to be tested)
	 *
	 * 
	 */
	public  int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath maths) {
		List<Integer> primelist = new ArrayList<>();
		int [] listofints = fileIo.readFile(filepath);
		boolean number;

		 
		for(int i : listofints) {
			 number = maths.isPrime(i);
			if(number)
			{
				primelist.add(i);
			}
		}
		
		 return primelist.stream().mapToInt(i -> i).toArray();
		
	}

}
