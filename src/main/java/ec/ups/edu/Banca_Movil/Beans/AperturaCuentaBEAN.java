package ec.ups.edu.Banca_Movil.Beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class AperturaCuentaBEAN {
	
	    private Integer id;
	    private String tipoCuenta;
	    private String numerocuenta;
	    private String cedula;   
	    private String nombres;    
	    private String apellido;   
	    private String direccion;  
	    private String telefono;  
	    private String celular;
	    private String contrasena;
	    private Date fechaapertura;
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTipoCuenta() {
			return tipoCuenta;
		}
		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		public String getNumerocuenta() {
			return numerocuenta;
		}
		public void setNumerocuenta(String numerocuenta) {
			this.numerocuenta = numerocuenta;
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
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		public Date getFechaapertura() {
			return fechaapertura;
		}
		public void setFechaapertura(Date fechaapertura) {
			this.fechaapertura = fechaapertura;
		}  
		
	    
		
}
