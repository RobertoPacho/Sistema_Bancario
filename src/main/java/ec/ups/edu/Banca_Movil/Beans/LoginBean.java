package ec.ups.edu.Banca_Movil.Beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.ALoginON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private Empleado empleado;

	@Inject
	private ALoginON on;

	@Inject
	private EmpleadoON empleadoON;

	private String cedula;
	private String contrasena;
	private String rol;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public LoginBean() {
		init();
	}

	public void init() {
		empleado = new Empleado();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado empleadob(String cedula, String rol) throws Exception {
		List<Empleado> listaemp = empleadoON.listaEmpleados();
		for (int i = 0; i < listaemp.size(); i++) {
			if (listaemp.get(i).getCedula() == cedula) {
				empleado.setCedula(listaemp.get(i).getCedula());
				empleado.setContracenia(listaemp.get(i).getContracenia());
				
				return empleado;
			}
		}
		return empleado;

	}

	public String logeo() throws Exception {

		if (empleado.getCedula().equals(empleado.getCedula())
				&& empleado.getContracenia().equals(empleado.getContracenia())) {
			
	
			return "empleado";
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "correo o clave incorrecta",
					"correo o clave incorrecto");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		
	}
	

}