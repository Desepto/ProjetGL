package exo1;

import java.util.ArrayList;

/**
 * La classe Message définit l'énum Type, l'objet Message et les méthodes pour
 * filtrer en fonction de différents paramètres. ** Respect d'OCP : il suffit de
 * créer une classe héritant de Message (ex : MessagePlusComplique) et lui
 * donner de nouveaux paramètres/méthodes de tri **
 * 
 * 
 * @author Thomas Estrabaud
 * 
 * 
 */

public class Message {

	/*
	 * Enumération utilisée
	 */

	public enum Type {
		TEXT, BYTE, XML;
	}

	/*
	 * Paramètres
	 */

	private Type t;
	private int taille;
	private String st;

	/*
	 * Getters
	 */

	public Type getT() {
		return t;
	}

	public int getTaille() {
		return taille;
	}

	public String getSt() {
		return st;
	}

	/**
	 * Constructeur de Message
	 * 
	 * @param t
	 *            Type du message (enum Type)
	 * @param taille
	 *            Taille du message
	 * @param st
	 *            Contenu du message
	 */
	public Message(Type t, int taille, String st) {

		if (taille < 0)
			throw new IllegalArgumentException();

		this.t = t;
		this.taille = taille;
		this.st = st;
	}

	/**
	 * Indique si le message correspond au filtre
	 * 
	 * @param t
	 *            Type sur lequel filtrer
	 * @return Vrai si il correspond au type
	 */
	public boolean filtre(Type t) {
		return this.t.equals(t);
	}

	/**
	 * Indique si le message correspond au filtre
	 * 
	 * @param taille
	 *            taille sur laquelle filtrer
	 * @return Vrai si il correspond à la taille
	 */
	public boolean filtre(int taille) {
		return this.taille == taille;
	}

	public boolean filtre(Object o) {

		if (o.getClass() == this.t.getClass())
			return this.t.equals(o);
		if (o.getClass() == ((Integer) this.taille).getClass())
			return ((Integer) this.taille).equals(o);
		if (o.getClass() == this.st.getClass())
			return this.st.equals(o);

		throw new IllegalArgumentException();
	}

	/**
	 * Indique si le message correspond au filtre. On considère que le message
	 * doit être filtré si les deux contenus sont identiques
	 * 
	 * @param st
	 *            Contenu du message sur lequel filtrer
	 * @return Vrai si les messages sont identiques
	 */
	public boolean filtre(String st) {
		return this.st == st;
	}

	/**
	 * Reçoit une liste de messages et un objet, retire les éléments
	 * correspondant à l'objet et renvoie la liste
	 * 
	 * @param messages
	 *            Liste des messages à trier
	 * @param o
	 *            Type du paramètre + son contenu sur lequel trier les éléments
	 *            (doit être un Type, int ou un String)
	 * @return La liste de laquelle on a retiré les éléments non-désirés
	 */
	public static ArrayList<Message> filtre(ArrayList<Message> messages,
			Object o) {

		for (int i = 0; i < messages.size(); i++)
			if (messages.get(i).filtre(o))
				messages.remove(i);
		return messages;
	}

}
