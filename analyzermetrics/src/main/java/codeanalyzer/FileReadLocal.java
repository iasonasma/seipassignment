package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadLocal implements FileReadIO {
	
	String line = null; 
	BufferedReader reader = null;
	File file = null;
	
	@Override
	public List<String> storeFileList(String pathfile) {
		List<String> lines = new ArrayList<>();
		this.file = new File(pathfile);
		if(file.length() == 0) {
			throw new IllegalArgumentException("Class must not be empty");
		} 
		try {
			this.reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;

	}



}
