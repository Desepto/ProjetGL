package exo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class TestClient {

	Client c = Client.getClient();
	Forme f = new Forme.FormeBuilder().build();
	String s = "test";

	@Before
	public void nommerF() {
		this.f.nommer(s);
	}

	@Test
	public void testAjout() {
		Forme f = new Forme.FormeBuilder().build();
		c.Ajout(f);
		assertFalse(c.getList().isEmpty());
	}

	@Test
	public void testDeplacer() {
		Point p = new Point(1, 1);
		c.Ajout(f);
		c.deplacer(s, p);
		System.out.println(c.getList().get(0).getP());
		assertEquals(c.getList().get(0).getP(), p);
	}

	@Test
	public void testRetrait() {
		c.getList().get(0).nommer(s);
		c.retrait(s);
		assertTrue(c.getList().isEmpty());
	}

}
