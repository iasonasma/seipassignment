package codeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class MetricsAnalyzer {
	public void calculateMetrics(String pathfile, String method, String filesource, String pathfileoutsource, String typeoutsourcefile)
	{
		int linesCode;
		int classNumber;
		int methodsNumber;
		List<String> metrics = new ArrayList<String>();
		List<String> codelines = new ArrayList<>();
		AnalyzeFactory factory = new AnalyzeFactory();
		FileReadIO reader = factory.createReader(filesource);
		SourceCodeAnalyze analyzer = factory.createAnalyzer(method);
		FileParser parser = factory.createParser(typeoutsourcefile);
		try {
			codelines = reader.storeFileList(pathfile);
		}catch(Exception e) { 
			e.printStackTrace();
		}
		
		linesCode = analyzer.countLOC(codelines);
		classNumber = analyzer.countNOC(codelines);
		methodsNumber = analyzer.countNOM(codelines);
		metrics = MetricsAnalyzer.writeToFile(linesCode, classNumber, methodsNumber);	
		
		parser.writeToFile(metrics, pathfileoutsource);
		
	}
	
	
	public static List<String> writeToFile(int linesCode, int classNumber, int methodsNumber) {
		List<String> list = new ArrayList<String>();
		list.add("loc,noc,nom");
		list.add(String.valueOf(linesCode) + "," + String.valueOf(classNumber) + "," + String.valueOf(methodsNumber));	
		return list;		
	}

}
