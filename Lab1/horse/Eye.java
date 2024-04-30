package horse;

import java.awt.Color;

public class Eye {
	private int diameter;
	private Pupil pupil;
	
	public Eye(int diameter) {
		this.diameter = diameter;
		this.pupil = new Pupil((int)(this.diameter * 0.8), (int)(this.diameter * 0.6));
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.WHITE);
		Drawing.pen().fillOval(left, bottom, this.diameter, this.diameter);
		this.pupil.drawAt(left, bottom);
	}

}
