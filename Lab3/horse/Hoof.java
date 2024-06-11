package horse;

import java.awt.Color;
import java.awt.Point;

public class Hoof extends HorseBodyPart {
	private int size;

	public Hoof(int size, Point point) {
		super(point, new Color(75, 26, 6));
		this.size = size;
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillRect(this.point.x, this.point.y, this.size, this.size);
	}
}