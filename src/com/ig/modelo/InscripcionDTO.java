package com.ig.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscripcion")
public class InscripcionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insc_id")
	private long id;

	// Le decimos que el atributo fecha se representara en la tabla como
	// 'insc_fecha' y solo almacenara el dia
	@Column(name = "insc_fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "insc_precio")
	private double precio;

	@Column(name = "insc_estado")
	private boolean estado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_per_id")
	private UsuarioDTO usuario;


	public InscripcionDTO(Date fecha, double precio, boolean estado, UsuarioDTO usuario) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.estado = estado;
		this.usuario = usuario;
	}

	public InscripcionDTO() {
	}

	// METODOS ACCESORES

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	
	
}
