package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadLocal implements FileReadIO {
	

	@Override
	public List<String> storeFileList(String pathfile) {
		String line = null; 
		BufferedReader reader = null;
		File file = new File(pathfile);
		List<String> lines = new ArrayList<>();
		if(file.length() == 0) {
			throw new IllegalArgumentException("Error! Check if file exists and make sure the file is not empty!");
		} 
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		return lines;

	}



}
