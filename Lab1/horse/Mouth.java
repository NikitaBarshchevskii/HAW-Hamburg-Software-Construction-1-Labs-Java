package horse;

import java.awt.Color;

public class Mouth {
	private int diameter;
	
	public Mouth(int diameter) {
		this.diameter = diameter;
	}

	public void drawAt(int bottom, int left) {
		Drawing.pen().setColor(Color.GRAY);
		Drawing.pen().fillOval(bottom, left, this.diameter, this.diameter);
	}
}
