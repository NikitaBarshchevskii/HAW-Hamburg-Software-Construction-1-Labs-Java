package horse;

import java.awt.Color;
import java.awt.Point;

public class Head extends HorseBodyPart {
	private Eye eye; // composite
	private Mouth mouth;
	private Ear[] ears;
	private Mane mane;

	public Head(int width, int height, Point point, Color color) {
		super(width, height, point, color);
		this.width = width;
		this.height = height;
		this.eye = new Eye(this.height / 8, new Point(this.point.x, this.point.y + this.height / 10));
		this.mouth = new Mouth(this.height / 3, this.height / 3, new Point(this.point.x - this.height/2, this.point.y + this.height/10), Color.GRAY);
		this.ears = new Ear[2];

		for (int i = 0; i < 2; i++) {
			this.ears[i] = new Ear(this.height / 8, this.height / 4, this.height / 10, this.height / 6, new Point(this.point.x + this.height / (10 / (i + 1)), this.point.y - this.height / 6), this.color);
		}

		this.mane = new Mane((int)(this.height / 1.5), new Point(this.point.x + (int)(this.width / 1.5), this.point.y));
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.point.x, this.point.y, this.width, this.height);
		Drawing.pen().fillOval(this.point.x - this.height/2, this.point.y, this.height, this.width);

		this.eye.drawAt();
		this.mouth.drawAt();

		for (int i = 0; i < 2; i++) {
			this.ears[i].drawAt();
		}

		this.mane.drawAt();
	}
}