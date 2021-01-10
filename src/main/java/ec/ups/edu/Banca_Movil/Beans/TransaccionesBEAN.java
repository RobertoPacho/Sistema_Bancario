package ec.ups.edu.Banca_Movil.Beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.on.CuentaON;

@Named
@RequestScoped
public class TransaccionesBEAN {

	@Inject
	private CuentaON cuentaON;

	@Inject
	private Cuenta cuenta;

	private String cedula;
	private String nombres;
	private String numerocuenta;
	private String tipoCuenta;
	private double monto;

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
	
	public void addMessage() {
		if(check1) {
			String summary = check1 ? "Retiro  exitoso" : "Unchecked";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		}
		if(check2) {
			String summary = check2 ? "Deposito  exitoso" : "Unchecked";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		}
    }

	// <p:ajax update="msg" listener="#{transaccionesBEAN.addMessage()}"/>
	// <p:ajax update="msg" listener="#{transaccionesBEAN.addMessage()}"/>
	public String retiro() throws Exception {
		double suma = 0.0;
		List<Cuenta> listaC = cuentaON.listacuentasCliente2(cedula);
		if (check1) {
			if (listaC.size() > 0) {
				for (int i = 0; i < listaC.size(); i++) {
					if (listaC.get(i).getTipoCuenta().equals("cuenta de ahorros")) {
						if (listaC.get(i).getSaldo() > monto) {
							suma = listaC.get(i).getSaldo() - monto;
							
							cuenta.setId(listaC.get(i).getId());
							cuenta.setTipoCuenta(listaC.get(i).getTipoCuenta());
							cuenta.setNumerocuenta(listaC.get(i).getNumerocuenta());
							cuenta.setSaldo(suma);
							cuenta.setCedula(listaC.get(i).getCedula());
							cuenta.setNombres(listaC.get(i).getNombres());
							cuenta.setApellido(listaC.get(i).getApellido());
							cuenta.setDireccion(listaC.get(i).getDireccion());
							cuenta.setCorreo(listaC.get(i).getCorreo());
							cuenta.setTelefono(listaC.get(i).getTelefono());
							cuenta.setCelular(listaC.get(i).getCedula());
							cuenta.setContrasena(listaC.get(i).getContrasena());
							cuenta.setFechaapertura(listaC.get(i).getFechaapertura());

							cuenta.setEmpleado(listaC.get(i).getEmpleado());
							
							cuentaON.actualizar(cuenta);
							reset();
							System.out.println("Actualzado ");
						} else {
							System.out.println("Saldo insuficiente ");
						}
					}
				}
			}
		}
		if (check2) {
			if (listaC.size() > 0) {
				for (int i = 0; i < listaC.size(); i++) {
					if (listaC.get(i).getTipoCuenta().equals("cuenta de ahorros")) {
						suma = listaC.get(i).getSaldo() + monto;
						
						cuenta.setId(listaC.get(i).getId());
						cuenta.setTipoCuenta(listaC.get(i).getTipoCuenta());
						cuenta.setNumerocuenta(listaC.get(i).getNumerocuenta());
						cuenta.setSaldo(suma);
						cuenta.setCedula(listaC.get(i).getCedula());
						cuenta.setNombres(listaC.get(i).getNombres());
						cuenta.setApellido(listaC.get(i).getApellido());
						cuenta.setDireccion(listaC.get(i).getDireccion());
						cuenta.setCorreo(listaC.get(i).getCorreo());
						cuenta.setTelefono(listaC.get(i).getTelefono());
						cuenta.setCelular(listaC.get(i).getCedula());
						cuenta.setContrasena(listaC.get(i).getContrasena());
						cuenta.setFechaapertura(listaC.get(i).getFechaapertura());

						cuenta.setEmpleado(listaC.get(i).getEmpleado());
						
						cuentaON.actualizar(cuenta);
						reset();
						System.out.println("Actualzado ");
					}
				}
			}
		}
		return null;
	}

	public void reset() throws Exception {
		this.cedula = " ";
		nombres = " ";
		monto = 0.0;
		numerocuenta = "";
		check1 = false;
		check2 = false;
	}

	public String ver() throws Exception {
		return tipoCuenta;
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
