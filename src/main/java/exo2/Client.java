package exo2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Classe gérant les différentes formes et leurs modification. Ses méthodes sont
 * appelées par les gestionnaires d'évennements de l'interface graphique
 * (non-présents) Elle est instanciée dans le main (non-présent nécessite
 * l'interface graphique) et respecte le pattern SINGLETON
 * 
 * @author Thomas Estrabaud
 * 
 */
public class Client {

	/**
	 * Liste des formes déjà existantes
	 */
	private ArrayList<Forme> list;
	/**
	 * Paramètre pour le pattern singleton
	 */
	private static Client INSTANCE;
	/**
	 * Représentation des différentes classes de dessin (non-présentes)
	 */
	private Dessin d;

	/**
	 * Consctructeur de la classe Client N'est pas accessible (singleton)
	 */
	private Client() {
		this.list = new ArrayList<Forme>();
		this.d = new Dessin();
	}

	/**
	 * Correspond au pattern singleton, crée un client s'il n'y en a pas encore
	 * de créé sinon renvoit l'existent
	 * 
	 * @return L'instance de client
	 */
	public static Client getClient() {

		if (INSTANCE == null)
			return INSTANCE = new Client();
		return INSTANCE;
	}

	/**
	 * Permet l'ajout d'une forme (les formes sont crées par les gestionnaires
	 * d'évennement en fonction des paramètres qu'ils recoivent de l'interface
	 * graphique puis envoyées au clients)
	 * 
	 * @param f
	 *            Forme à ajouter
	 */
	public void Ajout(Forme f) {
		this.list.add(f);
		this.d.affichage();
	}

	/**
	 * Retrait de la forme dans la liste des formes
	 * 
	 * @param s
	 *            Nom de la forme à retirer
	 */
	public void retrait(String s) {

		for (int i = 0; i < this.list.size(); i++)
			if (this.list.get(i).getNom() == s)
				this.list.remove(i);

		this.d.affichage();
	}

	/**
	 * Change la couleur d'une des formes
	 * 
	 * @param s
	 *            Nom de la forme à modifier
	 * @param c
	 *            Nouvelle couleur
	 */
	public void changerCouleur(String s, Color c) {

		for (int i = 0; i < this.list.size(); i++)
			if (this.list.get(i).getNom() == s)
				this.list.get(i).colorier(c);
		this.d.affichage();
	}

	/**
	 * Déplace la forme de p distance
	 * 
	 * @param s
	 *            Forme à déplacer
	 * @param p
	 *            Distance à déplacer
	 */
	public void deplacer(String s, Point p) {

		for (int i = 0; i < this.list.size(); i++)
			if (this.list.get(i).getNom() == s)
				this.list.get(i).deplacer(p);
		this.d.affichage();
	}

	/**
	 * Tourne une forme tournable en fonction de l'angle (= setter de l'angle)
	 * 
	 * @param s
	 *            Nom de la forme à tourner
	 * @param angle
	 *            Angle avec laquelle tourner la forme
	 */
	public void tourner(String s, float angle) {

		for (int i = 0; i < this.list.size(); i++)
			if (this.list.get(i).getNom() == s) {
				try {
					((FormeOrientable) this.list.get(i)).rotationer(angle);
				} catch (Exception e) {
					System.out.println("Mauvaise forme");
				}
			}
		this.d.affichage();

	}

	/*
	 * Getters
	 */
	public ArrayList<Forme> getList() {
		return list;
	}

	public Dessin getD() {
		return d;
	}
	/*
	 * Fin Getters
	 */
}
