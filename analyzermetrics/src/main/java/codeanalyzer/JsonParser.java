package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JsonParser implements FileParser{

	@Override
	public void writeToFile(List<String> totalmetrics, String outputsource) {
		// not needed for this assignment
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(outputsource + ".json"));
			for (String line : totalmetrics) {
				writer.write(line);
				writer.write(System.lineSeparator());
			}
			System.out.println("Metrics saved in" + outputsource + ".json");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
