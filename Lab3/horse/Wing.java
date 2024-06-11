package horse;

import java.awt.Color;
import java.awt.Point;

public class Wing extends HorseBodyPart {
    private static final int FEATHER_COUNT = 3;

    public Wing(int width, int height, Point point, Color color) {
        super(width, height, point, color);
    }

    @Override
    public void drawAt() {
        Drawing.pen().setColor(this.color);
        Drawing.pen().fillOval(this.point.x, this.point.y, this.width, this.height);

        Drawing.pen().setColor(Color.BLUE);
        for (int i = 0; i < FEATHER_COUNT; i++) {
            int featherY = this.point.y + (this.height / (FEATHER_COUNT + 1)) * (i + 1);
            int featherX1 = this.point.x + this.width;
            int featherX2 = featherX1;
            int featherX3 = featherX1 + this.width / (FEATHER_COUNT * 2);

            if (i == 0 || i == 2) {
                featherX1 -= this.width / 7;
                featherX2 -= this.width / 7;
                featherX3 -= this.width / 7;
            }

            int[] xPoints = {featherX1, featherX2, featherX3};
            int[] yPoints = {featherY - this.height / (FEATHER_COUNT * 2), featherY + this.height / (FEATHER_COUNT * 2), featherY};
            Drawing.pen().fillPolygon(xPoints, yPoints, 3);
        }
    }
}