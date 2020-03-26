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

/***
 * 
 * @author iasonasma This is the second assignment for SEIP.
 *	It's a simple  class to demostrate scenario of JFreeChart XYLine.
 * @since May 2019 
 */

public class Mainclass {

	/***
	 * Input ->  A single dimension Integer array which includes datasets of grades.
	 * Output -> Visualization of the array with the use of datasets and presented in the screen  via Chart.
	 * 
	 * @param dataValues -> Single dimension integer array
	 */

	public void generateChart(int[] dataValues) {
	
		/**
		 * Calling contructor to contruct an empty dataset.
		 * It is used to represent a set of XYSeries object,which can be used as
		 * a dataset.
		 *
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();

		
		/*
		 * Creates a new XYSeries where many datasets can be loaded.
		 * 
		 */
		XYSeries data = new XYSeries("random values");

		
		
		/*
		 * A loop to add every data object from the
		 * single dimension array to our XYSeries
		 * 
		 * 
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		
		dataset.addSeries(data);

		boolean legend = false; 
		boolean tooltips = false;
		boolean urls = false; 

		/*
		 * Creates a chart with specific parametres
		 * 
		 * @param 
		 * 	-title of chart
		 * 	- label for X
		 *  - label for Y
		 *  - dataset for the chart
		 *  - orientation option ( horizontal or vertical ). Must not be null
		 *  - flag whether or not a legend is required
		 *  - optional : tooltips
		 *  - optional : urls chat might generate 
		 *
		 */
		JFreeChart chart = ChartFactory.createXYLineChart("Histogram Generator", "Grades", "Epanaemfanish", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		/*
		 * Preparing a frame for displaying our chart
		 * 
		 * @params
		 * - title
		 * - the chart
		 * 
		 */
		ChartFrame frame = new ChartFrame("HistogramGenerator", chart);
		frame.pack();
		
		//makes our chart frame visible
		frame.setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		/***
		 * Receives the text file with grades ,initialiaze a single dimension array and filling it
		 * with grades info. 
		 * @param path of a text file ( where grades are included)
		 * @throws FileNotFoundException if file is not found
		 * 
		 */
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
