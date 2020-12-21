/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.Banca_Movil.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author RobertoPacho
 */
@Entity
@Table(name = "Cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByUsuario", query = "SELECT c FROM Cliente c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Cliente.findByCedula", query = "SELECT c FROM Cliente c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cliente.findByNumconvencional", query = "SELECT c FROM Cliente c WHERE c.numconvencional = :numconvencional"),
    @NamedQuery(name = "Cliente.findByNumcelular", query = "SELECT c FROM Cliente c WHERE c.numcelular = :numcelular"),
    @NamedQuery(name = "Cliente.findByContrasena", query = "SELECT c FROM Cliente c WHERE c.contrasena = :contrasena")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "numconvencional")
    private String numconvencional;
    
    @Column(name = "numcelular")
    private String numcelular;
    
    @Column(name = "contrasena")
    private String contrasena;
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getNumconvencional() {
        return numconvencional;
    }

    public void setNumconvencional(String numconvencional) {
        this.numconvencional = numconvencional;
    }

    public String getNumcelular() {
        return numcelular;
    }

    public void setNumcelular(String numcelular) {
        this.numcelular = numcelular;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    @Override
    public String toString() {
        return "ec.edu.ups.banca_movil.modelo.Cliente[ id=" + id + " ]";
    }
    
}
