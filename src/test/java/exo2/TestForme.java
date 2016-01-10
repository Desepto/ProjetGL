package exo2;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

public class TestForme {

	@Test
	public void testConstructeur() {

		Color c = new Color(1, 2, 3);
		String nom = "test";
		Point p = new Point(1, 2);
		Forme f = new Forme.FormeBuilder().Color(c).Nom(nom).Point(p).build();

		assertEquals(f.getC(), c);
		assertEquals(f.getP(), p);
		assertEquals(f.getNom(), nom);
	}

}
