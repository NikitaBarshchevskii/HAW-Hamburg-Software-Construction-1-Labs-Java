package horse;

import java.awt.Color;

public class Eye {
	private int diameter;
	private int x;
	private int y;
	private Pupil pupil;
	
	public Eye(int diameter, int x, int y) {
		this.diameter = diameter;
		this.x = x;
		this.y = y;
		this.pupil = new Pupil((int)(this.diameter * 0.8), (int)(this.diameter * 0.6), this.x, this.y);
	}
	
	public void drawAt() {
		Drawing.pen().setColor(Color.WHITE);
		Drawing.pen().fillOval(this.x, this.y, this.diameter, this.diameter);
		this.pupil.drawAt();
	}

}
