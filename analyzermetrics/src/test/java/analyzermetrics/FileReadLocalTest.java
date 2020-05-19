package analyzermetrics;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import codeanalyzer.FileReadLocal;

public class FileReadLocalTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	FileReadLocal sfr = new FileReadLocal();
	private static List<String> expectedList;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";

	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
	} 
	
	@Test
	public void testReadFileIntoListLocal() throws IOException {

		List<String> actualList = sfr.storeFileList(TEST_CLASS_LOCAL);
	
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileLocalEmpty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Error! Check if file exists and make sure the file is not empty!");
		sfr.storeFileList("src/test/resources/TestEmptyClass.java");
	} 
	
	 
}
