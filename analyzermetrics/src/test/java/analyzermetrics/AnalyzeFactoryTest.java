package analyzermetrics;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;


import org.junit.Test;
import codeanalyzer.AnalyzeFactory;
import codeanalyzer.AnalyzeRegex;
import codeanalyzer.AnalyzeString;
import codeanalyzer.CsvParser;
import codeanalyzer.FileReadLocal;
import codeanalyzer.FileReadWeb;


public class AnalyzeFactoryTest {
	static AnalyzeFactory result = new AnalyzeFactory();
	 

	 // Test case to see if the factory will make a correct regex item
	@Test
	public  void testCreateRegexAnalyzer()  {
		AnalyzeRegex regex = (AnalyzeRegex) result.createAnalyzer("regex");
		assertThat(regex,is(AnalyzeRegex.class));
	}
		
	
	//Test case to see if the factory will make a correct strcomp item
	@Test
	public void testCreateStringAnalyzer() {
		AnalyzeString stringanalyzer = (AnalyzeString) result.createAnalyzer("strcomp");
		assertThat(stringanalyzer,is(AnalyzeString.class));
		
	}
	
	//Test case to see if the factory will make a correct local file reader
	@Test
	public void testCreateFileReadLocal() {
		FileReadLocal localread = (FileReadLocal) result.createReader("local");
		assertThat(localread,is(FileReadLocal.class));
	}
	
	//Test case to see if the factory will make a correct local file reader
	@Test
	public void testCreateFileReadWeb() {
		FileReadWeb localWeb = (FileReadWeb) result.createReader("web");
		assertThat(localWeb,is(FileReadWeb.class));
	}
	
	//Test case to see if the factory will make a correct csv parser
	public void testCreateCsvParser() {
		CsvParser csvparser = (CsvParser) result.createParser("csv");
		assertThat(csvparser,is(CsvParser.class));
	}
	
	//Test case to see if we have a different type other than strcomp and regex
	@Test(expected = IllegalArgumentException.class)
	public void testCreateAnalyzerWrongType () {
		result.createAnalyzer("random");
	}
	
	//Test case to see if we have a different type other than local or web
	@Test(expected = IllegalArgumentException.class)
	public void testFileReadWrongType () {
		result.createReader("random");
	}
	
	//Test case to see if we have a different type other than csv 
	@Test(expected = IllegalArgumentException.class)
	public void testCreateParserWrongType() {
		result.createParser("random");
	}
	
}
