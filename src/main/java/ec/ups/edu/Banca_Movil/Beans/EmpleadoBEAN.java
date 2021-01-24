package ec.ups.edu.Banca_Movil.Beans;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.ALoginON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Named
@RequestScoped
public class EmpleadoBEAN {
	
	@Inject
	private EmpleadoON empleadoON;
	
	@Inject
	private Empleado empleado;
	
	@Inject
	private ALoginON aLoginON;

	
	private Integer id;
    private String cedula;   
    private String nombres;    
    private String apellido;    
    private String telefono;       
    private String direccion;     
    private String correo; 
    private String usuario;
    private String contracenia;
    private String rol;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContracenia() {
		return contracenia;
	}
	public void setContracenia(String contracenia) {
		this.contracenia = contracenia;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public List<String> roles(){
		List<String> rol=new ArrayList<String>();
		rol.add("Administrador");
		rol.add("Cajero");
		rol.add("Asistente de captaciones");
		return rol;
	}
	
	public List<Empleado> empleadoslista() throws Exception{
		return empleadoON.listaEmpleados();		
	}
	
	
    
    //ation controler
    public String doSaludar() throws Exception {
    	int idNext = (empleadoON.listaEmpleados().size())+1;
    	empleado.setId(idNext);
    	empleado.setCedula(cedula);
    	empleado.setNombres(nombres);
    	empleado.setApellido(apellido);
    	empleado.setTelefono(telefono);
    	empleado.setDireccion(direccion);
    	empleado.setCorreo(correo);
    	empleado.setUsuario(usuario);
    	empleado.setContracenia(contracenia);
    	empleado.setRol(rol);
    	empleadoON.insertar(empleado);
    	reset();
    	return null;
    	
    }
    
    public void reset() {
        cedula="";   
        nombres="";    
        apellido="";    
        telefono="";       
        direccion="";     
        correo=""; 
        usuario="";
    }
    
    public void login() throws Exception {
		empleado=aLoginON.fastLogin();
		System.out.println(empleado.toString());
	}
 
}
