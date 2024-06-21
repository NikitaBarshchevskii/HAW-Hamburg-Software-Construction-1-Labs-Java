package horse;

import drawing.Drawing;

import java.awt.Color;
import java.awt.Point;

public class Eye extends HorseBodyPart {
	private int diameter;
	private Pupil pupil;

	public Eye(int diameter, Point point) {
		super(point, Color.WHITE);
		this.diameter = diameter;
		this.pupil = new Pupil(this.diameter / 2, this.diameter / 4, new Point(this.point.x + this.diameter / 4, this.point.y + this.diameter / 4));
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.point.x, this.point.y, this.diameter, this.diameter);
		this.pupil.drawAt();
	}
}