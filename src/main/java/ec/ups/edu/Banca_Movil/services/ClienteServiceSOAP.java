package ec.ups.edu.Banca_Movil.services;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ClienteServiceSOAP {
	
	@WebMethod
	public String saludar(String nombre) {
		return "hola"+nombre;
	}
	
	@WebMethod
	public int suma(int a,int b) {
		return a+b;
	}

}
