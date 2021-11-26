package lineCharts;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class LineChartTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(212, "Classes", "JDK 1.0");
		dataset.addValue(504, "Classes", "JDK 1.1");
		dataset.addValue(1520, "Classes", "SDK 1.2");
		dataset.addValue(1842, "Classes", "SDK 1.3");
		dataset.addValue(2991, "Classes", "SDK 1.4");

		JFreeChart chart = ChartFactory.createLineChart("Java Standard Class Library", // chart title
				"Release", // domain axis label
				"Class Count", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				true, // tooltips
				false // urls
		);

		// Subtitle is added at the default position (below the main title)
		chart.addSubtitle(new TextTitle("Number of Classes By Release"));

		TextTitle source = new TextTitle("Source: Java In A Nutshell (4th Edition) " + "by David Flanagan (O’Reilly)");
		// source.setFont(new Font("SansSerif", Font.PLAIN, 10));
		source.setPosition(RectangleEdge.BOTTOM);
		source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(source);

		chart.setBackgroundPaint(ChartColor.white);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(ChartColor.lightGray);
		plot.setRangeGridlinePaint(ChartColor.white);

		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		renderer.setShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);

		// change the auto tick unit selection to integer units only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		// create and display a frame...
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);

	}

}
