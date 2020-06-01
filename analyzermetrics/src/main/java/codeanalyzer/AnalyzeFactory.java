package codeanalyzer;

public class AnalyzeFactory {
	
	/* This methods recieves the type of analyzer we want to create
	 * and makes the correct object and returns it
	 */
	public static SourceCodeAnalyze createAnalyzer(String type) {
		SourceCodeAnalyze analyze = null;
		if(type.equals("regex")) {
			analyze = new AnalyzeRegex();
		}else if(type.equals("strcomp")) {
			analyze = new AnalyzeString();
		} else {
			throw new IllegalArgumentException("Unknown type : " + type);
		}
		return analyze;	
	}
	
	/* This method recieves the type of FileRead ( local or web ) and
	 * returns a object of the type we want
	 * 
	 */
	public static FileReadIO createReader(String typereader) {
		FileReadIO reader = null;
		if(typereader.equals("local"))
		{
			reader = new FileReadLocal();
		}else if(typereader.equals("web")) {
			reader = new FileReadWeb();
		}else {
			throw new IllegalArgumentException("Unknown type : " + typereader);
		}
		return reader;
	}
	
	/* This method recieves the type of FileParser ( csv or json ) and 
	 * returns a object of the type we want 
	 * 
	 */
	public static FileParser createParser(String typeoutsourcefile) {
		FileParser parser = null;
		if (typeoutsourcefile.equals("csv")) {
			parser = new CsvParser();
		} else if (typeoutsourcefile.equals("json")) {
			parser = new JsonParser();
		}else {
			throw new IllegalArgumentException("Unknown type : " + typeoutsourcefile);
		}
		return parser;

	}
}
