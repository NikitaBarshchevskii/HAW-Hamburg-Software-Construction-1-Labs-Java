package horse;

import java.awt.Color;
import java.awt.Point;

public class Pupil extends HorseBodyPart {
	private int irisDiameter;
	private int pupilDiameter;

	public Pupil(int irisDiameter, int pupilDiameter, Point point) {
		super(point, Color.BLACK);
		this.irisDiameter = irisDiameter;
		this.pupilDiameter = pupilDiameter;
	}

	@Override
	public void drawAt() {
		Drawing.pen().setColor(Color.BLUE);
		Drawing.pen().fillOval(this.point.x, this.point.y, this.irisDiameter, this.irisDiameter);
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(this.point.x, this.point.y, this.pupilDiameter, this.pupilDiameter);
	}
}