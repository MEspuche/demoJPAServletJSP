package metier;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Telefilm")
public class Telefilm extends Film {

	private String chaine;

	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	@Override
	public String toString() {
		return "Telefilm [chaine=" + chaine + ", getIdFilm()=" + getIdFilm() + ", getNomFilm()=" + getNomFilm()
				+  super.toString() +  "]";
	}
	
	
	
}
