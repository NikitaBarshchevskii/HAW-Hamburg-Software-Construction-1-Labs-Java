package horse;

import java.awt.Color;

public class Pupil {
	private int x;
	private int y;
	private int irisDiameter;
	private int pupilDiameter;
	
	public Pupil(int irisDiameter, int pupilDiameter, int x, int y) {
		this.x = x;
		this.y = y;
		this.irisDiameter = irisDiameter;
		this.pupilDiameter = pupilDiameter;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(Color.BLUE);
		Drawing.pen().fillOval(this.x, this.y, this.irisDiameter, this.irisDiameter);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(this.x, this.y, this.pupilDiameter, this.pupilDiameter);
	}

}
