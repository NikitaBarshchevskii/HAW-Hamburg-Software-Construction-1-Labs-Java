package horse;

import java.awt.Color;

public enum HorseColor {
	
    BROWN(new Color(139, 69, 19)),
    BLACK(Color.BLACK),
    WHITE(Color.WHITE),
    GRAY(Color.GRAY),
    KHAKI(new Color(147, 115, 42)),
    PURPLE(new Color(72, 43, 147)),
    PINK(Color.pink),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
	RED(Color.RED),
	YELLOW(Color.YELLOW);

    private Color color;

    HorseColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}