package horse;

import java.awt.Graphics;

public class Drawing {

	private static Graphics pen = null;
	
	public static void set(Graphics pen) {
		Drawing.pen = pen;
	}
	
	public static Graphics pen() {
		return Drawing.pen;
	}
}