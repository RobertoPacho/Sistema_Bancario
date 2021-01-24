/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.Banca_Movil.modelo;

import java.io.Serializable;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author RobertoPacho
 */
@Entity
@Table(name = "LoginClientes")
public class LoginClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "acceso")
    private boolean acceso;
    
    @Column(name = "ip")
    private String ip;
    
    @Column(name = "intentos")
    private int intentos;
    
    
    @ManyToOne
    private Cuenta cuenta;

    public LoginClientes() {
    }

    public LoginClientes(Integer id) {
        this.id = id;
    }

    public LoginClientes(Integer id, Date fecha, boolean acceso) {
        this.id = id;
        this.fecha = fecha;
        this.acceso = acceso;
       
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getAcceso() {
        return acceso;
    }

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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @return the intentos
	 */
	public int getIntentos() {
		return intentos;
	}

	/**
	 * @param intentos the intentos to set
	 */
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "LoginClientes [id=" + id + ", fecha=" + fecha + ", acceso=" + acceso + ", ip=" + ip + ", intentos="
				+ intentos + ", cuenta=" + cuenta + "]";
	}
 
}
