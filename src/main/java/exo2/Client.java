package exo2;

import java.util.ArrayList;

public class Client {

	ArrayList<Forme> list;
	private static Client INSTANCE;

	private Client() {
		this.list = new ArrayList<Forme>();
	}

	public Client getClient() {

		if (INSTANCE == null)
			return INSTANCE = new Client();
		return INSTANCE;
	}

	public void Ajout(Forme f) {
		this.list.add(f);
	}

	public void retrait(Forme f) {
		this.list.remove(f);
	}

}
