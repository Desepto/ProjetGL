package exo2;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import exo2.Triangle.TriangleBuilder;

public class TestTriangle {

	@Test
	public void testConstructeur() {
		Color c = new Color(1, 2, 3);
		String nom = "test";
		Point p = new Point(1, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(4, 5);
		Triangle f = ((TriangleBuilder) new Triangle.TriangleBuilder().Color(c)
				.Nom(nom).Point(p)).p2(p2).p3(p3).build();

		assertEquals(f.getC(), c);
		assertEquals(f.getP(), p);
		assertEquals(f.getNom(), nom);
		assertEquals(f.getP2(), p2);
		assertEquals(f.getP3(), p3);
	}

}
