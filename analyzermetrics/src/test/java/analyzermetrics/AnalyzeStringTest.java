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
import codeanalyzer.AnalyzeString;

public class AnalyzeStringTest {
	static AnalyzeString stringanalyze = new AnalyzeString();
	static List<String> listofstrings = new ArrayList<String>();
	private static   String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	
	@Before
	public  void setUp() throws IOException {
		listofstrings = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
	}
	
	@Test
	public  void testCalculateRegexLOC() throws IOException {
		assertEquals(7, stringanalyze.countLOC(listofstrings)); 
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3,stringanalyze.countNOM(listofstrings));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException{
		assertEquals(3,stringanalyze.countNOC(listofstrings));
	}

}
