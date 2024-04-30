package horse;

import java.awt.Color;

public class Leg {
	private int width;
	private int height;
	private Hoof hoof;

	public Leg(int width, int height) {
		this.width = width;
		this.height = height;
		this.hoof = new Hoof(width);
	}
	
	public void drawAt(int left, int bottom) {
		this.hoof.drawAt(left, bottom + this.height);
        Drawing.pen().setColor(new Color(126, 63, 0));
		Drawing.pen().fillRect(left, bottom, this.width, this.height);
	}
}
