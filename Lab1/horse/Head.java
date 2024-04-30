package horse;

import java.awt.Color;


public class Head {
	private int width;
	private int height;
	private Eye eye;
	private Mouth mouth;
	private Ear[] ears;
	private Mane mane;
	
	public Head(int width, int height) {
		this.width = width;
		this.height = height;
		this.eye = new Eye(this.height / 8);
		this.mouth = new Mouth(this.height / 3);
		this.ears = new Ear[2];
		
		for (int i = 0; i < 2; i++) {
            this.ears[i] = new Ear(this.height / 8, this.height / 4, this.height / 10, this.height / 6);
        }
		
		this.mane = new Mane((int)(this.height / 1.5));
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(new Color(126, 63, 0));
		Drawing.pen().fillOval(left, bottom, this.width, this.height);
		Drawing.pen().fillOval(left - this.height/2, bottom, this.height, this.width);
		
		this.eye.drawAt(left, bottom + this.height / 10);
		this.mouth.drawAt(left - this.height/2, bottom + this.height/10);
		
		for (int i = 0; i < 2; i++) {
			this.ears[i].drawAt(left + this.height / (10 / (i + 1)), bottom - this.height / 6);
        }
		
		this.mane.drawAt(left + (int)(this.width / 1.5), bottom);
	}
}
