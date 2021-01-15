package ec.ups.edu.Banca_Movil.services;
import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Path("empleado")
public class ClienteServiceREST {
	
	@Inject
	private EmpleadoON on;
	
	
	public String saludar(String nombre) {
		return "hola"+nombre;
	}
	
	
	public int suma(int a,int b) {
		return a+b;
	}
	
	@POST
	public String guardar(Empleado empleado) throws Exception {
		on.insertar(empleado);
		return "ok";
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Empleado> empleadoslista() throws Exception{
		return on.listaEmpleados();		
	}
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hola() {
		return "hola mundo";
	}*/
}

