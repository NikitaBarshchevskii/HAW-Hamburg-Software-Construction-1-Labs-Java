package horse;

import java.awt.*;

public abstract class HorseBodyPart {
    protected int width;
    protected int height;
    protected Point point;
    protected Color color;

    public HorseBodyPart(int width, int height, Point point, Color color) {
        this.width = width;
        this.height = height;
        this.point = new Point(point.x, point.y);
        this.color = color;
    }

    public HorseBodyPart(Point point, Color color) {
        this.point = new Point(point.x, point.y);
        this.color = color;
    }


    public void drawAt() {
        Drawing.pen().setColor(this.color);
        Drawing.pen().fillOval(this.point.x, this.point.y, this.width, this.height);
    }
}
