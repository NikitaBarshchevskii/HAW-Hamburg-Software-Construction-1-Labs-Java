package horse;

import java.awt.*;

public class Horse implements LocatedRectangle{ // composite
	private int width;
	private int height;
	private int x;
	private int y;
	private Torso torso; // composite
	private Head head; // composite
	private Color color;

	public Horse(int width, int height, int x, int y, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
		this.torso = new Torso(this.width, this.height, this.x, this.y, this.color);
		this.head = new Head(this.width / 4, this.width / 2, this.x, this.y - (this.width / 3), this.color);
	}
	
	public void drawAt() {
		this.torso.drawAt();
		this.head.drawAt();
	}

	@Override
	public Point address() {
		return new Point(this.x - this.width / 4, this.y - this.height);
	}

	@Override
	public int width() {
		return (int)(this.width * 1.5);
	}

	@Override
	public int height() {
		return this.height * 3;
	}

	@Override
	public void draw() {
		this.drawAt();
	}
}
