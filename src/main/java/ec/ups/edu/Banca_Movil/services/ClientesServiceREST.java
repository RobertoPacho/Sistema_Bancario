package ec.ups.edu.Banca_Movil.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.CuentaON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Path("empleado")
public class ClientesServiceREST {
	
	@Inject
	private EmpleadoON on;
	@Inject
	private CuentaON con;

	
	public String saludar(String nombre) {
		return "hola"+nombre;
	}
	@GET
	@Path("suma")
	public int suma(@QueryParam("a")int a, @QueryParam("b")int b) {
		return a+b;
	}
	@GET
	@Path("multiplicacion/{a}/{b}")
	public int multi(@PathParam("a")int a, @PathParam("b")int b) {
		return a*b;
	}
	
	/**
	 * 
	 * GET  Consultar
	 * POST		Transacciones  / Crear recursos
	 * PUT		Transacciones de tipo actualizacion / actualizar recursos
	 * DELETE	Transacciones de tipo eliminacion o borrado / borrar un recurso
	 * 
	 * @param empleado
	 * @return
	 */
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	
	public Mensaje guardar(Empleado empleado) {
		Mensaje m= new Mensaje();
		try {
			on.insertar(empleado);
			m.setCode("ok");
			m.setMensaje("Registro guardado");
			return m;
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		m.setCode("ok");
		m.setMensaje(e.getMessage());
		return m;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Empleado> empleadoslista() throws Exception{
		return on.listaEmpleados();		
	}
	
}

