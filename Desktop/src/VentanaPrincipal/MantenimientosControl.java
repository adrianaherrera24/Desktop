/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class MantenimientosControl {
    
    MantenimientosModelo modelo;
    MantenimientosVista vista;

    public MantenimientosControl(MantenimientosModelo modelo, MantenimientosVista vista) {
     //   modelo.init();
     //   this.modelo = modelo;
        this.vista = vista;
        vista.setMantenimientoControl(this);
    //    vista.setMantenimientoModelo(modelo);
    }
    
    public void Curso(){
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setTipo(Principal.CURSO);
        Principal.MATENIMIENTO_VISTA.setVisible(true);
        Principal.MATENIMIENTO_VISTA.toFront();
    }
    
    public void Carrera(){
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setTipo(Principal.CARRERA);
        Principal.MATENIMIENTO_VISTA.setVisible(true);
        Principal.MATENIMIENTO_VISTA.toFront();
    }
    
    public void Alumno(){
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setTipo(Principal.ALUMNO);
        Principal.MATENIMIENTO_VISTA.setVisible(true);
        Principal.MATENIMIENTO_VISTA.toFront();
    }
    
    public void Profesor(){
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setTipo(Principal.PROFESOR);
        Principal.MATENIMIENTO_VISTA.setVisible(true);
        Principal.MATENIMIENTO_VISTA.toFront();
    }
    
}
