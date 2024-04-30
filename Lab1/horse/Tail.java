package horse;

import java.awt.Color;

public class Tail {
	private int length;
	
	public Tail(int length) {
		this.length = length;
	}
	
	public void drawAt(int left, int bottom) {
		for (int i = 0; i < 15; i++) {
            int endX = (int) (left + this.length * Math.cos(Math.toRadians(3 * i)));
            int endY = (int) (bottom - this.length * Math.sin(Math.toRadians(3 * i)));
            Drawing.pen().setColor(new Color(194, 152, 1));
            Drawing.pen().drawLine(left, bottom, endX, endY);
            
        }
	}
}
