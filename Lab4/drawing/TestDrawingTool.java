package drawing;

import horse.HorseColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;


public class TestDrawingTool {
	private JFrame applicationFrame;
	private JPanel buttonPanel;
	private DrawingArea drawingArea;
	private JPanel sizePanel;
	private JPanel colorPanel;
	private ArrayList<Integer> sizeCoef;
	private ArrayList<HorseColor> colorCoef;


	public TestDrawingTool(String title) {
		applicationFrame = new JFrame(title);
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sizeCoef = new ArrayList<>();
		colorCoef = new ArrayList<>();


		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		JLabel menuLabel = new JLabel("Horse Attributes Menu");
		menuLabel.setFont(new Font(menuLabel.getFont().getName(), Font.BOLD, 20));
		buttonPanel.add(menuLabel);

		createControlButtons();
		createSizePanel(buttonPanel);
		createColorPanel(buttonPanel);

		drawingArea = new DrawingArea(sizeCoef, colorCoef, true, true);

		createSplitPane(screenSize);

		applicationFrame.setVisible(true);
	}

	private void createControlButtons() {
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		JCheckBox drawForestCheckbox = new JCheckBox("Draw the Forest");
		drawForestCheckbox.setSelected(true);
		//drawForestCheckbox.addItemListener(e -> drawingArea.setDrawForest(e.getStateChange() == ItemEvent.SELECTED));
		controlPanel.add(drawForestCheckbox);

		JCheckBox drawHorsesCheckbox = new JCheckBox("Draw the Horses");
		drawHorsesCheckbox.setSelected(true);
		drawHorsesCheckbox.addItemListener(e -> {
			boolean selected = e.getStateChange() == ItemEvent.SELECTED;
			//drawingArea.setDrawHorses(selected);
			sizePanel.setVisible(selected);
			colorPanel.setVisible(selected);
		});
		controlPanel.add(drawHorsesCheckbox);

		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(e -> {
			boolean drawHorses = drawHorsesCheckbox.isSelected();
			boolean drawForest = drawForestCheckbox.isSelected();
			drawingArea.refresh(sizeCoef, colorCoef, drawHorses, drawForest);
			//context.refresh(drawHorses, drawForest, sizeCoef, colorCoef);
		});
		controlPanel.add(refreshButton);

		applicationFrame.add(controlPanel, BorderLayout.NORTH);
	}

	private void createSizePanel(JPanel buttonPanel) {
		sizePanel = new JPanel();
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		sizePanel.setBorder(BorderFactory.createTitledBorder("Sizes"));
		for (int i = 1; i <= 5; i++) {
			JCheckBox sizeOption = new JCheckBox("Size " + i);
			sizeOption.setSelected(true); // Check the checkbox by default
			final int sizeCoefficient = i;
			sizeCoef.add(sizeCoefficient); // Add the size coefficient to sizeCoef
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
		System.out.println("Size coefficients: " + sizeCoef);
		System.out.println("Color coefficients: " + colorCoef);
	}

	private void createColorPanel(JPanel buttonPanel) {
		colorPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
		for (HorseColor horseColor : HorseColor.values()) {
			JCheckBox colorOption = new JCheckBox(horseColor.name());
			colorOption.setSelected(true);
			colorOption.setBackground(horseColor.getColor());
			colorCoef.add(horseColor);
			if (isDark(horseColor.getColor())) {
				colorOption.setForeground(Color.WHITE);
			}
			colorOption.addItemListener(e -> {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					colorCoef.add(horseColor);
				} else {
					colorCoef.remove(horseColor);
				}
			});
			colorPanel.add(colorOption);
		}
		buttonPanel.add(colorPanel);
		System.out.println("Color coefficients: " + colorCoef);
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