package com.ig.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//Que sea reconocido por hibernate como una entidad
@Entity
// Va a representar una tabla con nombre 'persona'
@Table(name = "persona")
// Definimos el tipo de herencia con union a partir de los ID de los hijos
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

	// Por convencion se implementa Serializable es una buena practica
	private static final long serialVersionUID = 1L;

	// Decimos que la clave primaria va a ser el atributo id representado en la
	// tabla por el nombre per_id y va a ser auto_incrementable y no nulo
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "per_id", nullable = false)
	private long id;

	@Column(name = "per_dni")
	private long dni;

	// Decimos que el atributo nombre se va a representar en la tabla como
	// 'per_nombre' no nulo y de longitud 40
	@Column(name = "per_nombre", nullable = false, length = 40)
	private String nombre;

	// Decimos que el atributo apellido se va a representar en la tabla como
	// 'per_apellido' no nulo y de longitud 40
	@Column(name = "per_apellido", nullable = false, length = 40)
	private String apellido;

	// Yo considero que la edad no es relevante asi que dejo que pueda ser nula
	// si no lo defino
	@Column(name = "per_edad")
	private long edad;

	@Column(name = "per_telefono")
	private long telefono;

	@Column(name = "per_direccion", length = 55)
	private String direccion;

	@Column(name = "per_email", length = 25)
	private String email;

	public Persona(long dni, String nombre, String apellido, long edad, long telefono, String direccion, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}

	// Por convencion se deja un constructor vacio es una buena practica
	public Persona() {
	}

	// Metodos accesores
	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getEdad() {
		return edad;
	}

	public void setEdad(long edad) {
		this.edad = edad;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + "]";
	}

}
