package ec.ups.edu.Banca_Movil.Beans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.CorreoON;
import ec.ups.edu.Banca_Movil.on.CuentaON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;




@Named
@RequestScoped
public class AperturaCuentaBEAN {
	
		@Inject
		private CuentaON cuentaON;
		
		@Inject
		private Cuenta cuenta;
		
		@Inject
		private CorreoON correoON;
		
		@Inject
		private EmpleadoON empleadoON;
		
		@Inject
		private Empleado empleado;
		
	    private Integer id;
	    private String tipoCuenta;
	    private int numerocuenta;
	    private double saldo;
	    private String cedula;   
	    private String nombres;    
	    private String apellido;   
	    private String direccion; 
	    private String correo;
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
		
		public CorreoON getCorreoON() {
			return correoON;
		}
		public void setCorreoON(CorreoON correoON) {
			this.correoON = correoON;
		}
		
		
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		public String getTipoCuenta() {
			return tipoCuenta;
		}
		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		
		public int getNumerocuenta() {
			return numerocuenta;
		}
		public void setNumerocuenta(int numerocuenta) {
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
		
		public CuentaON getCuentaON() {
			return cuentaON;
		}
		public void setCuentaON(CuentaON cuentaON) {
			this.cuentaON = cuentaON;
		}
		public Cuenta getCuenta() {
			return cuenta;
		}
		public void setCuenta(Cuenta cuenta) {
			this.cuenta = cuenta;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		
		public List<Cuenta> listaCuentas() throws Exception{
			return cuentaON.listaCuentas();
		}
	
		
		public List<String> tipos(){
			List<String> rol=new ArrayList<String>();
			rol.add("cuenta corriente");
			rol.add("cuenta de ahorros");
			return rol;
		}
		
		
		
		//ation controler
	    public String doAgregarCuenta() throws Exception {
	    	
	    	Date objDate = new Date();
	    	String clave=doClave();
	    	
	    	int idNext = cuentaON.listaCuentas().size()+1;
	    	cuenta.setId(idNext);
	    	cuenta.setTipoCuenta(tipoCuenta);
	    	cuenta.setNumerocuenta(String.valueOf(doAleatorio()));
	    	cuenta.setSaldo(saldo);
	    	cuenta.setCedula(cedula);
	    	cuenta.setNombres(nombres);
	    	cuenta.setApellido(apellido);
	    	cuenta.setDireccion(direccion);
	    	cuenta.setCorreo(correo);
	    	cuenta.setTelefono(telefono);
	    	cuenta.setCelular(celular);
	    	cuenta.setContrasena(clave);
	    	cuenta.setFechaapertura(objDate);	
	    	
	    	cuenta.setEmpleado(1);
	    	
	    	cuentaON.insertar(cuenta);
	    	
	    	System.out.println("guardado ojala"+ clave);
	    	correoON.enviarConGMail(correo, "COOPERATIVA E.S.E", "Bienvenido "+ nombres +" a formar parte de la COOPERATIVA E.S.E  Datos de cuenta USUARIO: "+cedula+" CONTRASEÑA:"+ clave);
	    	
	    	return null;
	    	
	    } 
	    
	    public String doClave() {
	    	return cuentaON.claveAleatoria();
	    }
	    
	    public int doAleatorio() {
	    	return cuentaON.numeroCuenta();
	    }
	    
	    
	    
}
