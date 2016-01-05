package exo2;

public class Cercle extends Forme {

	private int r;

	public Cercle(CercleBuilder cb) {
		super(cb);
		this.r = CercleBuilder.r;
	}

	public float calculSuperficie() {
		return (float) Math.PI * r * r;
	}

	public int getR() {
		return this.r;
	}

	public static class CercleBuilder extends FormeBuilder {

		private static int r = 1;

		public Cercle build() {
			return new Cercle(this);
		}

		public CercleBuilder() {
			super();
		}

		public CercleBuilder rayon(int rayon) {
			r = rayon;
			return (this);
		}
	}

}
