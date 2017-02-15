package org.sistema.springmvc.forms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Represents a delegacion.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Entity
public class Delegacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Min(1)
	private int id;
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	@NotNull
	private String nombre;
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	@NotNull
	private String descripcion;
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	@NotNull
	private String direccion;
	@ManyToOne
    @JoinColumn(name="idciudad")
	private Ciudad ciudad;
	
	/**
	 * default constructor
	 */
	public Delegacion () {
		
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param ciudad
	 */
	public Delegacion(int id, String nombre, String descripcion,String direccion, Ciudad ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getnombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getdescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Delegacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", direccion="
				+ direccion + ", ciudad=" + ciudad + "]";
	}
	
	
	
	

	

}
