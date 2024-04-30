package horse;

import java.awt.Color;

public class Torso {
	private int width;
	private int height;
	private Tail tail;
    private Leg[] legs;

	public Torso(int width, int height) {
		this.width = width;
		this.height = height;
		this.tail = new Tail(this.width / 3);
		this.legs = new Leg[4];
        for (int i = 0; i < 4; i++) {
            this.legs[i] = new Leg(this.width / 8, this.height);
        }
	}
	
	public void drawAt(int left, int bottom) {
		this.tail.drawAt(left + (int)(width * 0.9), bottom + (width / 6));
		Drawing.pen().setColor(new Color(126, 63, 0));
		Drawing.pen().fillOval(left, bottom, this.width, this.height);
		
		for (int i = 0; i < 4; i++) {
           this.legs[i].drawAt(left + (this.width / 8) + i * (this.height / 2), bottom + (this.width / 6));
        }
	}
	
}
