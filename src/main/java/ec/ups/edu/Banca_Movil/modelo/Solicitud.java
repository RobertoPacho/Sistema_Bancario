/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.Banca_Movil.modelo;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author RobertoPacho
 */
@Entity
@Table(name = "Solicitud")
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "frecuencia")
    private String frecuencia;
    
    @Column(name = "plazo")
    private int plazo;
    
    @Column(name = "tasa_interes")
    private double tasaInteres;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    private Date fechaFin;
    
    @Column(name = "copiacedula")
    private String copiacedula;
    
    @Column(name = "planilla_serv_basicos")
    private String planillaServBasicos;
   

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, String frecuencia, int plazo, double tasaInteres, Date fechaInicio, Date fechaFin, String copiacedula, String planillaServBasicos) {
        this.id = id;
        this.frecuencia = frecuencia;
        this.plazo = plazo;
        this.tasaInteres = tasaInteres;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.copiacedula = copiacedula;
        this.planillaServBasicos = planillaServBasicos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCopiacedula() {
        return copiacedula;
    }

    public void setCopiacedula(String copiacedula) {
        this.copiacedula = copiacedula;
    }

    public String getPlanillaServBasicos() {
        return planillaServBasicos;
    }

    public void setPlanillaServBasicos(String planillaServBasicos) {
        this.planillaServBasicos = planillaServBasicos;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.banca_movil.modelo.Solicitud[ id=" + id + " ]";
    }
    
}
