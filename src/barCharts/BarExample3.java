package barCharts;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarExample3 extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BarExample3(final String title) {
		super(title);
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, "Row 1", "Column 1");
		dataset.addValue(5.0, "Row 1", "Column 2");
		dataset.addValue(3.0, "Row 1", "Column 3");
		dataset.addValue(2.0, "Row 2", "Column 1");
		dataset.addValue(3.0, "Row 2", "Column 2");
		dataset.addValue(2.0, "Row 2", "Column 3");
		final JFreeChart chart = ChartFactory.createBarChart("Bar Demo 3", "Category", "Value", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);
		final BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, Color.gray);
		renderer.setSeriesPaint(1, Color.orange);
		renderer.setDrawBarOutline(false);
		final ChartPanel chartPanel = new ChartPanel(chart, false);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		this.setContentPane(chartPanel);
	}

	public static void main(final String[] args) {
		final BarExample3 demo = new BarExample3("Bar Demo 3");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
