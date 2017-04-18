package presentation;

import metier.Adresse;
import metier.Contact;
import service.IService;
import service.Service;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Adresse a = new Adresse();
		a.setVille("Lyon");
		a.setNumRue("120 rue massena");
		a.setCodePostal("69006");
		
		Contact c = new Contact();
		c.setNom("toto");
		c.setPrenom("titi");
		c.setEmail("toto.titi@mail.com");
		
		IService is = new Service();
		is.ajouterContactAdresse(c, a);
		
		
	}

}
