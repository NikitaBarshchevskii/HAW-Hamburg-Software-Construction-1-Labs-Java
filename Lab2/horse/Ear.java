package horse;

import java.awt.Color;
import java.awt.Point;

public class Ear extends HorseBodyPart {
	private int outerWidth;
	private int outerHeight;
	private int innerWidth;
	private int innerHeight;

	public Ear(int outerWidth, int outerHeight, int innerWidth, int innerHeight, Point point, Color color) {
		super(point, color);
		this.outerWidth = outerWidth;
		this.outerHeight = outerHeight;
		this.innerWidth = innerWidth;
		this.innerHeight = innerHeight;
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.point.x, this.point.y, outerWidth, outerHeight);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(this.point.x, this.point.y, innerWidth, innerHeight);
	}
}