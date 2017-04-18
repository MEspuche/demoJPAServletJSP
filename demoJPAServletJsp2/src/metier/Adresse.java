package metier;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@NamedQueries({
		 @NamedQuery (name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
		 @NamedQuery (name = "Adresse.findSome", query = "SELECT a FROM Adresse a WHERE a.numRue LIKE :ladresse")
			})
public class Adresse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADRESSE_ID")
	private int id;
	private String numRue;
	private String ville;
	private String codePostal;
	@Transient
	private String commentaires;
	
	@OneToMany(mappedBy="adresse", fetch=FetchType.LAZY)
	private Collection<Contact> contact;
	
	 
	
	public Adresse() {
		super();
	}
	public Adresse(String numRue, String ville, String codePostal) {
		super();
		this.numRue = numRue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public Collection<Contact> getContact() {
		return contact;
	}
	public void setContact(Collection<Contact> contact) {
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numRue=" + numRue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	
	

}