/**
 * 
 */
package ec.ups.edu.Banca_Movil.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;
import ec.ups.edu.Banca_Movil.modelo.Transacciones;

/**
 * @author RobertoPacho
 *
 */
public class TransaccionesDAO {
	
	@Inject
	private Transacciones transacciones;
	@PersistenceContext(name = "Banca_MovilPersistenceUnit")
	private EntityManager em;

	public boolean insert(Transacciones transacciones) throws Exception {
		em.persist(transacciones);
		return true;
	}

	public void update(Transacciones transacciones) throws Exception {
		try {
			em.merge(transacciones);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Transaciones " + e.getMessage());
		}
	}

	public double sumaDepositos(int cuenta_id) {
		// select SUM(cantidad) from transacciones where tipo='Deposito' and cuenta_id=1;
		Query q = em.createQuery(
				"SELECT SUM(cantidad) FROM Transacciones  WHERE tipo='Deposito' AND cuenta_id=:cuenta_id");
		q.setParameter("cuenta_id", cuenta_id);
		return (Double) q.getSingleResult();
	}
	
	public double sumaRetiros(int cuenta_id) {
		// select SUM(cantidad) from transacciones where tipo='Deposito' and cuenta_id=1;do
		double saldo=0;
		Query q = em.createQuery(
				"SELECT SUM(cantidad) FROM Transacciones  WHERE tipo='Retiro' AND cuenta_id=:cuenta_id");
		q.setParameter("cuenta_id", cuenta_id);
		
		if(q.getSingleResult()!=null) {
			saldo=(Double) q.getSingleResult();
		}
		return saldo;
	}
	public Transacciones ultimaTransaccion(int cuenta_id) throws Exception {
		List<Transacciones> listalogin=new ArrayList<Transacciones>();
		String jpql="Select l from Transacciones l WHERE cuenta_id=:cuenta_id ORDER BY id";
		Query q = em.createQuery(jpql,Transacciones.class);
		q.setParameter("cuenta_id", cuenta_id);
		listalogin= q.getResultList();
		for (int i=0;i<listalogin.size();i++) {
			transacciones=read(listalogin.get(i).getId());
		}
		return transacciones;
	}

	public Transacciones read(int id) throws Exception {
		try {
			return em.find(Transacciones.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Transacciones " + e.getMessage());
		}
	}

	public List<Transacciones> findAll() throws Exception {
		String jpql = "Select t from Transacciones t";
		Query q = em.createQuery(jpql, Transacciones.class);
		return (List<Transacciones>) q.getResultList();
	}
}
