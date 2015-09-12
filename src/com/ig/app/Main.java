package com.ig.app;

import java.util.Date;

import org.hibernate.Session;

import com.ig.modelo.InscripcionDTO;
import com.ig.modelo.SocioDTO;
import com.ig.modelo.UsuarioDTO;
import com.ig.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session hibernate = HibernateUtil.getSessionFactory().openSession();

		// Creo un operador que es el que registra las inscripciones

		UsuarioDTO usuarioOperador = new UsuarioDTO(1454658, "Pablo", "Rodriguez", 47, 4564656, "Carmelita descalza 23", "gimnasio@ortalizas.com", "root", "administrador");

		// Creo tres inscripciones para los socios de abajo y le seteo el
		// administrador que hizo las inscripciones

		InscripcionDTO inscripcionA = new InscripcionDTO(new Date(), 250, true, usuarioOperador);
		InscripcionDTO inscripcionB = new InscripcionDTO(new Date(), 140, false, usuarioOperador);
		InscripcionDTO inscripcionC = new InscripcionDTO(new Date(), 330, true, usuarioOperador);

		// Creamos 3 socios

		// SocioDTO socioA = new SocioDTO(38415607, "Joaquin", "Sanchez", 20,
		// 4394803, "FIgueroalcorta 1760", "mail@mail.com", "Fitness", new
		// InscripcionDTO(new Date(), 250, true, new UsuarioDTO(5456456,
		// "Diego", "Vargas", 2, 5456, "Rodriguez Peña 1456",
		// "tugatito@gmail.com", "1234", "admin")));

		SocioDTO socioA = new SocioDTO(38415607, "Joaquin", "Sanchez", 20, 4394803, "Bario 45465 asda", "email@email.com", "Pesas", inscripcionA);
		SocioDTO socioB = new SocioDTO(14564656, "DIEGO", "Vargas", 02, 14654666, "Rodriguez Peña", "email@email.com", "Mates", inscripcionB);
		SocioDTO socioC = new SocioDTO(23454656, "Tito", "Tomcat", 22, 456456, "UN barrio un barrio", "email@email.com", "Bicicleta", inscripcionC);

		hibernate.beginTransaction();

		hibernate.save(socioA);
		hibernate.save(socioB);
		hibernate.save(socioC);

		hibernate.getTransaction().commit();

		hibernate.close();

	}

}
