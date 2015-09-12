package com.ig.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "socio")
@PrimaryKeyJoinColumn(name = "soc_per_id")
public class SocioDTO extends Persona {

	//Por convencion
	private static final long serialVersionUID = 1L;

	@Column(name = "soc_tipo", length = 20)
	private String tipo;

	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="insc_id")
	private InscripcionDTO inscripcion;




	public SocioDTO(long dni, String nombre, String apellido, long edad, long telefono, String direccion, String email, String tipo, InscripcionDTO inscripcion) {
		super(dni, nombre, apellido, edad, telefono, direccion, email);
		this.tipo = tipo;
		this.inscripcion = inscripcion;
	}

	//Por convencion constructor vacio
	public SocioDTO() {
	}

	// Metodos accesores

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public InscripcionDTO getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(InscripcionDTO inscripcion) {
		this.inscripcion = inscripcion;
	}


}
