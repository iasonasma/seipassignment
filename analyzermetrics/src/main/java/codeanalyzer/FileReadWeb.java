package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileReadWeb implements FileReadIO {
	String line = null;
	BufferedReader reader = null;
	
	@Override
	public List<String> storeFileList(String pathfile) {
		List<String> lines = new ArrayList<>();
		URL url = null;
		try {
			url = new URL(pathfile);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
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

	@Override
	public String storeFileString(String pathfile) {
		StringBuilder sb = new StringBuilder();
		URL url = null;
		try {
			url = new URL(pathfile);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
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
		return sb.toString();
	}

}
