package codeanalyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRegex implements SourceCodeAnalyze{
	public int loc = 0;
	public int nom = 0;
	public int noc = 0;
	
@Override
public int countLOC(List<String> codeslines) {
	int nonCodeLinesCounter = 0;
	for(String sourceCode : codeslines) {
	   Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
       Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

       while (nonCodeLinesMatcher.find()) {
       	nonCodeLinesCounter++;
       }
	}
	loc = codeslines.size() - nonCodeLinesCounter;
       
	return loc; 
}

	@Override
	public int countNOM(List<String> codeslines) {
		for(String sourceCode: codeslines) {
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
        Matcher methodSignatures = pattern.matcher(sourceCode);
        while (methodSignatures.find()) {
        	nom++;
        } 
		}
		return nom;
		
	}

	@Override
	public int countNOC(List<String> codeslines) {
		for(String sourceCode : codeslines) {
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
        Matcher classSignatures = pattern.matcher(sourceCode);
        while (classSignatures.find()) {
        	noc++;
        }
		}
		return noc;
	}

}
