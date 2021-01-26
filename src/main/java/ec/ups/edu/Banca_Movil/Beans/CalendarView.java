/**
 * 
 */
package ec.ups.edu.Banca_Movil.Beans;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;


/**
 * @author RobertoPacho
 *
 */

@SuppressWarnings("deprecation")
@ManagedBean
public class CalendarView {
private Date date3;
	
	public void onClick(Date date) {
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(dateFormat.format(date));
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	
}
