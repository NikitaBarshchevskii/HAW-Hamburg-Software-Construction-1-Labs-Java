package horse;

import java.awt.Color;

public class Hoof {
	private int size;
	
	public Hoof(int size) {
		this.size = size;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillRect(left, bottom, this.size, this.size);
	}
}
