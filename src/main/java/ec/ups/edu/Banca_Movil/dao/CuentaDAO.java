package ec.ups.edu.Banca_Movil.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;

@Stateless
public class CuentaDAO {

	@PersistenceContext(name = "BancaMovilPersistenceUnit")
	private EntityManager em;
	
	@Inject
	Cuenta cuenta;

	public CuentaDAO() {
	}

	/**
	 * Inserta el login mediante el numero el objeto de cuenta.
	 * 
	 * @param cuenta
	 * @return si inserto o no.
	 */

	public boolean insert(Cuenta cuenta) throws Exception {
		
		em.persist(cuenta);
		return true;
	}

	/**
	 * Elimina el metodo mediante el numero el objeto de cuenta.
	 * 
	 * @param cuenta
	 * @remove
	 */
	public void delete(Cuenta cuenta) throws Exception {
		em.remove(read(cuenta.getId()));
	}

	/**
	 * Elimina el metodo mediante el id.
	 * 
	 * @param id
	 * @remove
	 */

	public void deleteId(int id) throws Exception {
		em.remove(read(id));
	}

	
	/**
	 * Actualiza el metodo mediante el objeto de Alogin
	 * 
	 * @param alogin
	 * @merge
	 */

	public void update(Cuenta cuenta) throws Exception {
		em.merge(cuenta);
	}

	/**
	 * Lee el metodo mediante el id
	 * 
	 * @param id
	 * @find
	 */

	public Cuenta read(int id) throws Exception {
		return em.find(Cuenta.class, id);
	}
	
	/**
	 * buscamos mediante la cedula
	 * 
	 * @param id
	 * @find
	 */

	public Cuenta buscarCedula(String cedula) throws Exception {
		String jpql = "Select c from Cuenta c";
		Query q = em.createQuery(jpql, Cuenta.class);
		List<Cuenta> lista = q.getResultList();	
		for(int i=0; i < lista.size(); i++) {
			if(lista.get(i).getCedula().equals(cedula)) {
				cuenta.setId(lista.get(i).getId());
				cuenta.setCedula(lista.get(i).getCedula());
				cuenta.setNombres(lista.get(i).getNombres());
				cuenta.setApellido(lista.get(i).getApellido());
				cuenta.setCorreo(lista.get(i).getCorreo());
				cuenta.setDireccion(lista.get(i).getDireccion());
				cuenta.setNumerocuenta(lista.get(i).getNumerocuenta());
				return cuenta;
			}
		}
		return cuenta;
	}

	/**
	 * El metodo lista todos los cuenta existentes
	 * 
	 * @createNamedQuery crea un querry para poder listar
	 * @return
	 */
	public List<Cuenta> findAll() throws Exception {
		String jpql = "Select c from Cuenta c";
		Query q = em.createQuery(jpql, Cuenta.class);
		return (List<Cuenta>) q.getResultList();
	}

	/**
	 * El metodo lista todos los cuentas por su codigo
	 * 
	 * @param codigo
	 * @createNamedQuery crea un querry para poder listar
	 * @return
	 */

	public List<Cuenta> findAllCodigo(String codigo) throws Exception {

		try {
			Query q = em.createNamedQuery("Cuenta.findAllCodigo");
			q.setParameter("codigo", "%" + codigo + "%");
			List<Cuenta> lista = q.getResultList();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro listar Cuenta " + e.getMessage());
		}

	}

	/**
	 * El metodo busca todos los cuentas mediante sus id
	 * 
	 * @param id
	 * @createNamedQuery crea un querry para poder encontrar
	 * @return
	 */

	public Cuenta findByID(String id) throws Exception {
		try {
			Query q = em.createNamedQuery("Cuenta.findById");
			q.setParameter("id", Integer.parseInt(id));
			return (Cuenta) q.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro buscar por  ID " + e.getMessage());
		}

	}

	public Cuenta findByNuemor(String numero) throws Exception {
		try {
			Query q = em.createNamedQuery("Cuenta.findByNumero");
			q.setParameter("numero", numero);
			return (Cuenta) q.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro buscar por  numero " + e.getMessage());
		}

	}

	/**
	 * El metodo busca todos los cuentas mediante sus cedula
	 * 
	 * @param cedula
	 * @createNamedQuery crea un querry para poder listar
	 * @return
	 */
	public Cuenta findByCedula(String cedula) throws Exception {
		try {
			Query q = em.createNamedQuery("Cuenta.findByCedula");
			q.setParameter("cedula", cedula);
			return (Cuenta) q.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro buscar por  cedula");
		}

	}

}
