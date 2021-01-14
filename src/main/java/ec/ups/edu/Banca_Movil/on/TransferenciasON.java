/**
 * 
 */
package ec.ups.edu.Banca_Movil.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.ups.edu.Banca_Movil.dao.TransaccionesDAO;
import ec.ups.edu.Banca_Movil.modelo.Transacciones;

/**
 * @author RobertoPacho
 *
 */
@Stateless
public class TransferenciasON {
	
	@Inject
	TransaccionesDAO transaccionesDAO;
	
	
	public boolean agregar(Transacciones transaciones) throws Exception {
		transaccionesDAO.insert(transaciones);
		return true;
	}
	
	public void actualizar(Transacciones transaciones) throws Exception {
		transaccionesDAO.update(transaciones);
	}
	
	public Transacciones buscarID(int id) throws Exception {
		return transaccionesDAO.read(id);
	}
	
	public List<Transacciones> listaTransacciones() throws Exception {
		return transaccionesDAO.findAll();
	}
	
	public Double depositos(int cuentaid) {
		return transaccionesDAO.sumaDepositos(cuentaid);
	}
	
	public Double retiros(int cuentaid) {
		return transaccionesDAO.sumaRetiros(cuentaid);
	}
	
}
