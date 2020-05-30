package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvParser implements FileParser {


	//Recieves the list of metrics and a path to create the csv file
	@Override
	public void writeToFile(List<String> totalmetrics, String outputsource) {
		PrintWriter writer = null;
		if(totalmetrics.size() == 0) {
			throw new IllegalArgumentException("List is empty");
		}
		try {
			writer = new PrintWriter(new File(outputsource + ".csv"));
			for (String line : totalmetrics) {
				writer.write(line);
				writer.write(System.lineSeparator());
			}
			System.out.println("Metrics saved in" + outputsource + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}
