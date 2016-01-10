package exo2;

import java.awt.Point;

/**
 * Classe implémentant la représentation d'un triangle
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Triangle extends Forme implements FormeOrientable {

	/**
	 * Deuxième point définissant le triangle
	 */
	private Point p2;
	/**
	 * Troisième point définissant le triangle
	 */
	private Point p3;
	/**
	 * Angle par rapport à l'axe des abscisses
	 */
	private float angle = 0;

	/**
	 * Constructeur de triangle
	 * 
	 * @param tb
	 *            Builder de triangle
	 */
	public Triangle(TriangleBuilder tb) {
		super(tb);
		this.p2 = TriangleBuilder.p2;
		this.p3 = TriangleBuilder.p3;
	}

	/**
	 * Calcul l'aire du triangle (formule de Héron)
	 */
	public float calculSuperficie() {
		double a = this.p.distance(p2);
		double b = this.p.distance(p3);
		double c = this.p2.distance(p3);

		float tmp = (float) (0.5 * a * b * c);

		return (float) Math.sqrt(tmp * (tmp - a) * (tmp - b) * (tmp - c));
	}

	/**
	 * Deplace les points p1, p2, p3 de p.x en abscisse et p.y en ordonnée
	 */
	public void deplacer(Point p) {
		this.p.move(p.x, p.y);
		this.p2.move(p.x, p.y);
		this.p3.move(p.x, p.y);
	}

	/**
	 * Setter angle
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

	public Point getP3() {
		return p3;
	}

	public float getAngle() {
		return angle;
	}

	/*
	 * Fin getters
	 */

	/**
	 * Builder de la classe Triangle, respecte le pattern Builder
	 * 
	 * @author Thomas Estrabaud
	 * 
	 */
	public static class TriangleBuilder extends FormeBuilder {

		public static Point p2 = new Point(0, 0);
		public static Point p3 = new Point(0, 0);

		public Triangle build() {
			return new Triangle(this);
		}

		public TriangleBuilder() {
			super();
		}

		public TriangleBuilder p2(Point p) {
			p2 = new Point(p);
			return (this);
		}

		public TriangleBuilder p3(Point p) {
			p3 = new Point(p);
			return (this);
		}
	}

}
