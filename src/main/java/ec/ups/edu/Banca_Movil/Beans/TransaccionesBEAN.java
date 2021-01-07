package ec.ups.edu.Banca_Movil.Beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.CuentaON;

@Named
@RequestScoped
public class TransaccionesBEAN {
	
	@Inject
	private CuentaON cuentaON;
	
	@Inject
	private Cuenta cuenta;
	
			private String cedula;
			private String nombre;
			private String numcuenta;
			private String tipo;
			private double monto;
			
			
			
			
			
			public CuentaON getCuentaON() {
				return cuentaON;
			}
			public void setCuentaON(CuentaON cuentaON) {
				this.cuentaON = cuentaON;
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getNumcuenta() {
				return numcuenta;
			}
			public void setNumcuenta(String numcuenta) {
				this.numcuenta = numcuenta;
			}
			public double getMonto() {
				return monto;
			}
			public void setMonto(double monto) {
				this.monto = monto;
			}
			public String getTipo() {
				return tipo;
			}
			public void setTipo(String tipo) {
				this.tipo = tipo;
			}
			public String getCedula() {
				return cedula;
			}
			public void setCedula(String cedula) {
				this.cedula = cedula;
			}
			
			public String doAgregar() throws Exception {
				if(cedula!="") {
				List<Cuenta> cuentas = cuentaON.listaCuentas();
				for(int i=0;i< cuentas.size();i++) {
					if(cuentas.get(i).getCedula().equals("0302295910")) {
						cuenta.setNombres(cuentas.get(i).getNombres());
						cuenta.setNumerocuenta(cuentas.get(i).getNumerocuenta());
					}
				}
				}
				return null;
			}
			
			
			
			
}
