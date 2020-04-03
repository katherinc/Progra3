package com.katerin.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.katerin.model.Inventario;

/**
 * Servelte implementation class ServeleteControler
 */
public class ServeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String acction = request.getParameter("btn");
        EntityManager  em;
		
		EntityManagerFactory emf;
		
		emf=Persistence.createEntityManagerFactory("Iniciando-Hibernate-JPA");
		em = emf.createEntityManager();
		Inventario in = new Inventario();
        response.sendRedirect("index.jsp");
		
		
		try {
		String id = request.getParameter("Id");
		String nombrePr = request.getParameter("Nproductos");
		String precioPr = request.getParameter("Pproductos");
		String cantidadPr = request.getParameter("Ccantidad");
		String totalPr = request.getParameter("Tproductos");
		
		
		in.setId(Integer.parseInt(id));
		in.setNombreProducto(nombrePr);
		in.setPrecioProducto(Double.parseDouble(precioPr));
		in.setCantidadProducto(Integer.parseInt(cantidadPr));
		in.setTotalProducto(Double.parseDouble(totalPr));
		
		
		}catch(Exception e) {
			
		}
		
		if(acction.equals("Envio de datos")) {
			
			
			
			em.getTransaction().begin();
			
			////eliminar
			em.remove(in);
			em.persist(in);//insertar
			//em.merge(in);//actualizar/
			em.flush();
			em.getTransaction().commit();
			
			
		
		}else if(acction.equals("Eliminar")) {
			in = em.getReference(Inventario.class,in.getId());
            em.getTransaction().begin();
			////eliminar
			em.remove(in);
			//em.persist(in);//insertar
			//em.merge(in);//actualizar/
			em.flush();
			em.getTransaction().commit();
			
		}else if(acction.equals("Actualizar")) {
			
			em.getTransaction().begin();
			em.merge(in);
			////eliminar
			//em.remove(in);
			//em.persist(in);//insertar
			//em.merge(in);//actualizar/
			em.flush();
			em.getTransaction().commit();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		*/
		
		
	}

}
