package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.*;

public class DemoClient {

	public static void main(String[] args) throws IOException {

		if(args.length < 5) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}
				
		MetricsAnalyzer exporter = new MetricsAnalyzer();
		exporter.calculateMetrics(args[0],args[1],args[2],args[3],args[4]);
	}

}
