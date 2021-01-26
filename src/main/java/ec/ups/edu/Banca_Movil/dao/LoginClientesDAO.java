package ec.ups.edu.Banca_Movil.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;
import ec.ups.edu.Banca_Movil.on.CuentaON;
;

@Stateless
public class LoginClientesDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Cuenta cuenta;
	
	@Inject
	private CuentaON cuentaON;
	
	@Inject
	private LoginClientes loginClientes;

	public LoginClientesDAO() {

	}
	
	public boolean insert(LoginClientes loginClients) throws SQLException {
		em.persist(loginClients);
		return true;
	}
	
	public void update(LoginClientes loginClients) throws Exception {
		try {
			em.merge(loginClients);
		} catch (Exception e) {
			throw new Exception("Erro actualizar LoginClientes " + e.getMessage());
		}
	}
	
	public Cuenta ultimoLogin() throws Exception {
		List<LoginClientes> listalogin=new ArrayList<LoginClientes>();
		String jpql="Select l from LoginClientes l WHERE acceso='true' ORDER BY id";
		Query q = em.createQuery(jpql,LoginClientes.class);
		listalogin= q.getResultList();
		for (int i=0;i<listalogin.size();i++) {
			cuenta=cuentaON.buscarid(listalogin.get(i).getCuenta().getId());
		}
		return cuenta;
	}
	
	public LoginClientes read(int id) throws Exception {
		return em.find(LoginClientes.class, id);
}
	
	public LoginClientes fastLogin(int cuenta_id) throws Exception {
		List<LoginClientes> listalogin=new ArrayList<LoginClientes>();
		String jpql="Select l from LoginClientes l WHERE cuenta_id=:cuenta_id ORDER BY id";
		Query q = em.createQuery(jpql,LoginClientes.class);
		q.setParameter("cuenta_id", cuenta_id);
		listalogin= q.getResultList();
		for (int i=0;i<listalogin.size();i++) {
			loginClientes=read(listalogin.get(i).getId());
		}
		return loginClientes;
	}
	
	public List<LoginClientes> buscarloginCliente(int cuenta_id) throws Exception {
		String jpql="Select l from LoginClientes l WHERE cuenta_id=:cuenta_id ORDER BY id";
		Query q = em.createQuery(jpql,LoginClientes.class);
		q.setParameter("cuenta_id", cuenta_id);
		return (List<LoginClientes>) q.getResultList();
	}
	
	public List<LoginClientes> findAll() throws Exception {
		String jpql="Select l from LoginClientes l ORDER BY id";
		Query q = em.createQuery(jpql,LoginClientes.class);
		return (List<LoginClientes>) q.getResultList();
	}
	
	
	public Long intentos(int cuenta_id) {
		// select SUM(cantidad) from transacciones where tipo='Deposito' and cuenta_id=1;
		Query q = em.createQuery(
				"SELECT COUNT(acceso) FROM LoginClientes  WHERE acceso='false' AND cuenta_id=:cuenta_id");
		q.setParameter("cuenta_id", cuenta_id);
		System.out.println("aver "+ ((Object)q.getSingleResult()).getClass().getSimpleName());
			//intentos= Long.valueOf((String) q.getSingleResult()).intValue();
		return (Long) q.getSingleResult();
	}

}
