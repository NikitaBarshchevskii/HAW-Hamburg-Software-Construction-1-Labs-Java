package horse;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

public class Torso extends HorseBodyPart {
	private Tail tail;
	private Leg[] legs; // composite

	public Torso(int width, int height, Point point, Color color) {
		super(point, color);
		this.width = width;
		this.height = height;
		this.tail = new Tail(width / 3, new Point(point.x + (int)(width * 0.9), point.y + (width / 6)), new Color(194, 152, 1));
		this.legs = new Leg[4];
		for (int i = 0; i < 4; i++) {
			this.legs[i] = new Leg(width / 8, height, new Point(point.x + (width / 8) + i * (height / 2), point.y + (width / 6)), color);
		}
	}

	@Override
	public void drawAt() {
		this.tail.drawAt();
		super.drawAt();
		for (int i = 0; i < 4; i++) {
			this.legs[i].drawAt();
		}
		drawHeart();
		//drawWing();
	}
	private void drawWing() {
		int wingWidth = this.width; // increased size
		int wingHeight = (int)(this.height / 1.5); // increased size
		int wingX = this.point.x + this.width / 2 - wingWidth / 2;
		int wingY = this.point.y ; // moved up

		GeneralPath wing = new GeneralPath();
		wing.moveTo(wingX, wingY);
		wing.curveTo(wingX + wingWidth / 4, wingY - wingHeight / 2, wingX + 3 * wingWidth / 4, wingY - wingHeight / 2, wingX + wingWidth, wingY);
		wing.curveTo(wingX + 3 * wingWidth / 4, wingY + wingHeight / 2, wingX + wingWidth / 4, wingY + wingHeight / 2, wingX, wingY);
		wing.closePath();
		Graphics2D g2d = (Graphics2D) Drawing.pen();
		g2d.setColor(this.color);
		AffineTransform old = g2d.getTransform();
		g2d.rotate(-Math.PI / 12, wingX + wingWidth / 2, wingY + wingHeight / 2);
		g2d.fill(wing);
		g2d.setTransform(old);
	}
	
	private void drawHeart() {
		int heartSize = Math.min(this.width, this.height) / 110;
		int heartX = this.point.x + this.width / 2;
		int heartY = this.point.y + this.height / 2;

		Path2D heart = new Path2D.Double();
		for (double t = 0; t <= 2 * Math.PI; t += 0.01) {
			double x = heartSize * (16 * Math.pow(Math.sin(t), 3));
			double y = -heartSize * (13 * Math.cos(t) - 5 * Math.cos(2*t) - 2 * Math.cos(3*t) - Math.cos(4*t));
			if (t == 0) {
				heart.moveTo(heartX + x, heartY + y);
			} else {
				heart.lineTo(heartX + x, heartY + y);
			}
		}
		heart.closePath();

		Graphics2D g2d = (Graphics2D) Drawing.pen();
		g2d.setColor(Color.RED);
		g2d.fill(heart);
	}
}