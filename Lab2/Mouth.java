package horse;

import java.awt.Color;

public class Mouth {
	private int diameter;
	private int x;
	private int y;
	
	public Mouth(int diameter, int x, int y) {
		this.diameter = diameter;
		this.x = x;
		this.y = y;
	}

	public void drawAt() {
		Drawing.pen().setColor(Color.GRAY);
		Drawing.pen().fillOval(this.x, this.y, this.diameter, this.diameter);
	}
}
