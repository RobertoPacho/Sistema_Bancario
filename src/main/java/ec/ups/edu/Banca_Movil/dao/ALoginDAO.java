package ec.ups.edu.Banca_Movil.dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
;

@Stateless
public class ALoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	Login login;
	
	public ALoginDAO() {

	}
	
	public boolean insert(Login login) throws SQLException {
		em.persist(login);
		return true;
	}
	
	public void update(Login login) throws Exception {
		try {
			em.merge(login);
		} catch (Exception e) {
			throw new Exception("Erro actualizar login " + e.getMessage());
		}
	}
	
	
	public List<Login> findAll() throws Exception {
		String jpql="Select l from Login l";
		Query q = em.createQuery(jpql,Login.class);
		return (List<Login>) q.getResultList();
	}

}
