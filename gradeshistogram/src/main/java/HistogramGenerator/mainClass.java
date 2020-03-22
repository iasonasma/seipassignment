package histogramgenerator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Mainclass {



	public void generateChart(int[] dataValues) {
	

		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries data = new XYSeries("random values");

		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		
		dataset.addSeries(data);

		boolean legend = false; 
		boolean tooltips = false;
		boolean urls = false; 


		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();

		frame.setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
	
		int[] list = new int[11];
		File file = new File(args[0]);
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			list[input.nextInt()] += 1;
		}
		Mainclass demo = new Mainclass();
		demo.generateChart(list);

	}
}