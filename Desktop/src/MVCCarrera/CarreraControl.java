/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCarrera;

import Control.Control;
import EditarCursos.EditarControl;
import LogicaNegocio.Carrera;
import java.util.List;
import Mantenimiento.MantenimientoModelo;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class CarreraControl {
    
    /// Clases a las que relaciona
    Control controlPrincipal;
    CarreraModelo modelo;
    CarreraVista vista;
    
    public CarreraControl(CarreraVista vista, CarreraModelo modelo, Control control){
        modelo.init();
        this.controlPrincipal = control;
        this.vista = vista;
        this.modelo = modelo;
        vista.setCarreraControl(this);
        vista.setCarreraModelo(modelo);
    }
    
    public void agregarCarrera(){
        
        MantenimientoModelo csModelo = Principal.MATENIMIENTO_VISTA.getMantenimientoModelo();
        
        Carrera nuevaCarrera = new Carrera();
        modelo.limpiarErrores();
        
        nuevaCarrera.setId(vista.TFcodigo.getText());
        if (vista.TFcodigo.getText().length() == 0){
            modelo.getErrores().put("Codigo", "Codigo requerido");
        }
        nuevaCarrera.setNombre(vista.TFnombre.getText());
        if (vista.TFnombre.getText().length() == 0){
            modelo.getErrores().put("Nombre", "Nombre requerido");
        }
        nuevaCarrera.setTitulo(vista.TFtitulo.getText());
        if (vista.TFtitulo.getText().length() == 0){
            modelo.getErrores().put("Titulo", "Titulo requerido");
        }
        
        List<Carrera> carrera;
        
        if(modelo.getErrores().isEmpty()){ //Si no hay errores ingresa al if
            try{
                switch(modelo.getModo()){
                    case Principal.MODO_AGREGAR:
                        controlPrincipal.opcionesCarreras("AGREGAR", nuevaCarrera);
                        modelo.setMensaje("CARRERA AGREGADA");
                        modelo.setCarrera(new Carrera());                        
                        carrera = controlPrincipal.opcionesCarreras("LISTAR");
                        csModelo.setCarreras(carrera); // Se ingresa en el array en el modelo
                        vista.setVisible(false);
                        break;
                    case Principal.MODO_EDITAR:
                        controlPrincipal.opcionesCarreras("MODIFICAR", nuevaCarrera);
                        modelo.setMensaje("CARRERA MODIFICADA");
                        modelo.setCarrera(nuevaCarrera);
                        carrera = controlPrincipal.opcionesCarreras("LISTAR");
                        csModelo.setCarreras(carrera);
                        vista.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                modelo.getErrores().put("codigo", "CARRERA YA EXISTE");
                modelo.setMensaje("CARRERA YA EXISTE");
                modelo.setCarrera(nuevaCarrera);
                System.out.println(e);
            }
        }
        else{
            modelo.setMensaje("ESPACIOS INCOMPLETOS.");
            modelo.setCarrera(nuevaCarrera);
        }
    }
    
    public void edicionCursos(){
        Principal.EDITAR_CURSO.setVisible(true);
        Principal.EDITAR_CURSO.toFront();
    }
    
}
