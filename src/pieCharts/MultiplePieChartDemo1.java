package pieCharts;

import java.awt.Font;
import java.text.AttributedString;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

/**
 * A simple demonstration application showing how to create a chart consisting
 * of multiple pie charts.
 *
 */
public class MultiplePieChartDemo1 extends ApplicationFrame {

	/**
	 * Creates a new demo.
	 *
	 * @param title the frame title.
	 */
	public MultiplePieChartDemo1(final String title) {

		super(title);
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
		chartPanel.setPreferredSize(new java.awt.Dimension(600, 380));
		setContentPane(chartPanel);

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return A sample dataset.
	 */
	private CategoryDataset createDataset() {
		final double[][] data = new double[][] { { 3.0, 4.0, 3.0, 5.0 }, { 5.0, 7.0, 6.0, 8.0 }, { 5.0, 7.0, 3.0, 8.0 },
				{ 1.0, 2.0, 3.0, 4.0 }, { 2.0, 3.0, 2.0, 3.0 } };
		final CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Region ", "Sales/Q", data);
		return dataset;
	}

	/**
	 * Creates a sample chart with the given dataset.
	 * 
	 * @param dataset the dataset.
	 * 
	 * @return A sample chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createMultiplePieChart("Multiple Pie Chart", // chart title
				dataset, // dataset
				TableOrder.BY_ROW, true, // include legend
				true, false);
		final MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
		final JFreeChart subchart = plot.getPieChart();
		final PiePlot p = (PiePlot) subchart.getPlot();
		p.setLabelGenerator(new PieSectionLabelGenerator() {

			@Override
			public String generateSectionLabel(PieDataset arg0, Comparable arg1) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public AttributedString generateAttributedSectionLabel(PieDataset arg0, Comparable arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		// p.setLabelGenerator(new PieSectionLabelGenerator("{0}"));
		p.setLabelFont(new Font("SansSerif", Font.PLAIN, 8));
		p.setInteriorGap(0.30);

		return chart;
	}

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is available *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args ignored.
	 */
	public static void main(final String[] args) {

		final MultiplePieChartDemo1 demo = new MultiplePieChartDemo1("Multiple Pie Chart Demo 1");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
