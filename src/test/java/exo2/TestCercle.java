package exo2;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import exo2.Cercle.CercleBuilder;

public class TestCercle {

	@Test
	public void testConstructeur() {
		Color c = new Color(1, 2, 3);
		String nom = "test";
		Point p = new Point(1, 2);
		int r = 5;
		Cercle f = ((CercleBuilder) new Cercle.CercleBuilder().Color(c)
				.Nom(nom).Point(p)).rayon(r).build();

		assertEquals(f.getC(), c);
		assertEquals(f.getP(), p);
		assertEquals(f.getNom(), nom);
		assertEquals(f.getR(), r);
	}

}
