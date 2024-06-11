package horse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage sceneImage;
	private Scene myScene;
	private int numberOfHorses = 50;

	public DrawingArea(ArrayList<Integer> sizeCoef, ArrayList<HorseColor> colorCoef) {
		super();
		myScene = new Scene(numberOfHorses, sizeCoef, colorCoef);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		sceneImage = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);
		Graphics imageGraphics = sceneImage.getGraphics();
		imageGraphics.setColor(getBackground());
		imageGraphics.fillRect(0, 0, sceneImage.getWidth(), sceneImage.getHeight());
		drawScene();
	}

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		pen.drawImage(sceneImage, 0, 0, null);
	}

	public void refresh(ArrayList<Integer> sizeCoef, ArrayList<HorseColor> colorCoef) {
		System.out.println("Size coefficients: " + sizeCoef); // Print the contents of sizeCoef
		myScene.reset(numberOfHorses, sizeCoef, colorCoef);
		Graphics imageGraphics = sceneImage.getGraphics();
		imageGraphics.setColor(getBackground());
		imageGraphics.fillRect(0, 0, sceneImage.getWidth(), sceneImage.getHeight());
		drawScene();
		repaint();
	}


	private void drawScene() {
		Graphics imageGraphics = sceneImage.getGraphics();
		Drawing.set(imageGraphics);
		imageGraphics.setColor(new Color(126, 63, 0));
		myScene.draw();
	}
}