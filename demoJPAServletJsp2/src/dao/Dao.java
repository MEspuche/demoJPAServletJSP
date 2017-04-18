package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;

public class Dao implements IDao {

	// 1. Ouverture de l'unite de persistence
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
	
	
	
	@Override
	public int ajouterAdresse(Adresse a)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();
		return a.getId();
	}
	
	@Override
	public int ajouterContactAdresse (Contact c, Adresse a)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		c.setAdresse(a);
		em.persist(c);
		tx.commit();
		em.close();
		return a.getId();
	}
	
	@Override
	public int modifierAdresse(Adresse a)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(a);
		tx.commit();
		em.close();
		return a.getId();
		
	}
	
	@Override
	public Collection<Contact> findAllContacts()
	{
		EntityManager em = emf.createEntityManager();
		Query q4 = em.createNamedQuery("Contact.findAll");
		List<Contact> liste4 = q4.getResultList();
		em.close();
		return liste4;
		
	}
	
	@Override
	public Adresse findAdresse(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Adresse a WHERE a.id = :lid");
		q.setParameter("lid", id);
		List<Adresse> adresse  = q.getResultList();
		Adresse a1 = new Adresse();
		for (Adresse a : adresse)
		{
			a1.setNumRue(a.getNumRue());
			a1.setCodePostal(a.getCodePostal());
			a1.setVille(a.getVille());
		}
		em.close();
		return a1;
		
	}
	
	@Override
	public void deleteAdresse(Adresse a)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(a);
		tx.commit();
		em.close();
		
	}
	 
	
}
