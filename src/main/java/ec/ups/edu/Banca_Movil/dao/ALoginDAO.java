package ec.ups.edu.Banca_Movil.dao;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;


@Stateless
public class ALoginDAO {
@PersistenceContext
private EntityManager em;

public ALoginDAO() {
	
}
public boolean insert(Empleado empleado) throws SQLException{ 
	em.persist(empleado);
	return true;
}



}
