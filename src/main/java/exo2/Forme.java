package exo2;

import java.awt.Color;
import java.awt.Point;

public class Forme {

	/**
	 * Le fait que ce soit du RGB ou non est géré tout seul par le type Color
	 */
	protected Color c;
	protected Point p;
	protected String nom;

	public Forme(FormeBuilder fb) {
		this.c = FormeBuilder.c;
		this.p = FormeBuilder.p;
		this.nom = FormeBuilder.nom;
	}

	public void colorier(Color c) {
		this.c = c;
	}

	public float calculSuperficie() {
		return 0;
	}

	public void deplacer(Point p) {
		this.p.move(p.x, p.y);
	}

	public Color getC() {
		return c;
	}

	public Point getP() {
		return p;
	}

	public static class FormeBuilder {

		protected static Color c = new Color((float) 0.0, (float) 0.0,
				(float) 0.0);
		protected static Point p = new Point(0, 0);
		protected static String nom = "";

		public Forme build() {
			return new Forme(this);
		}

		public FormeBuilder() {

		}

		public FormeBuilder Color(Color coul) {
			c = coul;
			return this;
		}

		public FormeBuilder Point(Point pt) {
			p = pt;
			return this;
		}

		public FormeBuilder Nom(String Nom) {
			nom = Nom;
			return this;
		}
	}
}
