package ec.ups.edu.Banca_Movil.on;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.Banca_Movil.dao.ALoginDAO;
import ec.ups.edu.Banca_Movil.modelo.Empleado;

@Stateless
public class ALoginON {

@Inject
private ALoginDAO aldao;

public boolean crearLogin(Empleado empleado) {
	try {
		aldao.insert(empleado);
	}catch (SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
	return true;
	}

}
