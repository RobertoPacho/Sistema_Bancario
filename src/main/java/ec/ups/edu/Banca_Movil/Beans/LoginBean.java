package ec.ups.edu.Banca_Movil.Beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.on.ALoginON;

@Named
@RequestScoped
public class LoginBean {
	

	

	private Empleado empleado;

	@Inject
	private ALoginON on;

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
	
	public String logeo() {
		if(empleado.getCedula().equals("0103662805")&& empleado.getContracenia().equals("12345")) {
		
			return "empleado";
		
		}
		else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,"correo o clave incorrecta","correo o clave incorrecto");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
		}
}
/*public String logeo(String cedula, String contrasena) {
	if(empleado.getCedula().equals("0103662805")&& empleado.getContracenia().equals("12345")) {
	if(empleado.getRol().equals("Administrador")) {
		return "empleado";
	}
	if(empleado.getCedula().equals("0103662845")&& empleado.getContracenia().equals("12345")) {
		if(empleado.getRol().equals("Cajero")) {
			return "Cajero";
		}
	}
	}
	else{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,"correo o clave incorrecta","correo o clave incorrecto");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}
	return "empleado";
}*/
