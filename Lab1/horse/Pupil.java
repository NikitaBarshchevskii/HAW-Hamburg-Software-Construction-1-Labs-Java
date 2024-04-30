package horse;

import java.awt.Color;

public class Pupil {
	private int irisDiameter;
	private int pupilDiameter;
	
	public Pupil(int irisDiameter, int pupilDiameter) {
		this.irisDiameter = irisDiameter;
		this.pupilDiameter = pupilDiameter;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.BLUE);
		Drawing.pen().fillOval(left, bottom, this.irisDiameter, this.irisDiameter);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(left, bottom, this.pupilDiameter, this.pupilDiameter);
	}

}
