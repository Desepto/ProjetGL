package exo2;

public class Carre extends Forme implements FormeOrientable {

	private int cote;
	private float angle = 0;

	public Carre(CarreBuilder cb) {
		super(cb);
		this.cote = CarreBuilder.cote;
	}

	public float calculSuperficie() {
		return (float) cote * cote;
	}

	public void rotationer(float angle) {
		this.angle = angle;
	}

	public int getCote() {
		return cote;
	}

	public float getAngle() {
		return angle;
	}

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
