package horse;

import java.awt.Color;

public enum HorseColor {
	
    BROWN(new Color(139, 69, 19)),
    BLACK(new Color(46, 45, 56)),
    WHITE(Color.WHITE),
    GRAY(new Color(117, 104, 143)),
    KHAKI(new Color(147, 115, 42)),
    PURPLE(new Color(72, 43, 147)),
    PINK(new Color(239, 152, 234)),
    BLUE(new Color(95, 185, 236)),
    PEACH(new Color(206, 111, 64)),
    CREAM(new Color(228, 234, 241)),
	RED(new Color(139, 19, 51));

    private Color color;

    HorseColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}