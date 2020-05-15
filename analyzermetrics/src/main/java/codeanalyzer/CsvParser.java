package codeanalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CsvParser implements FileParser {

	@Override
	public void writeToFile(List<String> totalmetrics, String outputsource) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(outputsource + ".csv"));
			for (String line : totalmetrics) {
				writer.write(line);
				writer.write(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
			System.out.println("Metrics saved in" + outputsource + ".csv");
		}
	}

}
