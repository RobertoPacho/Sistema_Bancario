/**
 * 
 */
package ec.ups.edu.Banca_Movil.modelo;

import java.util.Date;

/**
 * @author RobertoPacho
 *
 */
public class ResumenCuenta {
	private String nCuenta;
	private String tipocuenta;
	private Date ultimaTransaccion;
	private double salto;
	
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
	
	@Override
	public String toString() {
		return "ResumenCuenta [nCuenta=" + nCuenta + ", tipocuenta=" + tipocuenta + ", ultimaTransaccion="
				+ ultimaTransaccion + ", salto=" + salto + "]";
	}

}
