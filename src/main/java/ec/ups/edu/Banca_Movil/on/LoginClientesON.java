package ec.ups.edu.Banca_Movil.on;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.ups.edu.Banca_Movil.dao.LoginClientesDAO;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;

@Stateless
public class LoginClientesON {

	@Inject
	private LoginClientesDAO loginClientesDAO;

	public boolean insertar(LoginClientes loginClients) throws SQLException {
		return loginClientesDAO.insert(loginClients);
	}
	
	public LoginClientes ultimoLogin(int cuenta_id) throws Exception {
		return loginClientesDAO.fastLogin(cuenta_id);
	}
	
	public List<LoginClientes> listalogin() throws Exception {
		return loginClientesDAO.findAll();
	}

	public Long nIntentos(int cuenta_id) {
		return loginClientesDAO.intentos(cuenta_id);
	}

}
