package horse;

import java.awt.Color;
import java.awt.Point;

public class Leg extends HorseBodyPart {
	private Hoof hoof;

	public Leg(int width, int height, Point point, Color color) {
		super(width, height, point, color);
		this.hoof = new Hoof(width, new Point(point.x, point.y + height));
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillRect(this.point.x, this.point.y, this.width, this.height);
		this.hoof.drawAt();
	}
}