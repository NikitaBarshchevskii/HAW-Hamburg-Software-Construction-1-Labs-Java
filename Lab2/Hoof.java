package horse;

import java.awt.Color;

public class Hoof {
	private int size;
	private int x;
	private int y;
	
	public Hoof(int size, int x, int y) {
		this.size = size;
		this.x = x;
		this.y = y;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(new Color(75, 26, 6));
		Drawing.pen().fillRect(this.x, this.y, this.size, this.size);
	}
}
