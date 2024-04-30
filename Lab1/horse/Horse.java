package horse;

public class Horse {
	private int width;
	private int height;
	private Torso torso;
	private Head head;
	
	public Horse(int width, int height) {
		this.width = width;
		this.height = height;
		this.torso = new Torso(this.width, this.height);
		this.head = new Head(this.width / 4, this.width / 2);
	}
	
	public void drawAt(int left, int bottom) {
		this.torso.drawAt(left, bottom);
		this.head.drawAt(left, bottom - (this.width / 3));
	}

}
