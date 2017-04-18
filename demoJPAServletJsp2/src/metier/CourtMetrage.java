package metier;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("COURT")
public class CourtMetrage extends Film {
	
	private String production;

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Override
	public String toString() {
		return "CourtMetrage [production=" + production + ", getIdFilm()=" + getIdFilm() + ", getNomFilm()="
				+ getNomFilm() + super.toString() +  "]";
	}

	
	
}
