package horse;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage sceneImage;
	private Scene myScene;

	public DrawingArea() {
		super();
		myScene = new Scene(200);
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

	public void refresh() {
		myScene.reset(200);
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