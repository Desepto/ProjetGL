package exo2;

/**
 * Classe utilisée pour représenter un carré. On représente un carré avec un
 * point (en haut à gauche), un coté et un angle.
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Carre extends Forme implements FormeOrientable {

	/**
	 * Taille d'un coté du carré
	 */
	private int cote;
	/**
	 * Angle du carré par rapport à l'axe des abscisses (le calcul de la
	 * position est fait dans les fonctions de dessin
	 */
	private float angle = 0;

	/**
	 * Constructeur de carré
	 * 
	 * @param cb
	 *            Builder du carré
	 */
	public Carre(CarreBuilder cb) {
		super(cb);
		this.cote = CarreBuilder.cote;
	}

	/**
	 * Calcule la superficie d'un carré
	 */
	public float calculSuperficie() {
		return (float) cote * cote;
	}

	/**
	 * Setter de l'angle
	 * 
	 * @param angle
	 *            Nouvel angle
	 */
	public void rotationer(float angle) {
		this.angle = angle;
	}

	/**
	 * Setter de la taille
	 * 
	 * @param cote
	 *            Nouveau cote
	 */
	public void changerTaille(int cote) {
		this.cote = cote;
	}

	/*
	 * Getters
	 */
	public int getCote() {
		return cote;
	}

	public float getAngle() {
		return angle;
	}

	/*
	 * Fin getters
	 */

	/**
	 * Builder de la classe Carré, respecte le pattern builder
	 * 
	 * @author Thomas Estrabaud
	 * 
	 */
	public static class CarreBuilder extends FormeBuilder {

		public static int cote = 1;

		public Carre build() {
			return new Carre(this);
		}

		public CarreBuilder() {
			super();
		}

		public CarreBuilder cote(int c) {
			cote = c;
			return (this);
		}
	}

}
