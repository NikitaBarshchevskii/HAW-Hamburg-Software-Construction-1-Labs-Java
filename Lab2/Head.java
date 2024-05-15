package horse;

import java.awt.Color;


public class Head {
	private int width;
	private int height;
	private int x;
	private int y;
	private Eye eye; // composite
	private Mouth mouth;
	private Ear[] ears;
	private Mane mane;
	private Color color;

	public Head(int width, int height, int x, int y, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
		this.eye = new Eye(this.height / 8, this.x, this.y + this.height / 10);
		this.mouth = new Mouth(this.height / 3, this.x - this.height/2, this.y + this.height/10);
		this.ears = new Ear[2];
		
		for (int i = 0; i < 2; i++) {
            this.ears[i] = new Ear(this.height / 8, this.height / 4, this.height / 10, this.height / 6, this.x + this.height / (10 / (i + 1)), this.y - this.height / 6, this.color);
        }
		
		this.mane = new Mane((int)(this.height / 1.5), this.x + (int)(this.width / 1.5), this.y);
	}
	
	public void drawAt() {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.x, this.y, this.width, this.height);
		Drawing.pen().fillOval(this.x - this.height/2, this.y, this.height, this.width);
		
		this.eye.drawAt();
		this.mouth.drawAt();
		
		for (int i = 0; i < 2; i++) {
			this.ears[i].drawAt();
        }
		
		this.mane.drawAt();
	}
}
