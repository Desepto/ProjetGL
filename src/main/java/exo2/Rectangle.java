package exo2;

import java.awt.Point;

/**
 * Classe implémentant la représentation du triangle
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Rectangle extends Forme implements FormeOrientable {

	/**
	 * Deuxième point du rectangle (en bas à droite)
	 */
	private Point p2;
	/**
	 * Angle par rapport à l'axe des abscisses (les positions des points sont
	 * recalculées dans les fonctions de dessin)
	 */
	private float angle = 0;

	/**
	 * Constructeur de rectangle
	 * 
	 * @param rb
	 *            Builder de rectangle
	 */
	public Rectangle(RectangleBuilder rb) {
		super(rb);
		this.p2 = RectangleBuilder.p2;
	}

	/**
	 * Calcule l'aire du rectangle
	 */
	public float calculSuperficie() {
		return (float) (Math.abs(this.p.x - this.p2.x) * Math.abs(this.p.y
				- this.p2.y));
	}

	/**
	 * Déplace le rectangle de px/p.y
	 */
	public void deplacer(Point p) {
		this.p.move(p.x, p.y);
		this.p2.move(p.x, p.y);
	}

	/**
	 * Setter de l'angle
	 */
	public void rotationer(float angle) {
		this.angle = angle;
	}

	/*
	 * Getters
	 */
	public Point getP2() {
		return p2;
	}

	public float getAngle() {
		return angle;
	}

	/*
	 * Fin getters
	 */

	/**
	 * Builder de la classe Rectangle, respecte le pattern builder
	 * 
	 * @author Thomas Estrabaud
	 * 
	 */
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
