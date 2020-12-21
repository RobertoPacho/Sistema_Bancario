/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.Banca_Movil.on;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.Banca_Movil.dao.EmpleadoDAO;
import ec.ups.edu.Banca_Movil.modelo.Empleado;

/**
 *
 * @author narcisa
 */
@Stateless
public class EmpleadoON {

    @Inject
    private EmpleadoDAO empleadoDAO;

    /**
     * Este metodo permite la crear al empleado y al mismo tiempo validar la
     * cedula
     *
     * @param empleado
     * @return
     * @throws Exception
     */
    public boolean insertar(Empleado empleado) throws Exception {
        if (validarCedula(empleado.getCedula())) {
            empleadoDAO.insert(empleado);
        }
        return false;
    }


    /**
     * Metodo para mostrar el listado de clientes busca todos loc empleados
     * coincidentes
     *
     * @return
     * @throws Exception 
     */
    public List<Empleado> listaEmpleados() throws Exception {
            return empleadoDAO.findAll();
    }

    /**
     * Este metodo nos ayuda a buscar el empleado por cedula, para poder ser
     * consumido desde el controllerBean
     *
     * @param cedula
     * @return
     */
    public Empleado buscarEmpleadoCedula(String cedula) {
        try {
            return empleadoDAO.findByCedula(cedula);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo nos ayuda a buscar el empleado por id, para poder ser
     * consumido desde el controllerBean
     *
     * @param id
     * @return
     */
    public Empleado buscarEmpleado(String id) {
        try {
            return empleadoDAO.findByID(id);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Se recibe como parametro al objeto empleado para proceder a actualizar
     *
     * @param empleado
     */
    public void actualizarEmpleado(Empleado empleado) {
        try {
            empleadoDAO.update(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo es para validar la cedula si esta es valida nos retorna true
     * CAso contrario nos devuelve un false Recibe como parametro la cedula
     *
     * @param ced
     * @return
     */
    public boolean validarCedula(String ced) {
        boolean verdadera = false;
        int num = 0;
        int ope = 0;
        int suma = 0;
        for (int cont = 0; cont < ced.length(); cont++) {
            num = Integer.valueOf(ced.substring(cont, cont + 1));
            if (cont == ced.length() - 1) {
                break;
            }
            if (cont % 2 != 0 && cont > 0) {
                suma = suma + num;
            } else {
                ope = num * 2;
                if (ope > 9) {
                    ope = ope - 9;
                }
                suma = suma + ope;
            }
        }
        if (suma != 0) {
            suma = suma % 10;
            if (suma == 0) {
                if (suma == num) {
                    verdadera = true;
                }
            } else {
                ope = 10 - suma;
                if (ope == num) {
                    verdadera = true;
                }
            }
        } else {
            verdadera = false;
        }
        return verdadera;
    }

}
