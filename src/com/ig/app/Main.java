package com.ig.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.hibernate.Transaction;
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

	public static final String CARGAR_SOCIO = "1";
	public static final String ELIMINAR_SOCIO = "2";
	public static final String LISTAR_SOCIOS = "3";
	public static final String BUSCAR_SOCIO = "4";
	public static final String MODIFICAR_SOCIO = "5";
	
	public static Session hibernate = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {

//		crearSocios();
		SocioDAO socioService = new SocioDAOImple();
		Scanner lector = new Scanner(System.in);
		
		//Llamo al metodo que muestra el menu
		mostrarMenu();
		
		String opcion = lector.nextLine();
		switch (opcion) {

		case CARGAR_SOCIO:
			//No lo desarrolle por que hay que ir seteandole como 20 datos por cada objeto
			//Socio
			//Inscripcion
			//Usuario
			break;

		case ELIMINAR_SOCIO:
			
			System.out.print("Ingrese el id del socio a eliminar: ");
			int id = lector.nextInt();
			socioService.eliminarPorID(id);
			break;

		case LISTAR_SOCIOS:
			System.out.println("Socios disponibles en la base de datos:");
			Collection<SocioDTO> socios = socioService.buscarTodos();
			for (SocioDTO socioDTO : socios) {
				System.out.println(socioDTO);
			}

			break;

		case BUSCAR_SOCIO:
			System.out.print("Ingrese el id del socio a buscar: ");
			int idPK = lector.nextInt();
			SocioDTO socio= socioService.buscarSocio(idPK);
			System.out.println(socio);
			break;

		case MODIFICAR_SOCIO:
			//No lo desarrolle por que hay que ir seteandole como 20 datos por cada objeto
			//Socio
			//Inscripcion
			//Usuario
			break;

		default:
			System.out.println("Opcion incorrecta !!");
			break;
		}

	}

	public static void crearSocios() {

		UsuarioDTO usuarioOperador = new UsuarioDTO(1454658, "Pablo", "Rodriguez", 47, 4564656, "Carmelita descalza 23", "gimnasio@ortalizas.com", "root", "administrador");

		InscripcionDTO inscripcionA = new InscripcionDTO(new Date(), 250, true, usuarioOperador);
		InscripcionDTO inscripcionB = new InscripcionDTO(new Date(), 140, false, usuarioOperador);
		InscripcionDTO inscripcionC = new InscripcionDTO(new Date(), 330, true, usuarioOperador);

		SocioDTO socioA = new SocioDTO(38415607, "Joaquin", "Sanchez", 20, 4394803, "Bario 45465 asda", "email@email.com", "Pesas", inscripcionA);
		SocioDTO socioB = new SocioDTO(14564656, "DIEGO", "Vargas", 02, 14654666, "Rodriguez Peña", "email@email.com", "Spinning", inscripcionB);
		SocioDTO socioC = new SocioDTO(23454656, "Tito", "Tomcat", 22, 456456, "UN barrio un barrio", "email@email.com", "Bicicleta", inscripcionC);

		Transaction transaccion = hibernate.getTransaction();
		transaccion.begin();

		hibernate.save(socioA);
		hibernate.save(socioB);
		hibernate.save(socioC);

		transaccion.commit();

	}

	public static void mostrarMenu(){

		System.out.println("Simulando vista: - Bienvenido a IG -");
		System.out.println("Menu ADMINISTRADOR ");
		System.out.println("1) Cargar un socio");
		System.out.println("2) Eliminar un socio");
		System.out.println("3) Buscar todos los socios");
		System.out.println("4) Buscar un socio en particular");
		System.out.println("5) Modificar un socio");
		System.out.print("Ingrese la opcion a realizar: ");
	}
}
