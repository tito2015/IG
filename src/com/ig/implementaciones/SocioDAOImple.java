package com.ig.implementaciones;

import java.util.Collection;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ig.interfaces.SocioDAO;
import com.ig.modelo.SocioDTO;
import com.ig.util.HibernateUtil;

public class SocioDAOImple implements SocioDAO {

	public Session hibernate = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Collection<SocioDTO> buscarTodos() {

		Criteria criteria = hibernate.createCriteria(SocioDTO.class);
		List<SocioDTO> listaSocios = criteria.list();
		return listaSocios;
	}

	@Override
	public int eliminarPorID(int id) {
		Transaction transaccion = hibernate.getTransaction();
		int filas = 0;
		try {
			transaccion.begin();
			String hql = "DELETE FROM SocioDTO WHERE soc_per_id = :id";
			Query query = hibernate.createQuery(hql).setString("id", String.valueOf(id));
			filas = query.executeUpdate();
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			System.err.println("Error eliminando socio: " + e);
		} finally {
			if (hibernate != null) {
				// Cierro hibernate si todo marcho correctamente
				hibernate.close();
			}
		}
		return filas;
	}

	@Override
	public void modificarSocio(int id, SocioDTO socioNuevo) {
		// Obtengo el socio a partir de su id (pk)
		SocioDTO socioAntiguo = (SocioDTO) hibernate.get(SocioDTO.class, (long) id);
		// Le cambio el nombre
		socioAntiguo=socioNuevo;
		// Obtengo un objeto para realizar e indicarle a la bd que hare
		// transacciones en la base de datos
		Transaction transaccion = hibernate.getTransaction();
		try {
			// Le indico a hibernate que voy a hacer acciones en la base de
			// datos
			transaccion.begin();
			transaccion.setTimeout(5);
			// Modifico el socio
			hibernate.saveOrUpdate(socioAntiguo);
			// Lo guardo definitivamente
			transaccion.commit();

		} catch (Exception e) {
			try {
				// Esta sentencia esta dentro del cath en caso de error
				// vuelvo
				// atras y no provoco
				// inconsistencias en la base de datos
				transaccion.rollback();

			} catch (Exception e2) {
				System.err.println("Error modificando socio " + socioAntiguo + " Error: " + e + " - " + e2);
			} finally {
				if (hibernate != null) {
					// Cierro hibernate si todo marcho correctamente
					hibernate.close();
				}
			}
		}

	}

	@Override
	public void cargarSocio(SocioDTO socio) {
		// Obtengo un objeto para realizar e indicarle a la bd que hare
		// transacciones en la base de datos
		Transaction transaccion = hibernate.getTransaction();
		try {
			// Le indico a hibernate que voy a hacer acciones en la base de
			// datos
			transaccion.begin();
			transaccion.setTimeout(5);
			// Guardo el socio
			hibernate.save(socio);

			// Lo guardo definitivamente
			transaccion.commit();

		} catch (RuntimeException e) {
			try {
				// Esta sentencia esta dentro del cath en caso de error
				// vuelvo
				// atras y no provoco
				// inconsistencias en la base de datos
				transaccion.rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Error guardando el socio " + socio + " Error : " + e + " - " + rbe);
			}
		} finally {
			if (hibernate != null) {
				// Cierro hibernate si todo marcho correctamente
				hibernate.close();
			}
		}

	}

	@Override
	public SocioDTO buscarSocio(int id) {
		SocioDTO socio=null;
		try {
			
			socio = (SocioDTO)hibernate.get(SocioDTO.class, (long)id);
			
		} catch (Exception e) {
			System.err.println("No pude devolver el socio con id "+id);
		}
		return socio;
	}

}
