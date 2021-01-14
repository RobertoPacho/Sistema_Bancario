/**
 * 
 */
package ec.ups.edu.Banca_Movil.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.Banca_Movil.dao.TasaInteresDAO;
import ec.ups.edu.Banca_Movil.dao.TransaccionesDAO;
import ec.ups.edu.Banca_Movil.modelo.TasaInteres;
import ec.ups.edu.Banca_Movil.modelo.Transacciones;

/**
 * @author RobertoPacho
 *
 */
@Stateless
public class TasaInteresON {
	
	@Inject
	TasaInteresDAO tasaInteresDAO;
	
	
	public boolean agregar(TasaInteres tasaInteres) throws Exception {
		tasaInteresDAO.insert(tasaInteres);
		return true;
	}
	
	public void actualizar(TasaInteres tasaInteres) throws Exception {
		tasaInteresDAO.update(tasaInteres);
	}
	
	public boolean updateTasa(int id , double tasa) {
		tasaInteresDAO.actualizar(id, tasa);
		return true;
	}
	
	public TasaInteres buscarID(int id) throws Exception {
		return tasaInteresDAO.read(id);
	}
	
	public List<TasaInteres> listaTasaInteres() throws Exception {
		return tasaInteresDAO.findAll();
	}
	
	
}
