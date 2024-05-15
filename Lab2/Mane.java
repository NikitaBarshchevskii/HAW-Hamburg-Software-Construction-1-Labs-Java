package horse;

import java.awt.Color;

public class Mane {
	private int length;
	private int x;
	private int y;
	private int[] endX;
	private int[] endY;

	public Mane(int length, int x, int y) {
		this.length = length;
		this.x = x;
		this.y = y;
		this.endX = new int[20];
		this.endY = new int[20];
		for (int i = 0; i < 20; i++) {
			this.endX[i] = (int) (this.x - this.length * Math.cos(Math.toRadians(90 + 2 * i)));
			this.endY[i] = (int) (this.y + this.length * Math.sin(Math.toRadians(90 + 2 * i)));
		}
	}

	public void drawAt() {
		for (int i = 0; i < 20; i++) {
			Drawing.pen().setColor(new Color(194, 152, 1));
			Drawing.pen().drawLine(this.x, this.y, this.endX[i], this.endY[i]);
		}
	}
}