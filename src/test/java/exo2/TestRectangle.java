package exo2;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import exo2.Rectangle.RectangleBuilder;

public class TestRectangle {

	@Test
	public void testConstructeur() {
		Color c = new Color(1, 2, 3);
		String nom = "test";
		Point p = new Point(1, 2);
		Point p2 = new Point(2, 3);
		Rectangle f = ((RectangleBuilder) new Rectangle.RectangleBuilder()
				.Color(c).Nom(nom).Point(p)).p2(p2).build();

		assertEquals(f.getC(), c);
		assertEquals(f.getP(), p);
		assertEquals(f.getNom(), nom);
		assertEquals(f.getP2(), p2);
	}

}
