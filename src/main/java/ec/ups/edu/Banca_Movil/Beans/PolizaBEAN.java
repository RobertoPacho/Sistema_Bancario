package ec.ups.edu.Banca_Movil.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;

@Named
@RequestScoped
public class PolizaBEAN {
	private int id;
    private double monto;
    private Date fechaInicio;
    private Date fechaFin;
    private Double interesGanado;
    private Cuenta cuenta;
    
    //datos
    private String frecuencia;
    private String tasa="%";
    private int plazo;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getTasa() {
		return tasa;
	}
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
    
	public List<String> tasaInteres() {
		List<String> tasa = new ArrayList<String>();
		tasa.add("30-59");
		tasa.add("60-89");
		tasa.add("90-179");
		tasa.add("180-269");
		tasa.add("270-359");
		tasa.add("Mas de 350");
		return tasa;
	}
	
	public List<String> tasai() {
		List<String> tasai = new ArrayList<String>();
		tasai.add("5,50%");
		tasai.add("5,75%");
		tasai.add("6,25%");
		tasai.add("7,00%");
		tasai.add("7,50%");
		tasai.add("8,50%");
		return tasai;
	}
	
	public String mostrarTasa() {
		System.out.println(plazo);
		if(plazo<=30) {
			tasa=tasai().get(0).toString();
		}
		return tasa;
	}
	
	
	public String listo() {
		System.out.println("hooooliiiiii");
		return null;
	}
	
}
