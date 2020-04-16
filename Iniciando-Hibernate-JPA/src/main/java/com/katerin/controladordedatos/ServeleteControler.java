package com.katerin.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.katerin.DAO.ProductoDao;
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
		Inventario in = new Inventario();
		ProductoDao prdao = new ProductoDao();
		String id= null;
		String nombrePr= null ;
		String precioPr = null;
		String cantidadPr= null;
		String totalPr= null;
        try {
		id= request.getParameter("Id");
		nombrePr= request.getParameter("Nproductos");
		precioPr= request.getParameter("Pproductos");
		cantidadPr= request.getParameter("Ccantidad");
		totalPr = request.getParameter("Tproductos");
		
		
		in.setId(Integer.parseInt(id));
		in.setNombreProducto(nombrePr);
		in.setPrecioProducto(Double.parseDouble(precioPr));
		in.setCantidadProducto(Integer.parseInt(cantidadPr));
		in.setTotalProducto(Double.parseDouble(totalPr));
		
        }
		catch(Exception e) {
			
		}
		
		String acction = request.getParameter("btn");
		
		if (acction.equals("GUARDAR")) {
			in.setId(Integer.parseInt(id));
			in.setNombreProducto(nombrePr);
			in.setPrecioProducto(Double.parseDouble(precioPr));
			in.setCantidadProducto(Integer.parseInt(cantidadPr));
			in.setTotalProducto(Double.parseDouble(totalPr));
		
	    prdao.agregarDatos(in);
	    response.sendRedirect("index.jsp");
		}
		else if(acction.equals("ACTUALIZAR")) {
			in.setId(Integer.parseInt(id));
			in.setNombreProducto(nombrePr);
			in.setPrecioProducto(Double.parseDouble(precioPr));
			in.setCantidadProducto(Integer.parseInt(cantidadPr));
			in.setTotalProducto(Double.parseDouble(totalPr));
			prdao.ActualizarDatos(in);
			response.sendRedirect("index.jsp");
			
		}else if(acction.equals("ELIMINAR")) {
			in.setId(Integer.parseInt(id));
			prdao.Eliminar(in);
			response.sendRedirect("index.jsp");
		}
			
			
			
		
	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ProductoDao prdao = new ProductoDao();
		Gson json = new Gson();
		
		try {
			response.getWriter().append(json.toJson(prdao.inventarioLista()));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		*/
		
		
	}


