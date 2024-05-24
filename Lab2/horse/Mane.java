package horse;

import java.awt.Color;
import java.awt.Point;

public class Mane extends HorseBodyPart {
	private int length;
	private int[] endX;
	private int[] endY;

	public Mane(int length, Point point) {
		super(point, new Color(194, 152, 1));
		this.length = length;
		this.endX = new int[20];
		this.endY = new int[20];
		for (int i = 0; i < 20; i++) {
			this.endX[i] = (int) (this.point.x - this.length * Math.cos(Math.toRadians(90 + 2 * i)));
			this.endY[i] = (int) (this.point.y + this.length * Math.sin(Math.toRadians(90 + 2 * i)));
		}
	}

	@Override
	public void drawAt() {
		for (int i = 0; i < 20; i++) {
			Drawing.pen().setColor(this.color);
			Drawing.pen().drawLine(this.point.x, this.point.y, this.endX[i], this.endY[i]);
		}
	}
}