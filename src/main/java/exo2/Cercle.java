package exo2;

/**
 * Classe implémentant la représentation d'un cercle
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Cercle extends Forme {

	/**
	 * Rayon du cercle
	 */
	private int r;

	/**
	 * Constructeur du cercle
	 * 
	 * @param cb
	 *            Reçoit un builder de cercle
	 */
	public Cercle(CercleBuilder cb) {
		super(cb);
		this.r = CercleBuilder.r;
	}

	/**
	 * Calcul l'aire du cercle
	 */
	public float calculSuperficie() {
		return (float) Math.PI * r * r;
	}

	/*
	 * Getters/setters
	 */
	public int getR() {
		return this.r;
	}

	public void setR(int r) {
		this.r = r;
	}

	/**
	 * Builder du cercle, respecte le pattern builder
	 * 
	 * @author Thomas Estrabaud
	 * 
	 */
	public static class CercleBuilder extends FormeBuilder {

		protected static int r = 1;

		public Cercle build() {
			return new Cercle(this);
		}

		public CercleBuilder() {

		}

		public CercleBuilder rayon(int rayon) {
			r = rayon;
			return (this);
		}
	}

}
