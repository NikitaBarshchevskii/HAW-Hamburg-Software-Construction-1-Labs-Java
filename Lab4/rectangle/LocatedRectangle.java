/**
 * An interface for rectangular objects.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */
package rectangle;

import java.awt.Point;

public interface LocatedRectangle {
	public Point address();
	public int width();
	public int height();
	public void draw();

	public default boolean intersects(LocatedRectangle other) {
		return !doesNotIntersect(other, 0);
	}	
	
	public default boolean intersects(LocatedRectangle other, int margin) {
		return !doesNotIntersect(other, margin);
	}
	
	default boolean doesNotIntersect(LocatedRectangle other, int margin) {
		return 	leftOf(other, margin) || rightOf(other, margin) || 
				above(other, margin) || below(other, margin);
	}
	
	public default boolean leftOf(LocatedRectangle other, int margin){
		return this.address().x + this.width() + margin < other.address().x;
	}
	
	public default boolean rightOf(LocatedRectangle other, int margin){
		return this.address().x > other.address().x + other.width() + margin;
	}
	
	private boolean above(LocatedRectangle other, int margin) {
		return this.address().y + this.height() + margin <= other.address().y;
	}
	
	private boolean below(LocatedRectangle other, int margin) {
		return this.address().y >= other.address().y + other.height() + margin;
	}
}