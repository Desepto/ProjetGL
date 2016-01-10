package exo2;

import java.awt.Color;
import java.awt.Point;

/**
 * Classe définissant les formes N'est pas abstraite en raison du builder (qui a
 * besoin de créer un objet de la forme)
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Forme {

	/**
	 * Couleur de la forme Le fait que ce soit du RGB ou non est géré tout seul
	 * par le type Color
	 */
	protected Color c;
	/**
	 * Point de base de la forme (géré differement selon les formes)
	 */
	protected Point p;
	/**
	 * Nom de la forme (= id)
	 */
	protected String nom;

	/**
	 * COnstructeur de forme, utilise un builder
	 * 
	 * @param fb
	 *            builder à envoyer
	 */
	public Forme(FormeBuilder fb) {
		this.c = FormeBuilder.c;
		this.p = FormeBuilder.p;
		this.nom = FormeBuilder.nom;
	}

	/**
	 * Setter du champ color
	 * 
	 * @param c
	 */
	public void colorier(Color c) {
		this.c = c;
	}

	/**
	 * Méthode à redéfinir pour avoir un bon résultat
	 * 
	 * @return \/!\ Renvoit 0 !
	 */
	public float calculSuperficie() {
		return 0;
	}

	/**
	 * Déplace la figure de p.x en abscisse et p.y en ordonnée
	 * 
	 * @param p
	 *            Distance à laquelle déplacer la figure
	 */
	public void deplacer(Point p) {
		this.p.move(p.x, p.y);
	}

	/**
	 * Setter du nom
	 * 
	 * @param s
	 *            Nom à donner
	 */
	public void nommer(String s) {
		this.nom = s;
	}

	/*
	 * Getters
	 */

	public Color getC() {
		return c;
	}

	public Point getP() {
		return p;
	}

	public String getNom() {
		return nom;
	}

	/*
	 * Fin Getters
	 */

	/**
	 * Class builder permettant de créer une forme avec des paramètres
	 * optionnels Correspond au pattern builder standard
	 * 
	 * @author Thomas Estrabaud
	 * 
	 */
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
