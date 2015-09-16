package com.ig.implementaciones;

import java.util.Collection;
import java.util.List;
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

		String hql = "DELETE FROM SocioDTO WHERE soc_per_id = :id";
		Query query = hibernate.createQuery(hql).setString("id", String.valueOf(id));
		return query.executeUpdate();
	}

	@Override
	public void modificarSocio(int id, String nombreNuevo) {
		SocioDTO socio = (SocioDTO) hibernate.get(SocioDTO.class, (long) id);
		socio.setNombre(nombreNuevo);
		hibernate.beginTransaction();
		hibernate.saveOrUpdate(socio);
		hibernate.getTransaction().commit();

	}

	@Override
	public void cargarSocio(SocioDTO socio) {
		if (socio != null) {
			try {
				// Le indico a hibernate que voy a hacer acciones en la base de
				// datos
				hibernate.beginTransaction();
				hibernate.getTransaction().setTimeout(5);
				// Guardo el socio
				hibernate.save(socio);

				// Lo guardo definitivamente
				hibernate.getTransaction().commit();

			} catch (RuntimeException e) {
				try {
					// Esta sentencia esta dentro del cath en caso de error
					// vuelvo
					// atras y no provoco
					// inconsistencias en la base de datos
					hibernate.getTransaction().rollback();
				} catch (RuntimeException rbe) {
					System.err.println("Error guardando el socio " + socio + " Error : " + e);
				}
			} finally {
				if (hibernate != null) {
					// Cierro hibernate si todo marcho correctamente
					hibernate.close();
				}
			}

		}
	}

}
