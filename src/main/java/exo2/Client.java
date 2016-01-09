package exo2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Client {

	private ArrayList<Forme> list;
	private static Client INSTANCE;
	private Dessin d;

	private Client() {
		this.list = new ArrayList<Forme>();
		this.d = new Dessin();
	}

	public Client getClient() {

		if (INSTANCE == null)
			return INSTANCE = new Client();
		return INSTANCE;
	}

	public void Ajout(Forme f) {
		this.list.add(f);
		this.d.affichage();
	}

	public void retrait(String s) {

		for (Forme element : this.list)
			if (element.nom == s)
				this.list.remove(element);
		this.d.affichage();
	}

	public void changerCouleur(String s, Color c) {

		for (Forme element : this.list)
			if (element.nom == s)
				element.colorier(c);
		this.d.affichage();
	}

	public void deplacer(String s, Point p) {

		for (Forme element : this.list)
			if (element.nom == s)
				element.deplacer(p);
		this.d.affichage();
	}

	public void tourner(String s, float angle) {

		for (Forme element : this.list)
			if (element.nom == s) {
				try {
					((FormeOrientable) element).rotationer(angle);
				} catch (Exception e) {
					System.out.println("Mauvaise forme");
				}
			}
		this.d.affichage();

	}

}
