package org.sistema.springmvc.forms.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Represents a ciudad.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Entity
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Min(1)
	private int id;
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	@NotNull
	private String nombre;
	@Pattern(regexp = "[0-9]+", message = "Must contain only chars and numbers")
	@Range(min=10000,max=99999, message="Cpostal must be between 10000 and 99999")
	private String cpostal;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="ciudad")
	private Set<Delegacion> delegaciones = new HashSet<Delegacion>();

	/**
	 * default constructor
	 */
	public Ciudad() {
	}

	/**
	 * constructor with parameters
	 * @param id
	 * @param nombre
	 * @param cpostal
	 * @param iddelegacion
	 */
	public Ciudad(int id, String nombre, String cpostal) {
		this.id = id;
		this.nombre = nombre;
		this.cpostal = cpostal;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getcpostal() {
		return cpostal;
	}

	public void setcpostal(String cpostal) {
		this.cpostal = cpostal;
	}


	/**
	 * @return the delegaciones
	 */
	public Set<Delegacion> getdelegaciones() {
		return delegaciones;
	}

	/**
	 * @param delegaciones the delegaciones to set
	 */
	public void setdelegaciones(Set<Delegacion> delegaciones) {
		this.delegaciones = delegaciones;
	}

}
