package ec.ups.edu.Banca_Movil.Beans;

import java.net.InetAddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.Empleado;
import ec.ups.edu.Banca_Movil.modelo.Login;
import ec.ups.edu.Banca_Movil.modelo.LoginClientes;
import ec.ups.edu.Banca_Movil.on.ALoginON;
import ec.ups.edu.Banca_Movil.on.CuentaON;
import ec.ups.edu.Banca_Movil.on.EmpleadoON;
import ec.ups.edu.Banca_Movil.on.LoginClientesON;

@Named
@RequestScoped
public class LoginClientesBean {
	@Inject
	private Cuenta cuenta;

	@Inject
	private CuentaON cuentaON;

	@Inject
	private LoginClientesON loginClientesON;

	@Inject
	private LoginClientes loginClients;

	private int id;
	private Date fecha;
	private boolean acceso;
	private String ip;

	private String cedula;
	private String contrasena;
	private int cuenta_id;

	private int intentosn;
	private int cont=0;

	private List<String> listaip;

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
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public int idLogin() throws Exception {
		return loginClientesON.listalogin().size() + 1;
	}

	public void confirm() {
		if (loginClientesON.nIntentos(cuenta_id) == 3) {
			addMessage("Advertencia", "La Cuenta a sido Bloqueada por su Seguridad");
		}
		if (loginClientesON.nIntentos(cuenta_id) < 3) {
			addMessage("Advertencia", "Credenciales Invalidas, Le queda " + (3-loginClientesON.nIntentos(cuenta_id))+ "/3 Intentos pemitidos");
		}

	}

	public void addMessage(String summary, String detail) {
		if(loginClientesON.nIntentos(cuenta_id) == 3) {
			//FacesMessage.SEVERITY_INFO
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String prueba() throws Exception {
		cuenta = cuentaON.buscarCedula(cedula);
		loginClients=loginClientesON.ultimoLogin(cuenta.getId());
		cuenta_id = cuenta.getId();

		Date fecha = new Date();
		acceso = false;

		if (loginClients.getIntentos() == 3) {
			confirm();
		}else {
			if (cuenta.getContrasena().equals(contrasena)) {
				acceso = true;
				loginClients.setId(idLogin());
				loginClients.setFecha(fecha);
				loginClients.setAcceso(acceso);
				loginClients.setIp(direccionip());
				loginClients.setIntentos(cont);
				loginClients.setCuenta(cuenta);
				loginClientesON.insertar(loginClients);
				return "ventanaCliente.xhtml";
			} else {
				loginClients.setId(idLogin());
				loginClients.setFecha(fecha);
				loginClients.setAcceso(acceso);
				loginClients.setIp(direccionip());
				loginClients.setIntentos(intentos()+1);
				loginClients.setCuenta(cuenta);
				loginClientesON.insertar(loginClients);
				confirm();
			}
		}
		return contrasena;
	}

	public int intentos() {
		intentosn=loginClientesON.nIntentos(cuenta_id).intValue();
		return intentosn;
	}
	
	public void pruebaContador() {
		
		cont=cont+1;
		System.out.println(cont);
	}

	public String direccionip() throws SocketException {
		listaip = new ArrayList<String>();
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration<InetAddress> ee = n.getInetAddresses();
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
