package divers;

public class Ville {
	int superficie;
	int nb_habitant;
	String nom;
	
	public Ville(int superficie, int nb_habitant, String nom) {
		this.superficie=superficie;
		this.nb_habitant=nb_habitant;
		this.nom=nom;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getNb_habitant() {
		return nb_habitant;
	}

	public void setNb_habitant(int nb_habitant) {
		this.nb_habitant = nb_habitant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
