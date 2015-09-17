package com.ig.interfaces;

import java.util.Collection;

import com.ig.modelo.SocioDTO;

public interface SocioDAO {
	
	/**
	 * Metodo buscarTodos: devuelve una "coleccion" con todos los socios
	 * que se encuentran en la base de datos
	 */
	public Collection<SocioDTO> buscarTodos();
	
	/**
	 * Metodo eliminar: Elimina el socio con el id igual al id que se encuentra
	 * en el parametro
	 * @param id (la clave unica del socio para identificarlo)
	 * @return cuantas filas elimino o afecto la sentencia
	 */
	public int eliminarPorID(int id);
	
	/**
	 * Metodo de prueba envia el id del usuario y el nuevo nombre que
	 * tendra
	 * @param id (la clave unica del socio para identificarlo)
	 * @param nombreNuevo (El nuevo nombre que queremos)
	 */
	
	public void modificarSocio(int id,SocioDTO socio);

	
	/**
	 * Guarda un socio en la base de datos
	 * @param socio (el socio a guardar)
	 */
	public void cargarSocio(SocioDTO socio);
	
	public SocioDTO buscarSocio(int id);
	
	
	/*
	 * Crear
	 * Leer
	 * Eliminar
	 * Actualizar
	 */
	
	

}
