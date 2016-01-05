package exo2;

import java.awt.Point;

public class Rectangle extends Forme implements FormeOrientable {

	private Point p2;
	private float angle = 0;

	public Rectangle(RectangleBuilder rb) {
		super(rb);
		this.p2 = RectangleBuilder.p2;
	}

	public float calculSuperficie() {
		return (float) (Math.abs(this.p.x - this.p2.x) * Math.abs(this.p.y
				- this.p2.y));
	}

	public void deplacer(Point p) {
		this.p.move(p.x, p.y);
		this.p2.move(p.x, p.y);
	}

	public void rotationer(float angle) {
		this.angle = angle;
	}

	public Point getP2() {
		return p2;
	}

	public float getAngle() {
		return angle;
	}

	public static class RectangleBuilder extends FormeBuilder {

		public static Point p2 = new Point(0, 0);

		public Rectangle build() {
			return new Rectangle(this);
		}

		public RectangleBuilder() {
			super();
		}

		public RectangleBuilder p2(Point p) {
			p2 = new Point(p);
			return (this);
		}
	}

}
