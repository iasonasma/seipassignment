package analyzermetrics;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import codeanalyzer.JsonParser;


public class JsonParserTest {
	
	JsonParser mex = new JsonParser();
	
	static List<String> listofstrings = new ArrayList<String>();
	private static String OutputFilePath = "src/test/resources/output_metrics";

	//A method which setups the list we want to test our methods
	@Before
	public  void setUp() throws IOException {
		listofstrings.add("loc,noc,nom");
		listofstrings.add("7,3,3");
	}
	@Test
	public void testWriteJSON() {

		// generate and write the output file
		mex.writeToFile(listofstrings, OutputFilePath);
		
		// evaluate that the file exists
		File outputFile = new File(OutputFilePath + ".json");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyList() {
		List<String> emptyList = new ArrayList<String>();
		mex.writeToFile(emptyList, OutputFilePath);
		File outputFile = new File(OutputFilePath + ".json");
		outputFile.delete();
	}

	
}