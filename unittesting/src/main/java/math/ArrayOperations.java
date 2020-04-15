package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	public  int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		List<Integer> numbersList = new ArrayList<>();
		for(int i : fileIo.readFile(filepath)) {
			if(myMath.isPrime(i))
			{
				numbersList.add(i);
			}
		}

		 return numbersList.stream().mapToInt(i -> i).toArray();
		
	}

}
