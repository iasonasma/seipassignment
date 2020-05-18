package analyzermetrics;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import codeanalyzer.AnalyzeRegex;

public class AnalyzeRegexTest {
	static AnalyzeRegex anregex = new AnalyzeRegex();
	static List<String> listofstrings = new ArrayList<String>();
	private static   String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	
	@Before
	public  void setUp() throws IOException {
		listofstrings = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
	}
	
	@Test
	public  void testCalculateRegexLOC() throws IOException {
		assertEquals(21, anregex.countLOC(listofstrings)); 
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3,anregex.countNOM(listofstrings));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException{
		assertEquals(3,anregex.countNOC(listofstrings));
	}

}
