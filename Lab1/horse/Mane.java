package horse;

import java.awt.Color;

public class Mane {
	private int length;
	
	public Mane(int length) {
		this.length = length;
	}
	
	public void drawAt(int left, int bottom) {
		for (int i = 0; i < 20; i++) {
            int endX = (int) (left - length * Math.cos(Math.toRadians(90 + 2 * i)));
            int endY = (int) (bottom + length * Math.sin(Math.toRadians(90 + 2 * i)));
            Drawing.pen().setColor(new Color(194, 152, 1));
            Drawing.pen().drawLine(left, bottom, endX, endY);
        }
	}

}
