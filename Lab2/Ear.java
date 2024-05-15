package horse;

import java.awt.Color;

public class Ear {
	private int outerWidth;
	private int outerHeight;
	private int innerWidth;
	private int innerHeight;
	private int x;
	private int y;
	private Color color;
	
	public Ear(int outerWidth, int outerHeight, int innerWidth, int innerHeight, int x, int y, Color color) {
		this.outerWidth = outerWidth;
		this.outerHeight = outerHeight;
		this.innerWidth = innerWidth;
		this.innerHeight = innerHeight;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.x, this.y, outerWidth, outerHeight);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(this.x, this.y, innerWidth, innerHeight);
	}
}
