package codeanalyzer;

import java.util.List;

public class AnalyzeString implements SourceCodeAnalyze{
	int loc = 0;
	int nom = 0;
	int noc = 0;
	
	@Override
	public int countLOC(List<String> codeslines) {
		int nonCodeLinesCounter = 0;
		for (String line : codeslines) {
			line = line.trim(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		loc = codeslines.size() - nonCodeLinesCounter;
		return loc; 
	}

	@Override
	public int countNOM(List<String> codeslines) {
		for (String line : codeslines) {
			line = line.trim(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				nom++;
		}
		return nom; 
	}

	@Override
	public int countNOC(List<String> codeslines) {
		int noc = 0;
		for (String line : codeslines) {
			line = line.trim(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				noc++;
			}
		}
		return noc; 
	}

}
