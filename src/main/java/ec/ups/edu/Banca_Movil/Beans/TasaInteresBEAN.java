/**
 * 
 */
package ec.ups.edu.Banca_Movil.Beans;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.Banca_Movil.modelo.TasaInteres;
import ec.ups.edu.Banca_Movil.on.TasaInteresON;

/**
 * @author RobertoPacho
 *
 */
@Named
@RequestScoped
public class TasaInteresBEAN {

	@Inject
	TasaInteresON tasaInteresON;

	@Inject
	TasaInteres tasaInteres;

	// Modificar check box
	private boolean tasa1;
	private boolean tasa2;
	private boolean tasa3;
	private boolean tasa4;
	private boolean tasa5;
	private boolean tasa6;
	//
	private double etasa1;
	private double etasa2;
	private double etasa3;
	private double etasa4;
	private double etasa5;
	private double etasa6;
	//
	private String etiempo1 = "30-59";
	private String etiempo2 = "60-89";
	private String etiempo3 = "90-179";
	private String etiempo4 = "180-269";
	private String etiempo5 = "270-359";
	private String etiempo6 = "Mas de 360";

	public String getEtiempo1() {
		return etiempo1;
	}

	public void setEtiempo1(String etiempo1) {
		this.etiempo1 = etiempo1;
	}

	public String getEtiempo2() {
		return etiempo2;
	}

	public void setEtiempo2(String etiempo2) {
		this.etiempo2 = etiempo2;
	}

	public String getEtiempo3() {
		return etiempo3;
	}

	public void setEtiempo3(String etiempo3) {
		this.etiempo3 = etiempo3;
	}

	public String getEtiempo4() {
		return etiempo4;
	}

	public void setEtiempo4(String etiempo4) {
		this.etiempo4 = etiempo4;
	}

	public String getEtiempo5() {
		return etiempo5;
	}

	public void setEtiempo5(String etiempo5) {
		this.etiempo5 = etiempo5;
	}

	public String getEtiempo6() {
		return etiempo6;
	}

	public void setEtiempo6(String etiempo6) {
		this.etiempo6 = etiempo6;
	}

	public double getEtasa1() {
		return etasa1;
	}

	public void setEtasa1(double etasa1) {
		this.etasa1 = etasa1;
	}

	public double getEtasa2() {
		return etasa2;
	}

	public void setEtasa2(double etasa2) {
		this.etasa2 = etasa2;
	}

	public double getEtasa3() {
		return etasa3;
	}

	public void setEtasa3(double etasa3) {
		this.etasa3 = etasa3;
	}

	public double getEtasa4() {
		return etasa4;
	}

	public void setEtasa4(double etasa4) {
		this.etasa4 = etasa4;
	}

	public double getEtasa5() {
		return etasa5;
	}

	public void setEtasa5(double etasa5) {
		this.etasa5 = etasa5;
	}

	public double getEtasa6() {
		return etasa6;
	}

	public void setEtasa6(double etasa6) {
		this.etasa6 = etasa6;
	}

	public boolean isTasa1() {
		return tasa1;
	}

	public void setTasa1(boolean tasa1) {
		this.tasa1 = tasa1;
	}

	public boolean isTasa2() {
		return tasa2;
	}

	public void setTasa2(boolean tasa2) {
		this.tasa2 = tasa2;
	}

	public boolean isTasa3() {
		return tasa3;
	}

	public void setTasa3(boolean tasa3) {
		this.tasa3 = tasa3;
	}

	public boolean isTasa4() {
		return tasa4;
	}

	public void setTasa4(boolean tasa4) {
		this.tasa4 = tasa4;
	}

	public boolean isTasa5() {
		return tasa5;
	}

	public void setTasa5(boolean tasa5) {
		this.tasa5 = tasa5;
	}

	public boolean isTasa6() {
		return tasa6;
	}

	public void setTasa6(boolean tasa6) {
		this.tasa6 = tasa6;
	}

	public void addMessage() {
		System.out.println("modificadoooooooooooooooooooo");
	}

	public List<TasaInteres> listaInteresesBean() throws Exception {
		return tasaInteresON.listaTasaInteres();
	}

	public void prueba() throws Exception {
		if (tasa1) {
			tasaInteres.setId(1);
			tasaInteres.setTasa(etasa1);
			tasaInteres.setTiempo(etiempo1);
			tasaInteresON.actualizar(tasaInteres);
		}
		if (tasa2) {
			tasaInteres.setId(2);
			tasaInteres.setTasa(etasa2);
			tasaInteres.setTiempo(etiempo2);
			tasaInteresON.actualizar(tasaInteres);
		}
		if (tasa3) {
			tasaInteres.setId(3);
			tasaInteres.setTasa(etasa3);
			tasaInteres.setTiempo(etiempo3);
			tasaInteresON.actualizar(tasaInteres);

		}
		if (tasa4) {
			tasaInteres.setId(4);
			tasaInteres.setTasa(etasa4);
			tasaInteres.setTiempo(etiempo4);
			tasaInteresON.actualizar(tasaInteres);
		}
		if (tasa5) {
			tasaInteres.setId(5);
			tasaInteres.setTasa(etasa5);
			tasaInteres.setTiempo(etiempo5);
			tasaInteresON.actualizar(tasaInteres);
		}
		if (tasa6) {
			tasaInteres.setId(6);
			tasaInteres.setTasa(etasa6);
			tasaInteres.setTiempo(etiempo6);
			tasaInteresON.actualizar(tasaInteres);
		}
	}

}
