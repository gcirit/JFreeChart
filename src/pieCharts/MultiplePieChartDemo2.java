package pieCharts;

import java.awt.BasicStroke;
import java.awt.Color;
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
 * This example is similar to {@link MultiplePieChartDemo1}, but slices the
 * dataset by column rather than by row.
 *
 */
public class MultiplePieChartDemo2 extends ApplicationFrame {

	/**
	 * Creates a new demo.
	 *
	 * @param title the frame title.
	 */
	public MultiplePieChartDemo2(final String title) {

		super(title);
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
		chartPanel.setPreferredSize(new java.awt.Dimension(600, 380));
		setContentPane(chartPanel);

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
				TableOrder.BY_COLUMN, true, // include legend
				true, false);
		final MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setOutlineStroke(new BasicStroke(1.0f));
		final JFreeChart subchart = plot.getPieChart();
		final PiePlot p = (PiePlot) subchart.getPlot();
		p.setBackgroundPaint(null);
		p.setOutlineStroke(null);
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
//        p.setLabelGenerator(new StandardPieItemLabelGenerator(
//            "{0} ({2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()
//        ));
		p.setMaximumLabelWidth(0.35);
		p.setLabelFont(new Font("SansSerif", Font.PLAIN, 9));
		p.setInteriorGap(0.30);
		return chart;
	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args ignored.
	 */
	public static void main(final String[] args) {

		final MultiplePieChartDemo2 demo = new MultiplePieChartDemo2("Multiple Pie Chart Demo 2");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
