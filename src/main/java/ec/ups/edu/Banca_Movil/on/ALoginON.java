package ec.ups.edu.Banca_Movil.on;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.Banca_Movil.dao.ALoginDAO;
import ec.ups.edu.Banca_Movil.modelo.Login;

@Stateless
public class ALoginON {

@Inject
private ALoginDAO  aLoginDAO;



public boolean insertar(Login login) throws SQLException {
	return aLoginDAO.insert(login);
}

public List<Login> listalogin() throws Exception{
	return aLoginDAO.findAll();
}

public List<Login> listaLogin() throws Exception {
	return aLoginDAO.findAll();
}

}
