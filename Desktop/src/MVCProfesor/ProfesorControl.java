/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCProfesor;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import LogicaNegocio.Profesor;
import java.util.List;
import Mantenimiento.MantenimientoModelo;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class ProfesorControl {
    
    Control controlPrincipal;
    ProfesorVista pvista;
    ProfesorModelo pmodelo;
    
    public ProfesorControl(ProfesorVista vista, ProfesorModelo modelo, Control control){
        modelo.init();
        this.controlPrincipal = control;
        this.pvista = vista;
        this.pmodelo = modelo;
        vista.setProfesorControl(this);
        vista.setProfesorModelo(modelo);
    }
    
    public void guardar(){
        MantenimientoModelo profesorModelo = Principal.MATENIMIENTO_VISTA.getMantenimientoModelo();
    
        Profesor nuevoProfesor = new Profesor();
        pmodelo.clearErrors();
        
        nuevoProfesor.setId(pvista.TFcedula.getText());
        if (pvista.TFcedula.getText().length()==0){
            pmodelo.getErrores().put("Id", "Id requerido");
        }
        nuevoProfesor.setNombre(pvista.TFnombre.getText());
        if (pvista.TFnombre.getText().length()==0){
            pmodelo.getErrores().put("Nombre", "Nombre requerido");
        }
        nuevoProfesor.setTelefono(pvista.TFtelefono.getText());
        if (pvista.TFtelefono.getText().length()==0){
            pmodelo.getErrores().put("Telefono", "Telefono requerido");
        }
        nuevoProfesor.setEmail(pvista.TFcorreo.getText());
        if (pvista.TFcorreo.getText().length()==0){
            pmodelo.getErrores().put("Correo", "Correo requerido");
        }
        nuevoProfesor.setRol("PROF");
        
        List<Profesor> profesor;
        
        if (pmodelo.getErrores().isEmpty()){
            try{
                switch(pmodelo.getModo()){
                    case Principal.MODO_AGREGAR:
                        controlPrincipal.opcionesProfesores("AGREGAR", nuevoProfesor);
                        pmodelo.setMensaje("PROFESOR AGREGADO");
                        pmodelo.setProfesor(new Profesor());                        
                        profesor = controlPrincipal.listarProfesores();
                        profesorModelo.setProfesores(profesor);
                        pvista.setVisible(false);
                        break;
                    case Principal.MODO_EDITAR:
                        controlPrincipal.opcionesProfesores("MODIFICAR", nuevoProfesor);
                        pmodelo.setMensaje("PROFESOR MODIFICADO");
                        pmodelo.setProfesor(nuevoProfesor);
                        profesor = controlPrincipal.listarProfesores(); 
                        profesorModelo.setProfesores(profesor);
                        pvista.setVisible(false);
                        break;
                }
            }
            catch(GlobalException | NoDataException e){
                pmodelo.getErrores().put("id", "PROFESOR YA EXISTE");
                pmodelo.setMensaje("PROFESOR YA EXISTE");
                pmodelo.setProfesor(nuevoProfesor);
            }
        }
        else{
            pmodelo.setMensaje("ESPACIOS INCOMPLETOS.");
            pmodelo.setProfesor(nuevoProfesor);
        }
    }
    
}
