package ec.ups.edu.Banca_Movil.Beans;

import java.net.InetAddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
import ec.ups.edu.Banca_Movil.on.ALoginON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;

@Named
@RequestScoped
public class LoginBean {
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
		acceso = false;
		if (empleado.getContracenia().equals(contrasena)) {
			rol = empleado.getRol();
			switch (rol) {
			case "Administrador":
				acceso = true;
				login.setId(idLogin());
				login.setFecha(fecha);
				login.setAcceso(acceso);
				login.setIp(direccionip());
				login.setEmpleado(empleado);
				aloginOn.insertar(login);
				return "Administrador";
			case "Cajero":
				acceso = true;
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


}
