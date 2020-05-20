package analyzermetrics;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import codeanalyzer.CsvParser;


public class CsvParserTest {
	
	CsvParser mex = new CsvParser();
	
	static List<String> listofstrings = new ArrayList<String>();
	private static   String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private static String OutputFilePath = "src/test/resources/output_metrics";

	//A method which setups the list we want to test our methods
	@Before
	public  void setUp() throws IOException {
		listofstrings.add("loc,noc,nom");
		listofstrings.add("7,3,3");
	}
	
	@Test
	public void testWriteCsv() {

		// generate and write the output file
		mex.writeToFile(listofstrings, OutputFilePath);
		
		// evaluate that the file exists
		File outputFile = new File(OutputFilePath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
		
	}
	

	
}