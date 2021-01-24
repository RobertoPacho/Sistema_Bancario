package ec.ups.edu.Banca_Movil.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;
;

@Stateless
public class ALoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Empleado empleado;
	
	@Inject
	private EmpleadoON empleadoON;
	
	private int entero;
	
	
	
	public int getEntero() {
		return entero;
	}

	public void setEntero(int entero) {
		this.entero = entero;
	}

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
	
	public Empleado ultimoLogin() throws Exception {
		List<Login> listalogin=new ArrayList<Login>();
		String jpql="Select l from Login l ORDER BY id";
		Query q = em.createQuery(jpql,Login.class);
		listalogin= q.getResultList();
		for (int i=0;i<listalogin.size();i++) {
			empleado=empleadoON.buscarid(listalogin.get(i).getEmpleado().getId());
		}
		return empleado;
	}
	
	public List<Login> findAll() throws Exception {
		String jpql="Select l from Login l";
		Query q = em.createQuery(jpql,Login.class);
		return (List<Login>) q.getResultList();
	}

}
