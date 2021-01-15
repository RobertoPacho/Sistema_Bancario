/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.Banca_Movil.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Empleado;

/**
 *
 * @author narcisa
 */
@Stateless
public class EmpleadoDAO {

	@PersistenceContext(name = "Banca_MovilPersistenceUnit")
	private EntityManager em;

	/**
	 * Inserta el login mediante el numero el objeto de cliente.
	 *
	 * @param empleado
	 * @return si inserto o no.
	 */
	public boolean insert(Empleado empleado) throws Exception {
		em.persist(empleado);
		System.out.println("estamos aqui");
		return true;
	}

	/**
	 * Actualiza el metodo mediante el objeto de Alogin
	 *
	 * @param alogin
	 * @merge
	 */
	public void update(Empleado empleado) throws Exception {
		try {
			em.merge(empleado);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Empleado " + e.getMessage());
		}
	}

	/**
	 * Elimina el metodo mediante el numero el objeto de empleado.
	 *
	 * @param empleado
	 * @remove
	 */
	public void delete(Empleado empleado) throws Exception {
		try {
			System.out.println("borrando");
			em.remove(read(empleado.getId()));
		} catch (Exception e) {
			throw new Exception("oErro Eliminar Empleado" + e.getMessage());
		}
	}

	/**
	 * Lee el metodo mediante el id
	 *
	 * @param id
	 * @find
	 */
	public Empleado read(int id) throws Exception {
			return em.find(Empleado.class, id);
	}

	/**
	 * El metodo lista todos los cliente existentes
	 *
	 * @createNamedQuery crea un querry para poder listar
	 * @return
	 */
	public List<Empleado> findAll() throws Exception {
		String jpql="Select e from Empleado e";
		Query q = em.createQuery(jpql,Empleado.class);
		return (List<Empleado>) q.getResultList();
	}

	/**
	 * El metodo busca todos los clientes mediante sus id
	 *
	 * @param id
	 * @createNamedQuery crea un querry para poder encontrar
	 * @return
	 */
	public Empleado findByID(String id) throws Exception {
		try {
			Query q = em.createNamedQuery("Empleado.findById");
			q.setParameter("id", Integer.parseInt(id));
			return (Empleado) q.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro buscar por  ID " + e.getMessage());
		}

	}

	/**
	 * El metodo busca todos los clientes mediante sus cedula
	 *
	 * @param cedula
	 * @createNamedQuery crea un querry para poder listar
	 * @return
	 */
	public Empleado findByCedula(String cedula) throws Exception {
		return em.find(Empleado.class, cedula);

	}

	/**
	 * El metodo selecciona el maximo de un id
	 *
	 * @createQuery esta sentencia recibe el querry y la clase
	 * @return
	 */
	public int maxId() throws Exception {
		try {
			Query q = em.createNamedQuery("Empleado.findById");
			return (int) q.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Error MaxID", e.getCause());
		}
	}
}
