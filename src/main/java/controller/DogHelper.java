package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dogs;

public class DogHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dogs");
	
	public void insertDog(Dogs d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Dogs> showAllDogs() {
		EntityManager em = emfactory.createEntityManager();
		List<Dogs> allDogs = em.createQuery("SELECT i FROM Dogs i").getResultList();
		return allDogs;
	}
	
	
	public void deleteDog(Dogs toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dogs> typedQuery = em.createQuery("select d from Dogs d where d.name = "
				+ ":selectedName and d.breed = :selectedBreed and d.color = :selectedColor", 
				Dogs.class);
		
		// Substitute parameter with actual data from toDelete Item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get result and save it into a new dog
		Dogs result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}


	public void updateDog(Dogs toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	public List<Dogs> searchForDogByName(String dogName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dogs> typedQuery = em.createQuery("select d from Dogs d where d.name "
				+ "= :selectedName", Dogs.class);
		typedQuery.setParameter("selectedName", dogName);
		List<Dogs> foundDog = typedQuery.getResultList();
		em.close();
		return foundDog;
	}


	public List<Dogs> searchForDogByBreed(String breedName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dogs> typedQuery = em.createQuery("select d from Dogs d where d.breed "
				+ "= :selectedBreed", Dogs.class);
		typedQuery.setParameter("selectedBreed:", breedName);
		List<Dogs> foundDog = typedQuery.getResultList();
		em.close();
		return foundDog;
	}


	public List<Dogs> searchForDogByColor(String colorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dogs> typedQuery = em.createQuery("select d from Dogs d where d.color "
				+ "= :selectedColor", Dogs.class);
		typedQuery.setParameter("selectedColor:", colorName);
		List<Dogs> foundDog = typedQuery.getResultList();
		em.close();
		return foundDog;
	}


	public Dogs searchForDogById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dogs found = em.find(Dogs.class, idToEdit);
		em.close();
		return found;
	}
	
	
	public void cleanUp() {
		emfactory.close();
	}


}
