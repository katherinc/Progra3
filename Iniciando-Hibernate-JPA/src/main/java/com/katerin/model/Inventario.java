package com.katerin.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@Table(name="Inventario")
@NamedQuery(name="Inventario.findAll", query="SELECT i FROM Inventario i")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidadProducto;

	private String nombreProducto;

	private double precioProducto;

	private double totalProducto;

	public Inventario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getTotalProducto() {
		return this.totalProducto;
	}

	@Override
	public String toString() {
		return "Inventario [id=" + id + ", cantidadProducto=" + cantidadProducto + ", nombreProducto=" + nombreProducto
				+ ", precioProducto=" + precioProducto + ", totalProducto=" + totalProducto + "]";
	}

	public void setTotalProducto(double totalProducto) {
		this.totalProducto = totalProducto;
	}

}