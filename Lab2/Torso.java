package horse;

import java.awt.Color;

public class Torso {
	private int width;
	private int height;
	private int x;
	private int y;
	private Tail tail;
    private Leg[] legs; // composite
	private Color color;

	public Torso(int width, int height, int x, int y, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
		this.tail = new Tail(this.width / 3, this.x + (int)(width * 0.9), this.y + (width / 6));
		this.legs = new Leg[4];
        for (int i = 0; i < 4; i++) {
            this.legs[i] = new Leg(this.width / 8, this.height, this.x + (this.width / 8) + i * (this.height / 2), this.y + (this.width / 6), this.color);
        }
	}
	
	public void drawAt() {
		this.tail.drawAt();
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.x, this.y, this.width, this.height);
		
		for (int i = 0; i < 4; i++) {
           this.legs[i].drawAt();
        }
	}
	
}
