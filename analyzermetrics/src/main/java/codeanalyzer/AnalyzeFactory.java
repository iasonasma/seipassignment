package codeanalyzer;

public class AnalyzeFactory {
	
	public static SourceCodeAnalyze createAnalyzer(String type) {
		SourceCodeAnalyze analyze = null;
		if(type.equals("regex")) {
			analyze = new AnalyzeRegex();
		}else if(type.equals("strcomp")) {
			analyze = new AnalyzeString();
		}
		return analyze;	
	}
	
	
	public static FileReadIO createReader(String filesource) {
		FileReadIO reader = null;
		if(filesource.equals("local"))
		{
			reader = new FileReadLocal();
		}else if(filesource.equals("web")) {
			reader = new FileReadWeb();
		}
		return reader;
	}
	
	public static FileParser createParser(String typeoutsourcefile) {
		FileParser parser = null;
		if (typeoutsourcefile.equals("csv")) {
			parser = new CsvParser();
		} else if (typeoutsourcefile.equals("json")) {
			parser = new JsonParser();
		}
		return parser;

	}
}
