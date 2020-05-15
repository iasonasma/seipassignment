package codeanalyzer;

import java.util.List;

public  interface SourceCodeAnalyze {
	
	public int countLOC(List<String> codeslines);
	public int countNOM(List<String> codeslines);
	public int countNOC(List<String> codeslines);

}
