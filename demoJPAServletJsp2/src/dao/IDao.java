package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;

public interface IDao {

	public int ajouterAdresse( Adresse a);

	public int ajouterContactAdresse(Contact c, Adresse a);


	public int modifierAdresse(Adresse a);
	public Collection<Contact> findAllContacts();
	public Adresse findAdresse(int id);
	public void deleteAdresse(Adresse a);
	
	
	
}
