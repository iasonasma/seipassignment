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
