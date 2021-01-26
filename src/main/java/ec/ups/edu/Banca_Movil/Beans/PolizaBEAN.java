package ec.ups.edu.Banca_Movil.Beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	BigDecimal bd = null;

	// datos
	private String frecuencia = "";
	private double tasa;
	private int plazo;
	private double total;

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

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<TasaInteres> listaInteresesBean() throws Exception {
		return tasaInteresON.listaTasaInteres();
	}

	public Double tasa() throws Exception {
		if (plazo > 0) {
			switch (frecuencia) {
			case "Dias":
				if (plazo >= 30 & plazo <= 59) {
					tasaInteres = tasaInteresON.buscarID(1);
					tasa = tasaInteres.getTasa();
				}
				if (plazo >= 60 & plazo <= 89) {
					tasaInteres = tasaInteresON.buscarID(2);
					tasa = tasaInteres.getTasa();
				}
				if (plazo >= 90 & plazo <= 179) {
					tasaInteres = tasaInteresON.buscarID(3);
					tasa = tasaInteres.getTasa();
				}
				if (plazo >= 180 & plazo <= 269) {
					tasaInteres = tasaInteresON.buscarID(4);
					tasa = tasaInteres.getTasa();
				}
				if (plazo >= 270 & plazo <= 359) {
					tasaInteres = tasaInteresON.buscarID(5);
					tasa = tasaInteres.getTasa();
				}
				if (plazo >= 360) {
					tasaInteres = tasaInteresON.buscarID(6);
					tasa = tasaInteres.getTasa();
				}
				break;

			case "Meses":
				if (plazo == 1) {
					tasaInteres = tasaInteresON.buscarID(1);
					tasa = tasaInteres.getTasa();
				}
				if (plazo == 2) {
					tasaInteres = tasaInteresON.buscarID(2);
					tasa = tasaInteres.getTasa();
				}
				if (plazo == 3 | plazo == 5) {
					tasaInteres = tasaInteresON.buscarID(3);
					tasa = tasaInteres.getTasa();
				}
				if (plazo == 6 | plazo == 8) {
					tasaInteres = tasaInteresON.buscarID(4);
					tasa = tasaInteres.getTasa();
				}
				if (plazo == 9 | plazo == 11) {
					tasaInteres = tasaInteresON.buscarID(5);
					tasa = tasaInteres.getTasa();
				}
				if (plazo == 12) {
					tasaInteres = tasaInteresON.buscarID(6);
					tasa = tasaInteres.getTasa();
				}
				break;
			case "Años":
				if (plazo >= 1) {
					tasaInteres = tasaInteresON.buscarID(6);
					tasa = tasaInteres.getTasa();
				}
				break;
			default:
				break;
			}
		}

		return tasa;
	}

	public void simular() throws Exception {
		switch (frecuencia) {
		case "Dias":
			total = (monto * (tasa() / 100) * plazo) / 360;
			bd = new BigDecimal(total);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			interesGanado = Double.parseDouble(String.valueOf(bd));
			break;
		case "Meses":
			total = (monto * (tasa() / 100) * plazo) / 12;
			bd = new BigDecimal(total);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			interesGanado = Double.parseDouble(String.valueOf(bd));
			break;
		case "Años":
			total = (monto * (tasa() / 100) * plazo) / 1;
			bd = new BigDecimal(total);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			interesGanado = Double.parseDouble(String.valueOf(bd));
			break;

		default:
			break;
		}
	}

	public void solicitar() {
		System.out.println("wueiuehsdsdhj");
	}

}
