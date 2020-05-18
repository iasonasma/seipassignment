package analyzermetrics;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import codeanalyzer.FileReadWeb;

public class FileReadWebTest {

	
	FileReadWeb sfr = new FileReadWeb();
	private static List<String> expectedList;
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());

	}
	
	@Test
	public void testReadFileIntoListWeb() throws IOException {
		List<String> actualList = sfr.storeFileList(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}

}
