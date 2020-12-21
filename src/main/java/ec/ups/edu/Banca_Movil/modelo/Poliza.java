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
@Table(name = "poliza")
@NamedQueries({
    @NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p"),
    @NamedQuery(name = "Poliza.findById", query = "SELECT p FROM Poliza p WHERE p.id = :id"),
    @NamedQuery(name = "Poliza.findByMonto", query = "SELECT p FROM Poliza p WHERE p.monto = :monto"),
    @NamedQuery(name = "Poliza.findByFechaInicio", query = "SELECT p FROM Poliza p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Poliza.findByFechaFin", query = "SELECT p FROM Poliza p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Poliza.findByInteresGanado", query = "SELECT p FROM Poliza p WHERE p.interesGanado = :interesGanado")})
public class Poliza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interes_ganado")
    private Double interesGanado;
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Poliza() {
    }

    public Poliza(Integer id) {
        this.id = id;
    }

    public Poliza(Integer id, double monto, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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

    public Double getInteresGanado() {
        return interesGanado;
    }

    public void setInteresGanado(Double interesGanado) {
        this.interesGanado = interesGanado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
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
        if (!(object instanceof Poliza)) {
            return false;
        }
        Poliza other = (Poliza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.banca_movil.modelo.Poliza[ id=" + id + " ]";
    }
    
}
