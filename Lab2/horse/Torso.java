package horse;

import java.awt.Color;
import java.awt.Point;

public class Torso extends HorseBodyPart {
	private Tail tail;
	private Leg[] legs; // composite

	public Torso(int width, int height, Point point, Color color) {
		super(point, color);
		this.width = width;
		this.height = height;
		this.tail = new Tail(width / 3, new Point(point.x + (int)(width * 0.9), point.y + (width / 6)), new Color(194, 152, 1));
		this.legs = new Leg[4];
		for (int i = 0; i < 4; i++) {
			this.legs[i] = new Leg(width / 8, height, new Point(point.x + (width / 8) + i * (height / 2), point.y + (width / 6)), color);
		}
	}

	@Override
	public void drawAt() {
		this.tail.drawAt();
		super.drawAt();

		for (int i = 0; i < 4; i++) {
			this.legs[i].drawAt();
		}
	}
}