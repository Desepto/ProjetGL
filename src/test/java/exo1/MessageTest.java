package exo1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exo1.Message.Type;

/**
 * Classe de test de la classe Message
 * 
 * @author Thomas Estrabaud
 * 
 */

public class MessageTest {

	/*
	 * Création des variables utilisées dans les test
	 */
	Message m = new Message(Type.XML, 5, "Test");
	ArrayList<Message> me = new ArrayList<Message>();

	@Before
	public void remplissageListe() {
		me.add(m);
		me.add(new Message((Type.BYTE), 6, "Test2"));
		me.add(new Message((Type.TEXT), 8, "Test3"));
	}

	/**
	 * Teste si le filtre par type fonctionne
	 */
	@Test
	public void testFiltreType() {
		assertTrue(m.filtre(Type.XML));
		assertFalse(m.filtre(Type.BYTE));
	}

	/**
	 * Teste si le filtre par taille fonctionne
	 */
	@Test
	public void testFiltreInt() {
		assertTrue(m.filtre(5));
		assertFalse(m.filtre(6));
	}

	/**
	 * Teste si le filtre par contenu fonctionne
	 */
	@Test
	public void testFiltreString() {
		assertTrue(m.filtre("Test"));
		assertFalse(m.filtre("Erreur"));
	}

	/**
	 * Teste si on rejette bien dans le cas d'un mauvais arguement
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFiltreAutreTypeObject() {
		m.filtre(3.5);
	}

	/*
	 * J'ai recopié la méthode ici car il ne la trouvait pas...
	 */
	public static ArrayList<Message> filtre(ArrayList<Message> messages,
			Object o) {

		for (int i = 0; i < messages.size(); i++)
			if (messages.get(i).filtre(o))
				messages.remove(i);
		return messages;
	}

	/**
	 * Teste si le filtre par type fonctionne sur une liste de messages
	 */
	@Test
	public void testFiltreListeMessagesType() {

		ArrayList<Message> list = filtre(me, (Object) Type.XML);
		assertTrue(list.get(0).getT() == Type.BYTE);
		assertTrue(list.get(1).getT() == Type.TEXT);
		assertTrue(list.size() == 2);
	}

	/**
	 * Teste si le filtre par taille fonctionne sur une liste de messages
	 */
	@Test
	public void testFiltreListeMessagesInt() {

		ArrayList<Message> list = filtre(me, new Integer(5));
		assertTrue(list.size() == 2);
		assertTrue(list.get(0).getTaille() == 6);
		assertTrue(list.get(1).getTaille() == 8);

	}

	/**
	 * Teste si le filtre par contenu fonctionne sur une liste de messages
	 */
	@Test
	public void testFiltreListeMessagesString() {

		ArrayList<Message> list = filtre(me, "Test");
		assertTrue(list.size() == 2);
		assertTrue(list.get(0).getSt() == "Test2");
		assertTrue(list.get(1).getSt() == "Test3");
	}

}
