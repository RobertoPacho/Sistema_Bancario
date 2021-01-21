package ec.ups.edu.Banca_Movil.services;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@WebService
public class ClienteServiceSOAP {
	
	@Inject
	private EmpleadoON on;
	
	@WebMethod
	public String saludar(String nombre) {
		return "hola"+nombre;
	}
	
	@WebMethod
	public int suma(int a,int b) {
		return a+b;
	}
	
	@WebMethod
<<<<<<< HEAD
	public String guardar(Empleado empleado) throws Exception{
		
			on.insertar(empleado);
			return "ok";
		
=======
	public String guardar(Empleado empleado) throws Exception {
		on.insertar(empleado);
		return "ok";
>>>>>>> RobertoPacho
	}
	@WebMethod
	public List<Empleado> empleadoslista() throws Exception{
		return on.listaEmpleados();		
	}
	}

