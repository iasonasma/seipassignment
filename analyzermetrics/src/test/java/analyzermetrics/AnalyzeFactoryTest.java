package analyzermetrics;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import codeanalyzer.AnalyzeFactory;
import codeanalyzer.AnalyzeRegex;
import codeanalyzer.AnalyzeString;
import codeanalyzer.CsvParser;
import codeanalyzer.FileReadLocal;
import codeanalyzer.FileReadWeb;
import codeanalyzer.SourceCodeAnalyze;

public class AnalyzeFactoryTest {
	 AnalyzeFactory result = new AnalyzeFactory();
	 

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
	
	
}
