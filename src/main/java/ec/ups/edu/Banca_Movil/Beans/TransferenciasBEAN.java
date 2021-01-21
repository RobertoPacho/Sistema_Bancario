package ec.ups.edu.Banca_Movil.Beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Transacciones;
import ec.ups.edu.Banca_Movil.on.CuentaON;
import ec.ups.edu.Banca_Movil.on.TransaccionesON;

@Named
@RequestScoped
public class TransferenciasBEAN {

	@Inject
	private CuentaON cuentaON;

	@Inject
	private Cuenta cuenta;

	@Inject
	private TransaccionesON transaccionesON;

	@Inject
	private Transacciones transacciones;

	private int id;
	private String cedula;
	private String nombres;
	private String numerocuenta;
	private String tipoCuenta;
	private double monto;
	private double saldo;

	private boolean check1;
	private boolean check2;

	public CuentaON getCuentaON() {
		return cuentaON;
	}

	public void setCuentaON(CuentaON cuentaON) {
		this.cuentaON = cuentaON;
	}

	public String getNumcuenta() {
		return numerocuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numerocuenta = numcuenta;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public boolean isCheck1() {
		return check1;
	}

	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}

	public boolean isCheck2() {
		return check2;
	}

	public void setCheck2(boolean check2) {
		this.check2 = check2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void addMessage() {
		if (check1) {
			String summary = check1 ? "Retiro  exitoso" : "Unchecked";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		}
		if (check2) {
			String summary = check2 ? "Deposito  exitoso" : "Unchecked";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		}
	}

	// <p:ajax update="msg" listener="#{transaccionesBEAN.addMessage()}"/>
	// <p:ajax update="msg" listener="#{transaccionesBEAN.addMessage()}"/>
	public String retiro() throws Exception {
		Date objDate = new Date();
		double suma = 0.0;
		List<Cuenta> listaC = cuentaON.listacuentasCliente2(cedula);
		if (check1) {// RETIRO
			if (listaC.size() > 0) {
				for (int i = 0; i < listaC.size(); i++) {
					if (listaC.get(i).getTipoCuenta().equals("cuenta de ahorros")) {
						saldo = transaccionesON.depositos(listaC.get(i).getId()) - transaccionesON.retiros(listaC.get(i).getId());
						if (saldo > monto) {

							transacciones.setId(codigotransaccion());
							transacciones.setCantidad(Double.valueOf(monto));
							transacciones.setCuenta(cuentaON.buscarid(listaC.get(i).getId()));
							transacciones.setTipo("Retiro");
							transacciones.setFecha(objDate);
							transaccionesON.agregar(transacciones);

						} else {
							System.out.println("saldo = " + saldo + " Insuficiente");
						}

					}
				}
			}
		}
		if (check2) {// DEPOSITO
			if (listaC.size() > 0) {
				for (int i = 0; i < listaC.size(); i++) {
					if (listaC.get(i).getTipoCuenta().equals("cuenta de ahorros")) {
						transacciones.setId(codigotransaccion());
						transacciones.setCantidad(Double.valueOf(monto));
						transacciones.setCuenta(cuentaON.buscarid(listaC.get(i).getId()));
						transacciones.setTipo("Deposito");
						transacciones.setFecha(objDate);
						transaccionesON.agregar(transacciones);
						reset();
					}
				}
			}
		}
		return null;
	}

	public void reset() throws Exception {
		cedula = " ";
		nombres = " ";
		monto = 0.0;
		numerocuenta = "";
		check1 = false;
		check2 = false;
	}

	public int codigotransaccion() throws Exception {
		id = transaccionesON.listaTransacciones().size() + 1;
		return id;
	}

	public String cuentam() throws Exception {
		List<Cuenta> listaC = cuentaON.listacuentasCliente2(cedula);
		if (listaC.size() > 0) {
			for (int i = 0; i < listaC.size(); i++) {
				if (listaC.get(i).getTipoCuenta().equals("cuenta de ahorros"))
					numerocuenta = listaC.get(i).getNumerocuenta();
			}
		}
		return numerocuenta;
	}

	// 0107624637

	public String buscarcedula() throws Exception {
		cuenta = cuentaON.buscarCedula(cedula);
		nombres = cuenta.getNombres() + " " + cuenta.getApellido();
		return nombres;
	}

}
