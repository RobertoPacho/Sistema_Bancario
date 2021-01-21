package ec.ups.edu.Banca_Movil.Beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;
import ec.ups.edu.Banca_Movil.modelo.TasaInteres;
import ec.ups.edu.Banca_Movil.on.TasaInteresON;

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
    
    @Inject
    TasaInteresON tasaInteresON;
    
    @Inject
    TasaInteres tasaInteres;
   
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
	
    public List<TasaInteres> listaInteresesBean() throws Exception{
    	return tasaInteresON.listaTasaInteres();
    }
	
	
	
	public String listo() {
		System.out.println("hooooliiiiii");
		return null;
	}
	
}
