package ec.ups.edu.Banca_Movil.on;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.Banca_Movil.dao.CuentaDAO;
import ec.ups.edu.Banca_Movil.modelo.Cuenta;

@Stateless
public class CuentaON {

	@Inject
	private CuentaDAO cuentaDAO;

	public boolean insertar(Cuenta cuenta) throws Exception {
		cuentaDAO.insert(cuenta);
		return true;
	}
	
	public Cuenta buscarCedula(String cedula) throws Exception{
		return cuentaDAO.buscarCedula(cedula);
	}

	public List<Cuenta> listaCuentas() throws Exception {
		return cuentaDAO.findAll();
	}

	public int numeroCuenta() {
		Random r = new Random(System.currentTimeMillis());
		int ncuenta=1000000000 - r.nextInt(2000000000);
		
		if (ncuenta < 0) {
			ncuenta=ncuenta*(-1);
		}
	    return ncuenta;
	}
	
	public String claveAleatoria() {
		// La variable palabra almacena el resultado final
		String palabra = "";
		// La variable caracteres es un número aleatorio entre 2 y 20 que define la
		// longitud de la palabra.
		int caracteres = (int) (Math.random() * 20) + 2;
		// Con un bucle for, que recorreremos las veces que tengamos almacenadas en la
		// variable caracteres, que será como mínimo 2, iremos concatenando los
		// caracteres aleatorios.
		for (int i = 0; i < caracteres; i++) {
			// Para generar caracteres aleatorios hay que recurrir al valor numérico de
			// estos
			// caracteres en el alfabeto Ascii. En este programa vamos a generar palabras
			// con
			// letras minúsculas, que se encuentran en el rango 97-122. El método floor
			// devuelve el máximo entero.
			int codigoAscii = (int) Math.floor(Math.random() * (122 - 97) + 97);
			// para pasar el código a carácter basta con hacer un cast a char
			palabra = palabra + (char) codigoAscii;
		}
		return palabra;
	}

}
