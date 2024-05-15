package horse;

import java.awt.Color;

public class Tail {
	private int length;
	private int x;
	private int y;
	private int[] endX;
	private int[] endY;

	public Tail(int length, int x, int y) {
		this.length = length;
		this.x = x;
		this.y = y;
		this.endX = new int[15];
		this.endY = new int[15];
		for (int i = 0; i < 15; i++) {
			this.endX[i] = (int) (this.x + this.length * Math.cos(Math.toRadians(3 * i)));
			this.endY[i] = (int) (this.y - this.length * Math.sin(Math.toRadians(3 * i)));
		}
	}

	public void drawAt() {
		for (int i = 0; i < 15; i++) {
			Drawing.pen().setColor(new Color(194, 152, 1));
			Drawing.pen().drawLine(this.x, this.y, this.endX[i], this.endY[i]);
		}
	}
}