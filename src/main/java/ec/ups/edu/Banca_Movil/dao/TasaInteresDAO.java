/**
 * 
 */
package ec.ups.edu.Banca_Movil.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.TasaInteres;
import ec.ups.edu.Banca_Movil.modelo.Transacciones;

/**
 * @author RobertoPacho
 *
 */
public class TasaInteresDAO {
	@PersistenceContext(name = "Banca_MovilPersistenceUnit")
	private EntityManager em;

	public boolean insert(TasaInteres tasaInteres) throws Exception {
		em.persist(tasaInteres);
		return true;
	}

	public void update(TasaInteres tasaInteres) throws Exception {
		try {
			em.merge(tasaInteres);
		} catch (Exception e) {
			throw new Exception("Erro actualizar TasaInteres " + e.getMessage());
		}
	}
	
	public boolean actualizar(int id,double tasa) {
		// select SUM(cantidad) from transacciones where tipo='Deposito' and cuenta_id=1;
		Query q = em.createQuery(
				"UPDATE TasaInteres SET tasa=:tasa  WHERE id=:id");
		q.setParameter("tasa", tasa);
		q.setParameter("id", id);
		return true;
	}

	public TasaInteres read(int id) throws Exception {
		try {
			return em.find(TasaInteres.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer TasaInteres " + e.getMessage());
		}
	}

	public List<TasaInteres> findAll() throws Exception {
		String jpql = "Select t from TasaInteres t";
		Query q = em.createQuery(jpql, TasaInteres.class);
		return (List<TasaInteres>) q.getResultList();
	}
}
