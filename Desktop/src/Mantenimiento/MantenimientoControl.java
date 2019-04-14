/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import EditarCursos.EditarControl;
import LogicaNegocio.Alumno;
import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import LogicaNegocio.Profesor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class MantenimientoControl {
    
    Control principal;
    MantenimientoModelo modelo;
    MantenimientoVista vista;
    
    public MantenimientoControl(Control controlPrincipal, MantenimientoModelo modelo, MantenimientoVista vista) {
        modelo.init();
        this.principal = controlPrincipal;
        this.modelo = modelo;
        this.vista = vista;
        vista.setMantenimientoControl(this);
        vista.setMantenimientoModelo(modelo);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // METODOS CRUD - CURSOS
    public void agregarCurso(){       
        Principal.CURSO_VISTA.getCursoModelo().clearErrors();
        Principal.CURSO_VISTA.getCursoModelo().setModo(Principal.MODO_AGREGAR);
        Principal.CURSO_VISTA.getCursoModelo().setCurso(new Curso());
        Principal.CURSO_VISTA.setVisible(true);
        Principal.CURSO_VISTA.toFront();
    }
    
    public void editarCurso(int row){
        Principal.CURSO_VISTA.getCursoModelo().clearErrors();
        Curso seleccionada = modelo.getCursos().getRowAt(row); 
        Principal.CURSO_VISTA.getCursoModelo().setModo(Principal.MODO_EDITAR);
        Principal.CURSO_VISTA.getCursoModelo().setCurso(seleccionada);
        Principal.CURSO_VISTA.setVisible(true);
        Principal.CURSO_VISTA.toFront();
    }
    
    public void listarCursos() throws Exception {
        List<Curso> curso = principal.opcionesCursos("LISTAR");
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setCursos(curso);
    }
    
    public void eliminarCurso(int row) throws Exception {
        principal.opcionesCursos("ELIMINAR", modelo.getCursos().getRowAt(row).getId());
        this.listarCursos();
    }
   
    ////////////////////////////////////////////////////////////////////////////
    // METODOS CRUD - ALUMNOS
    public void agregarAlumno(){       
        Principal.ALUMNO_VISTA.getAlumnoModelo().clearErrors();
        Principal.ALUMNO_VISTA.getAlumnoModelo().setModo(Principal.MODO_AGREGAR);
        Principal.ALUMNO_VISTA.getAlumnoModelo().setAlumno(new Alumno());
        Principal.ALUMNO_VISTA.setVisible(true);
        Principal.ALUMNO_VISTA.toFront();
    }
    
    public void editarAlumno(int row){
        Principal.ALUMNO_VISTA.getAlumnoModelo().clearErrors();
        Alumno seleccionada = modelo.getAlumnos().getRowAt(row); 
        Principal.ALUMNO_VISTA.getAlumnoModelo().setModo(Principal.MODO_EDITAR);
        Principal.ALUMNO_VISTA.getAlumnoModelo().setAlumno(seleccionada);
        Principal.ALUMNO_VISTA.setVisible(true);
        Principal.ALUMNO_VISTA.toFront();
    }
    
    public void listarAlumnos() throws Exception {
        List<Alumno> alumno = principal.opcionesAlumnos("LISTAR");
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setAlumnos(alumno);
    }

    public void eliminarAlumno(int row) throws GlobalException, NoDataException, Exception{
        principal.opcionesAlumnos("ELIMINAR", modelo.getAlumnos().getRowAt(row).getId());
        this.listarAlumnos();
    }
   
    ////////////////////////////////////////////////////////////////////////////
    // METODOS CRUD - CARRERAS
    public void agregarCarrera(){       
        Principal.CARRERA_VISTA.getCarreraModelo().limpiarErrores();
        Principal.CARRERA_VISTA.getCarreraModelo().setModo(Principal.MODO_AGREGAR);
        Principal.CARRERA_VISTA.getCarreraModelo().setCarrera(new Carrera());
        Principal.CARRERA_VISTA.setVisible(true);
        Principal.CARRERA_VISTA.toFront();
    }
    
    public void editarCarrera(int row){
        Principal.CARRERA_VISTA.getCarreraModelo().limpiarErrores();
        Carrera seleccionada = modelo.getCarreras().getRowAt(row); 
        Principal.CARRERA_VISTA.getCarreraModelo().setModo(Principal.MODO_EDITAR);
        Principal.CARRERA_VISTA.getCarreraModelo().setCarrera(seleccionada);
        Principal.CARRERA_VISTA.setVisible(true);
        Principal.CARRERA_VISTA.toFront();
    }
   
    public void listarCarreras() throws Exception {
        List<Carrera> carrera = principal.opcionesCarreras("LISTAR");
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setCarreras(carrera);
    }
    
    public void eliminarCarrera(int row) throws Exception {
        principal.opcionesCarreras("ELIMINAR", modelo.getCarreras().getRowAt(row).getId());
        this.listarCarreras();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // METODOS CRUD - PROFESORES
    public void agregarProfesor() {       
        Principal.PROFESOR_VISTA.getProfesorModelo().clearErrors();
        Principal.PROFESOR_VISTA.getProfesorModelo().setModo(Principal.MODO_AGREGAR);
        Principal.PROFESOR_VISTA.getProfesorModelo().setProfesor(new Profesor());
        Principal.PROFESOR_VISTA.setVisible(true);
        Principal.PROFESOR_VISTA.toFront();
    }
    
    public void editarProfesor(int row) {
        Principal.PROFESOR_VISTA.getProfesorModelo().clearErrors();
        Profesor seleccionada = modelo.getProfesores().getRowAt(row); 
        Principal.PROFESOR_VISTA.getProfesorModelo().setModo(Principal.MODO_EDITAR);
        Principal.PROFESOR_VISTA.getProfesorModelo().setProfesor(seleccionada);
        Principal.PROFESOR_VISTA.setVisible(true);
        Principal.PROFESOR_VISTA.toFront();
    }
    
    public void listarProfesores() throws Exception {
        List<Profesor> profesor = principal.opcionesProfesores("LISTAR");
        Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setProfesores(profesor);
    }

    public void eliminarProfesor(int row) throws GlobalException, NoDataException, Exception {
        principal.opcionesProfesores("ELIMINAR", modelo.getProfesores().getRowAt(row).getId());
        this.listarProfesores();
    }
    
    public void listar() throws Exception{
       
        switch(modelo.getTipo()){
            case Principal.ALUMNO:
                this.listarAlumnos();
            break;
            case Principal.CARRERA:
                this.listarCarreras();
            break;
            case Principal.CURSO:
                this.listarCursos();
            break;
            case Principal.PROFESOR:
                this.listarProfesores();
            break;
        }
    }
    
    public void agregar(){
        
        switch(modelo.getTipo()){
            case Principal.ALUMNO:
                this.agregarAlumno();
            break;
            case Principal.CARRERA:
                this.agregarCarrera();
            break;
            case Principal.CURSO:
                this.agregarCurso();
            break;
            case Principal.PROFESOR:
                this.agregarProfesor();
            break;
        }
    }
    
    public void editar(int fila){
        
        switch(modelo.getTipo()){
            case Principal.ALUMNO:
                this.editarAlumno(fila);
            break;
            case Principal.CARRERA:
                this.editarCarrera(fila);
                EditarControl.filaCarrera = this.modelo.getCarreras().getRowAt(fila).getId();
            break;
            case Principal.CURSO:
                this.editarCurso(fila);
            break;
            case Principal.PROFESOR:
                this.editarProfesor(fila);
            break;
        }
    }
    
    public void eliminar(int fila) throws NoDataException, Exception{
        
        switch(modelo.getTipo()){
            case Principal.ALUMNO:
                this.eliminarAlumno(fila);
            break;
            case Principal.CARRERA:
                this.eliminarCarrera(fila);
            break;
            case Principal.CURSO:
                this.eliminarCurso(fila);
            break;
            case Principal.PROFESOR:
                this.eliminarProfesor(fila);
            break;
        }
    }
    
    public void buscar(){
        try {
            String palabra = vista.TFbuscar.getText();
            
            switch(modelo.getTipo()){
                case Principal.ALUMNO:
                    Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setAlumnos(principal.buscarAlumnos(palabra));
                    break;
                case Principal.CARRERA:
                    Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setCarreras(principal.buscarCarreras(palabra));
                    break;
                case Principal.CURSO:
                    Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setCursos(principal.buscarCursos(palabra));
                    break;
                case Principal.PROFESOR:
                    Principal.MATENIMIENTO_VISTA.getMantenimientoModelo().setProfesores(principal.buscarProfesores(palabra));
                    break;
            }
        } catch (GlobalException | NoDataException ex) {
            JOptionPane.showMessageDialog(this.vista, "No hay coincidencias", "",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
