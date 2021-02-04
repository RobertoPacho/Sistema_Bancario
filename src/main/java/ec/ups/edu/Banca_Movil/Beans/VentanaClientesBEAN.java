/**
 * 
 */
package ec.ups.edu.Banca_Movil.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;
import ec.ups.edu.Banca_Movil.modelo.ResumenCuenta;
import ec.ups.edu.Banca_Movil.on.CuentaON;
import ec.ups.edu.Banca_Movil.on.LoginClientesON;
import ec.ups.edu.Banca_Movil.on.TransaccionesON;

/**
 * @author RobertoPacho
 *
 */

@Named
@RequestScoped
public class VentanaClientesBEAN {
	@Inject
	private LoginClientesON loginClientesON;
	@Inject
	private Cuenta cuenta;
	@Inject
	private ResumenCuenta resumenCuenta;
	@Inject
	private TransaccionesON transaccionesON;
	
	private List<ResumenCuenta> datos;
	private Date date3;
	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public List<ResumenCuenta> mostrarDetalle() throws Exception {
		cuenta=loginClientesON.fastLogin();
		datos=new ArrayList<ResumenCuenta>();
		
		resumenCuenta.setnCuenta(cuenta.getNumerocuenta());
		resumenCuenta.setTipocuenta(cuenta.getTipoCuenta());
		resumenCuenta.setUltimaTransaccion(transaccionesON.fastTransaccion(cuenta.getId()).getFecha());
		resumenCuenta.setSalto(transaccionesON.depositos(cuenta.getId()) - transaccionesON.retiros(cuenta.getId()));
		datos.add(resumenCuenta);
		return datos;
	}
	
	public List<LoginClientes> listaClientes() throws Exception{
		cuenta=loginClientesON.fastLogin();
		return loginClientesON.listaLogeoCuenta(cuenta.getId());
	}
	
}
