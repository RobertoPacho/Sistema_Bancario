/**
 * 
 */
package ec.ups.edu.Banca_Movil.Beans;

import java.util.ArrayList;
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
	
	//Modificar check box
    private boolean tasa1;
	private boolean tasa2;
	private boolean tasa3;
	private boolean tasa4;
	private boolean tasa5;
	private boolean tasa6;
	//
	private String etasa1;
	
	
	public String getEtasa1() {
		return etasa1;
	}

	public void setEtasa1(String etasa1) {
		this.etasa1 = etasa1;
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
		if(tasa1) {
			String summary = tasa1 ? "Checked" : "Unchecked";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
			System.out.println(""+etasa1);
		}
    }
	
	public List<TasaInteres> listaInteresesBean() throws Exception{
    	return tasaInteresON.listaTasaInteres();
    }

	
	
	

}
