package com.ig.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="usuario")
@PrimaryKeyJoinColumn(name="user_per_id")
public class UsuarioDTO extends Persona{


	private static final long serialVersionUID = 1L;
	
	@Column(name="user_password",nullable=false,length=20)
	private String password;
	
	@Column(name="user_acceso",length=15)
	private String acceso;
	

	public UsuarioDTO(){}

	public UsuarioDTO(long dni, String nombre, String apellido, long edad, long telefono, String direccion, String email, String password, String acceso) {
		super(dni, nombre, apellido, edad, telefono, direccion, email);
		this.password = password;
		this.acceso = acceso;
	}
	
	//Accesores

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcceso() {
		return acceso;
	}

	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}
	
	
	
	
	
	
	
	
	
	
	
}
