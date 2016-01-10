package exo2;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import exo2.Carre.CarreBuilder;

public class TestCarre {

	@Test
	public void testConstructeur() {
		Color c = new Color(1, 2, 3);
		String nom = "test";
		Point p = new Point(1, 2);
		int cote = 5;
		Carre f = ((CarreBuilder) new Carre.CarreBuilder().Color(c).Nom(nom)
				.Point(p)).cote(cote).build();

		assertEquals(f.getC(), c);
		assertEquals(f.getP(), p);
		assertEquals(f.getNom(), nom);
		assertEquals(f.getCote(), cote);
	}
}
