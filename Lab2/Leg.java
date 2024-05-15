package horse;

import java.awt.Color;

public class Leg {
	private int width;
	private int height;
	private Hoof hoof;
	private int x;
	private int y;
	private Color color;

	public Leg(int width, int height, int x, int y, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
		this.hoof = new Hoof(width, x, y + height);
	}
	
	public void drawAt() {
		this.hoof.drawAt();
        Drawing.pen().setColor(this.color);
		Drawing.pen().fillRect(this.x, this.y, this.width, this.height);
	}
}
