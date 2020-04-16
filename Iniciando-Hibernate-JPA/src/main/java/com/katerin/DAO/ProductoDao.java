package com.katerin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.katerin.model.Inventario;

public class ProductoDao {
	public List<Inventario> inventarioLista(){
		List<Inventario> listain = new ArrayList<Inventario>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Iniciando-Hibernate-JPA");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			listain = em.createQuery("from Inventario").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return listain;
	}
	
	public void agregarDatos(Inventario  in) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Iniciando-Hibernate-JPA");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		////eliminar
		em.remove(in);
		em.persist(in);//insertar
		//em.merge(in);//actualizar/
		em.flush();
		em.getTransaction().commit();
			
	}
	public void ActualizarDatos(Inventario in) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Iniciando-Hibernate-JPA");
		em = emf.createEntityManager();
		
	    in.getId();
	    in.getCantidadProducto();
	    in.getNombreProducto();
	    in.getPrecioProducto();
	    in.getTotalProducto();
		em.getTransaction().begin();
		em.merge(in);
		////eliminar
		//em.remove(in);
		//em.persist(in);//insertar
		//em.merge(in);//actualizar/
		em.flush();
		em.getTransaction().commit();

		
	}
	public void Eliminar(Inventario in) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Iniciando-Hibernate-JPA");
		em = emf.createEntityManager();
		in = em.getReference(Inventario.class,in.getId());
        em.getTransaction().begin();
		////eliminar
		em.remove(in);
		//em.persist(in);//insertar
		//em.merge(in);//actualizar/
		em.flush();
		em.getTransaction().commit();
		
	}

}
