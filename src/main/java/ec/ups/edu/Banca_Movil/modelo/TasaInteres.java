/**
 * 
 */
package ec.ups.edu.Banca_Movil.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RobertoPacho
 *
 */
@Entity
@Table(name = "TasaInteres")
public class TasaInteres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	private int id;
	
	@Column(name = "tiempo")
	private String tiempo;
	
	@Column(name = "tasa")
	private double tasa;
	
	
	/**
	 * @param id
	 * @param tiempo
	 * @param tasa
	 */
	public TasaInteres(int id, String tiempo, double tasa) {
		super();
		this.id = id;
		this.tiempo = tiempo;
		this.tasa = tasa;
	}
	
	/**
	 * 
	 */
	public TasaInteres() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	
	
	

}
