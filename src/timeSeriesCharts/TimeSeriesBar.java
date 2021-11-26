package timeSeriesCharts;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesBar extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeSeriesBar(final String title) {
		super(title);
		final TimeSeries s1 = new TimeSeries("Sunshine Hours");
		s1.add(new Month(1, 2005), 56.4);
		s1.add(new Month(2, 2005), 72.0);
		s1.add(new Month(3, 2005), 79.5);
		s1.add(new Month(4, 2005), 146.9);
		s1.add(new Month(5, 2005), 216.6);
		s1.add(new Month(6, 2005), 190.7);
		s1.add(new Month(7, 2005), 178.7);
		s1.add(new Month(8, 2005), 210.6);
		s1.add(new Month(9, 2005), 150.6);
		s1.add(new Month(10, 2005), 81.1);
		s1.add(new Month(11, 2005), 90.9);
		s1.add(new Month(12, 2005), 57.0);
		final TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		final JFreeChart chart = ChartFactory.createXYBarChart("Sunshine Hours - England & Wales", "Date", true,
				"Hours", dataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		final DateAxis dateAxis = (DateAxis) plot.getDomainAxis();
		dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
		final ChartPanel chartPanel = new ChartPanel(chart, false);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		this.setContentPane(chartPanel);
	}

	public static void main(final String[] args) {
		final TimeSeriesBar demo = new TimeSeriesBar("Time Series Bar Demo 3");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
