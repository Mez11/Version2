package com.redes.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.sql.Blob;

public class Productos implements Serializable {
	/**Parametros provenientes de la BD**/
	private int idProductos;
	private String nombre;
	private Double precio;
	private int existencias;
	private String descripcion;
	private String origen;
	private byte[] imagen;
	private transient BufferedImage image = null;

	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	

}
