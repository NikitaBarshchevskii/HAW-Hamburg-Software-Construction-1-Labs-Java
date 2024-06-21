package tree;

import drawing.Drawing;
import rectangle.LocatedRectangle;

import java.awt.*;

public class Tree implements LocatedRectangle {
    private Point point;
    private Point locatedRectPoint;
    private int trunkWidth = 35;
    private int trunkHeight = 100;
    private int foliageWidth = 140;
    private int foliageHeight = 100;
    private int appleSize = 20;
    private int grassHeight = 20;
    private int width;
    private int height;

    public Tree(int width, int height, Point point) {
        this.width = width;
        this.height = height;
        this.point = new Point(point.x, point.y);
        this.locatedRectPoint = new Point(this.point.x - this.width / 2, this.point.y - this.height * 2);
    }

    public void drawAt() {
        int baseX = this.point.x;
        int baseY = this.point.y;
        Drawing.pen().setColor(new Color(66, 32, 7)); // Brown color for the trunk
        Drawing.pen().fillRect(baseX, baseY, trunkWidth, trunkHeight); // Trunk rectangle

        // Draw the foliage of the tree
        Drawing.pen().setColor(new Color(36, 101, 28)); // Green color for the foliage
        Drawing.pen().fillOval(baseX - (foliageWidth - trunkWidth) / 2, baseY - foliageHeight + 5, foliageWidth, foliageHeight); // Upper oval
        Drawing.pen().fillOval(baseX - (foliageWidth - trunkWidth) / 2, (int)(baseY - foliageHeight * 1.5), foliageWidth, foliageHeight); // Middle oval
        Drawing.pen().fillOval(baseX - (foliageWidth - trunkWidth) / 2, baseY - foliageHeight * 2, foliageWidth, foliageHeight); // Lower oval

        // Draw some apples on the tree
        Drawing.pen().setColor(Color.RED); // Red color for the apples
        Drawing.pen().fillOval(baseX + trunkWidth / 4, baseY - foliageHeight * 2 + 30, appleSize, appleSize); // Apple 2
        Drawing.pen().fillOval(baseX + trunkWidth - appleSize, baseY - foliageHeight + 10, appleSize, appleSize); // Apple 3
        Drawing.pen().fillOval(baseX + trunkWidth * 3 / 2 - appleSize / 2, baseY - foliageHeight * 2 + 20, appleSize, appleSize); // Apple 5
        Drawing.pen().fillOval(baseX - trunkWidth / 2 + 10, baseY - foliageHeight + 20, appleSize, appleSize); // Apple 6
        Drawing.pen().fillOval(baseX + trunkWidth - 10, baseY - foliageHeight * 2 + 10, appleSize, appleSize); // Apple 7
        // Draw some grass at the base of the tree
        Drawing.pen().setColor(new Color(73, 139, 19));
        int[] xPoints = {
                baseX - trunkWidth / 2, baseX - trunkWidth / 3, baseX - trunkWidth / 6,
                baseX, baseX + trunkWidth / 6, baseX + trunkWidth / 3,
                baseX + trunkWidth / 2, baseX + trunkWidth + trunkWidth / 3,
                baseX + trunkWidth + trunkWidth / 2, baseX + trunkWidth + trunkWidth / 3,
                baseX + trunkWidth + trunkWidth / 6
        };
        int[] yPoints = {
                baseY + trunkHeight, baseY + trunkHeight - grassHeight, baseY + trunkHeight,
                baseY + trunkHeight - grassHeight, baseY + trunkHeight, baseY + trunkHeight - grassHeight,
                baseY + trunkHeight, baseY + trunkHeight - grassHeight, baseY + trunkHeight,
                baseY + trunkHeight - grassHeight, baseY + trunkHeight
        };
        Drawing.pen().fillPolygon(xPoints, yPoints, xPoints.length);
    }
    @Override
    public Point address() {
        return this.locatedRectPoint;
    }

    @Override
    public int width() {
        return this.width * 2;
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
