package horse;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		pen.setColor(new Color(126, 63, 0));
		
		//Horse myHorse = new Horse(3 * 120, 3 * 50, 650, 350);
		//myHorse.drawAt();

		Scene myScene = new Scene(75);
		myScene.draw();
	}
}