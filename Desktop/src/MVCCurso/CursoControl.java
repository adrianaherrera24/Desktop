/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCurso;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import java.util.List;
import Mantenimiento.MantenimientoModelo;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class CursoControl {
    
    Control controlPrincipal;
    CursoModelo modelo;
    CursoVista vista;

    public CursoControl(CursoVista vista, CursoModelo modelo, Control controlPrincipal) throws GlobalException, NoDataException {
        modelo.init(controlPrincipal.opcionesCarreras("LISTAR").toArray(new Carrera[0]));
        this.controlPrincipal = controlPrincipal;
        this.vista = vista;
        this.modelo = modelo;
        vista.setCursoControl(this);
        vista.setCursoModelo(modelo);
    }
    
    public void agregarCurso() {
        MantenimientoModelo mmodelo = Principal.MATENIMIENTO_VISTA.getMantenimientoModelo();
        
        Curso nuevoCurso = new Curso();
        modelo.clearErrors();
        
        nuevoCurso.setId(vista.TFcodigo.getText());
        if (vista.TFcodigo.getText().length() == 0){
            modelo.getErrores().put("Codigo", "Codigo requerido");
        }
        nuevoCurso.setNombre(vista.TFnombre.getText());
        if (vista.TFnombre.getText().length() == 0){
            modelo.getErrores().put("Nombre", "Nombre requerido");
        }
        nuevoCurso.setCreditos(Integer.parseInt(vista.TFcreditos.getText()));
        if (vista.TFcreditos.getText().length() == 0){
            modelo.getErrores().put("Creditos", "Creditos requerido");
        }
        nuevoCurso.setHorasSemanales(Integer.parseInt(vista.TFhoras.getText()));
        if (vista.TFhoras.getText().length() == 0){
            modelo.getErrores().put("Horas", "Horas requerido");
        }
        nuevoCurso.setCiclo(Integer.parseInt((String) vista.CBciclo.getSelectedItem()));
        nuevoCurso.setCarrera((String) vista.CBcarrera.getSelectedItem());
        nuevoCurso.setAnno(vista.TFanno.getText());
        
        List<Curso> curso;
        
        if(modelo.getErrores().isEmpty()){ //Si no hay errores ingresa al if
            try{
                switch(modelo.getModo()){
                    case Principal.MODO_AGREGAR:
                        controlPrincipal.opcionesCursos("AGREGAR", nuevoCurso);
                        modelo.setMensaje("CURSO AGREGADO");
                        modelo.setCurso(new Curso());                        
                        curso = controlPrincipal.opcionesCursos("LISTAR");
                        mmodelo.setCursos(curso); // Se ingresa en el array en el modelo
                        vista.setVisible(false);
                        break;
                    case Principal.MODO_EDITAR:
                        controlPrincipal.opcionesCursos("MODIFICAR", nuevoCurso);
                        modelo.setMensaje("CURSO MODIFICADO");
                        modelo.setCurso(nuevoCurso);
                        curso = controlPrincipal.opcionesCursos("LISTAR");
                        mmodelo.setCursos(curso);
                        vista.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                modelo.getErrores().put("codigo", "CURSO YA EXISTE");
                modelo.setMensaje("CURSO YA EXISTE");
                modelo.setCurso(nuevoCurso);
                System.out.println(e);
            }
        }
        else{
            modelo.setMensaje("ESPACIOS INCOMPLETOS.");
            modelo.setCurso(nuevoCurso);
        }
    }
    
}
