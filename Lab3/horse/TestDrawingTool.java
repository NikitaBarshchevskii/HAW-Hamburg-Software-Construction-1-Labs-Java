package horse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class TestDrawingTool {
	private JFrame applicationFrame;
	private JPanel buttonPanel;
	private DrawingArea drawingArea;
	private ArrayList<Integer> sizeCoef;

	public TestDrawingTool(String title) {
		applicationFrame = new JFrame(title);
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sizeCoef = new ArrayList<>();

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		createSizePanel(buttonPanel);
		createColorPanel(buttonPanel);
		createRefreshButton();

		drawingArea = new DrawingArea();
		
		createSplitPane(screenSize);

		applicationFrame.setVisible(true);
	}
	
	private void createSizePanel(JPanel buttonPanel) {
		JPanel sizePanel = new JPanel();
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		sizePanel.setBorder(BorderFactory.createTitledBorder("Sizes"));
		for (int i = 1; i <= 5; i++) {
			JCheckBox sizeOption = new JCheckBox("Size " + i);
			final int sizeCoefficient = i;
			sizeOption.addItemListener(e -> {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sizeCoef.add(sizeCoefficient);
				} else {
					sizeCoef.remove(Integer.valueOf(sizeCoefficient));
				}
			});
			sizePanel.add(sizeOption);
		}
		buttonPanel.add(sizePanel);
	}
	
	private void createColorPanel(JPanel buttonPanel) {
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
		for (HorseColor horseColor : HorseColor.values()) {
			JCheckBox colorOption = new JCheckBox(horseColor.name());
			colorOption.setBackground(horseColor.getColor());
			if (isDark(horseColor.getColor())) {
				colorOption.setForeground(Color.WHITE);
			}
			colorPanel.add(colorOption);
		}
		buttonPanel.add(colorPanel);
	}
	
	private void createRefreshButton() {
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(e -> drawingArea.refresh());
		buttonPanel.add(refreshButton, BorderLayout.CENTER);
	}
	
	private void createSplitPane(Dimension screenSize) {
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, drawingArea, buttonPanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(screenSize.width - 200);
		applicationFrame.add(splitPane, BorderLayout.CENTER);
	}

	private boolean isDark(Color color) {
		double brightness = (color.getRed() * 0.299) + (color.getGreen() * 0.587) + (color.getBlue() * 0.114);
		return brightness < 128;
	}

	public static void main(String[] args) {
		new TestDrawingTool("My horse");
	}
}