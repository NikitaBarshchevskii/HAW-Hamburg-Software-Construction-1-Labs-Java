package horse;

import java.awt.Color;

public class Ear {
	private int outerWidth;
	private int outerHeight;
	private int innerWidth;
	private int innerHeight;
	
	public Ear(int outerWidth, int outerHeight, int innerWidth, int innerHeight) {
		this.outerWidth = outerWidth;
		this.outerHeight = outerHeight;
		this.innerWidth = innerWidth;
		this.innerHeight = innerHeight;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(new Color(126, 63, 0));
		Drawing.pen().fillOval(left, bottom, outerWidth, outerHeight);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(left, bottom, innerWidth, innerHeight);
	}
}
