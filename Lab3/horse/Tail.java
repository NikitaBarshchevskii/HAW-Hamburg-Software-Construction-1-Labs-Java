package horse;

import java.awt.Color;
import java.awt.Point;

public class Tail extends HorseBodyPart {
	private int length;
	private int[] endX;
	private int[] endY;

	public Tail(int length, Point point, Color color) {
		super(point, color);
		this.length = length;
		this.endX = new int[15];
		this.endY = new int[15];
		for (int i = 0; i < 15; i++) {
			this.endX[i] = (int) (this.point.x + this.length * Math.cos(Math.toRadians(3 * i)));
			this.endY[i] = (int) (this.point.y - this.length * Math.sin(Math.toRadians(3 * i)));
		}
	}

	@Override
	public void drawAt() {
		for (int i = 0; i < 15; i++) {
			Drawing.pen().setColor(this.color);
			Drawing.pen().drawLine(this.point.x, this.point.y, this.endX[i], this.endY[i]);
		}
	}
}