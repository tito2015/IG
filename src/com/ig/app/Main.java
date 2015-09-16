package com.ig.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ig.implementaciones.SocioDAOImple;
import com.ig.interfaces.SocioDAO;
import com.ig.modelo.InscripcionDTO;
import com.ig.modelo.Persona;
import com.ig.modelo.SocioDTO;
import com.ig.modelo.UsuarioDTO;
import com.ig.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session hibernate = HibernateUtil.getSessionFactory().openSession();

	
	
//		UsuarioDTO usuarioOperador = new UsuarioDTO(1454658, "Pablo", "Rodriguez", 47, 4564656, "Carmelita descalza 23", "gimnasio@ortalizas.com", "root", "administrador");

//		InscripcionDTO inscripcionA = new InscripcionDTO(new Date(), 250, true, usuarioOperador);
//		InscripcionDTO inscripcionB = new InscripcionDTO(new Date(), 140, false, usuarioOperador);
//		InscripcionDTO inscripcionC = new InscripcionDTO(new Date(), 330, true, usuarioOperador);
//
//		SocioDTO socioA = new SocioDTO(38415607, "Joaquin", "Sanchez", 20, 4394803, "Bario 45465 asda", "email@email.com", "Pesas", inscripcionA);
//		SocioDTO socioB = new SocioDTO(14564656, "DIEGO", "Vargas", 02, 14654666, "Rodriguez Peña", "email@email.com", "Mates", inscripcionB);
//		SocioDTO socioC = new SocioDTO(23454656, "Tito", "Tomcat", 22, 456456, "UN barrio un barrio", "email@email.com", "Bicicleta", inscripcionC);

	
		
		

//		SocioDAO socioDAO = new SocioDAOImple();
//		Collection<SocioDTO> socios = socioDAO.buscarTodos();
//		System.out.println("Todos los socios disponibles:");
//		for (SocioDTO socioDTO : socios) {
//			System.out.println(socioDTO);
//		}
//		
//		System.out.println("Eliminamos algun socio");
//		int filasAfectadas=socioDAO.eliminarPorID(3);
//		System.out.println("Se elimino "+filasAfectadas);
//	
//		System.out.println("Cambiamos un dato");
//		socioDAO.modificarSocio(4,"Un nuevo nombre");
	
	
		
		
		SocioDAO socioService = new SocioDAOImple();
		
	
		SocioDTO test = null;
		socioService.cargarSocio(test);
		
		
	}

}
