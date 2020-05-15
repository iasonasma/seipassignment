package codeanalyzer;

import java.io.IOException;
import java.util.List;

public interface FileReadIO {
	public List<String> storeFileList(String pathfile) ;
	public String storeFileString(String pathfile);
}
