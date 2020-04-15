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
	
	public  int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		List<Integer> primelist = new ArrayList<>();
	
		for(int i : fileIo.readFile(filepath)) {
			if(myMath.isPrime(i) )
			{
				primelist.add(i);
			}
		}
		
		 return primelist.stream().mapToInt(i -> i).toArray();
		
	}

}
