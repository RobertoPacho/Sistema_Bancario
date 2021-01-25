/**
 * 
 */
package ec.ups.edu.Banca_Movil.Beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;
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
	
	private String nCuenta;
	private String tipocuenta;
	private Date ultimaTransaccion;
	private int cuenta_id;
	private double salto;
	@Inject
	private LoginClientesON loginClientesON;
	@Inject
	private Cuenta cuenta;
	@Inject
	private CuentaON cuentaON;
	@Inject
	private TransaccionesON transaccionesON;
	
	private List<LoginClientes> listalogClientes;
	
	
	public String getnCuenta() {
		return nCuenta;
	}
	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}
	public String getTipocuenta() {
		return tipocuenta;
	}
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public Date getUltimaTransaccion() {
		return ultimaTransaccion;
	}
	public void setUltimaTransaccion(Date ultimaTransaccion) {
		this.ultimaTransaccion = ultimaTransaccion;
	}
	public double getSalto() {
		return salto;
	}
	public void setSalto(double salto) {
		this.salto = salto;
	}	
	
	public String nCuentaM() throws Exception {
		cuenta=cuentaON.buscarid(cuenta_id);
		nCuenta=cuenta.getNumerocuenta();
		return nCuenta;
	}
	public String tipoCuentaM() throws Exception {
		cuenta=cuentaON.buscarid(cuenta_id);
		tipocuenta=cuenta.getTipoCuenta();
		return tipocuenta;
	}
	
	public Date fechaUltinaT() throws Exception {
		cuenta=cuentaON.buscarid(cuenta_id);
		ultimaTransaccion=transaccionesON.fastTransaccion(cuenta.getId()).getFecha();
		return ultimaTransaccion;
	}
	
	public double saldoM() throws Exception {
		cuenta=cuentaON.buscarid(cuenta_id);
		salto=transaccionesON.depositos(cuenta.getId()) - transaccionesON.retiros(cuenta.getId());
		return salto;
	}
	
	public void mostrarDetalle() throws Exception {
		listalogClientes=loginClientesON.listalogin();
		for(int i=0;i<listalogClientes.size();i++) {
			if(listalogClientes.get(i).getAcceso()) {
				cuenta_id=listalogClientes.get(i).getCuenta().getId();
			}
		}
		
		nCuenta=nCuentaM();
		tipocuenta=tipoCuentaM();
		ultimaTransaccion=fechaUltinaT();
		salto=saldoM();
		System.out.println("datos "+ nCuenta+" tipo cuenta: "+tipocuenta+" ultimaTransaccion: "+ultimaTransaccion+" saldo: "+salto);
	}

}
