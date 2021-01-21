package ec.ups.edu.Banca_Movil.Beans;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
import ec.ups.edu.Banca_Movil.on.ALoginON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Named
@RequestScoped
public class LoginBean {
	static private final Logger LOGGER = Logger.getLogger("mx.com.hash.checkip.CheckIP");

	@Inject
	private Empleado empleado;

	@Inject
	private EmpleadoON empleadoON;

	@Inject
	private ALoginON aloginOn;

	@Inject
	private Login login;

	private int id;
	private Date fecha;
	private boolean acceso;
	private String ip;

	private String usuario;
	private String contrasena;
	private String rol;

	private List<String> listaip;

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the acceso
	 */
	public boolean isAcceso() {
		return acceso;
	}

	/**
	 * @param acceso the acceso to set
	 */
	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	public int idLogin() throws Exception {
		return aloginOn.listalogin().size() + 1;
	}

	public String prueba() throws Exception {
		empleado = empleadoON.buscarUsuario(usuario);
		Date fecha = new Date();
		acceso=false;
		if (empleado.getContracenia().equals(contrasena)) {
			rol = empleado.getRol();
			switch (rol) {
			case "Administrador":
				acceso=true;
				login.setId(idLogin());
				login.setFecha(fecha);
				login.setAcceso(acceso);
				login.setIp(direccionip());
				login.setEmpleado(empleado);
				aloginOn.insertar(login);
				return "Administrador";
			case "Cajero":
				acceso=true;
				login.setId(idLogin());
				login.setFecha(fecha);
				login.setAcceso(acceso);
				login.setIp(direccionip());
				login.setEmpleado(empleado);
				aloginOn.insertar(login);
				return "cajero";
			case "Asistente de captaciones":
				break;
			}
		}
		return contrasena;
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
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "correo o clave incorrecta",
					"correo o clave incorrecto");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public String direccionip() throws SocketException {
		// InetAddress ip = InetAddress.getLocalHost();
		listaip = new ArrayList<String>();
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = (InetAddress) ee.nextElement();
				listaip.add(i.getHostName());
				System.out.println(i.getHostName());
			}
		}
		System.out.println("aqui estoy putitos =" + listaip.get(2).toString());
		return listaip.get(2).toString();
	}

}
