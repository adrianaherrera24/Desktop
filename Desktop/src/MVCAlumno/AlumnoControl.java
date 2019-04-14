/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCAlumno;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import LogicaNegocio.Alumno;
import java.util.List;
import Mantenimiento.MantenimientoModelo;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class AlumnoControl {
    
    Control controlPrincipal;
    AlumnoVista pvista;
    AlumnoModelo pmodelo;
    
    public AlumnoControl(AlumnoVista vista, AlumnoModelo modelo, Control control){
        modelo.init();
        this.controlPrincipal = control;
        this.pvista = vista;
        this.pmodelo = modelo;
        vista.setAlumnoControl(this);
        vista.setAlumnoModelo(modelo);
    }
    
    public void guardar(){
        MantenimientoModelo alumnosModelo = Principal.MATENIMIENTO_VISTA.getMantenimientoModelo();
    
        Alumno nuevoAlumno = new Alumno();
        pmodelo.clearErrors();
        
        nuevoAlumno.setId(pvista.TFcedula.getText());
        if (pvista.TFcedula.getText().length()==0){
            pmodelo.getErrores().put("Id", "Id requerido");
        }
        nuevoAlumno.setNombre(pvista.TFnombre.getText());
        if (pvista.TFnombre.getText().length()==0){
            pmodelo.getErrores().put("Nombre", "Nombre requerido");
        }
        nuevoAlumno.setTelefono(pvista.TFtelefono.getText());
        if (pvista.TFtelefono.getText().length()==0){
            pmodelo.getErrores().put("Telefono", "Telefono requerido");
        }
        nuevoAlumno.setEmail(pvista.TFcorreo.getText());
        if (pvista.TFcorreo.getText().length()==0){
            pmodelo.getErrores().put("Correo", "Correo requerido");
        }
        nuevoAlumno.setFechaNacimiento(pvista.JTfecha.getText());
        if (pvista.JTfecha.getText().length()==0){
            pmodelo.getErrores().put("Fecha", "Fecha requerido");
        }
        nuevoAlumno.setCarrera(String.valueOf(pvista.CBcarrera.getSelectedItem()));
        nuevoAlumno.setRol("ALUM");
        
        List<Alumno> alumno;
        
        if (pmodelo.getErrores().isEmpty()){
            try{
                switch(pmodelo.getModo()){
                    case Principal.MODO_AGREGAR:
                        controlPrincipal.opcionesAlumnos("AGREGAR", nuevoAlumno);
                        pmodelo.setMensaje("ALUMNO AGREGADO");
                        pmodelo.setAlumno(new Alumno());                        
                        alumno = controlPrincipal.listarAlumnos();
                        alumnosModelo.setAlumnos(alumno);
                        pvista.setVisible(false);
                        break;
                    case Principal.MODO_EDITAR:
                        controlPrincipal.opcionesAlumnos("MODIFICAR", nuevoAlumno);
                        pmodelo.setMensaje("ALUMNO MODIFICADO");
                        pmodelo.setAlumno(nuevoAlumno);
                        alumno = controlPrincipal.listarAlumnos(); 
                        alumnosModelo.setAlumnos(alumno);
                        pvista.setVisible(false);
                        break;
                }
            }
            catch(GlobalException | NoDataException e){
                pmodelo.getErrores().put("id", "ALUMNO YA EXISTE");
                pmodelo.setMensaje("ALUMNO YA EXISTE");
                pmodelo.setAlumno(nuevoAlumno);
            }
        }
        else{
            pmodelo.setMensaje("ESPACIOS INCOMPLETOS.");
            pmodelo.setAlumno(nuevoAlumno);
        }
    }
    
}
