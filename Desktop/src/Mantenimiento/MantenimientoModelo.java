/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import LogicaNegocio.Alumno;
import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import LogicaNegocio.Profesor;
import MVCAlumno.AlumnoTableModel;
import MVCCarrera.CarreraTableModel;
import MVCCurso.CursoTableModel;
import MVCProfesor.ProfesorTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Adriana Herrera
 */
public class MantenimientoModelo extends Observable {
    
    // TableModel de todas las clases
    CursoTableModel cursos;
    AlumnoTableModel alumnos;
    CarreraTableModel carreras;
    ProfesorTableModel profesores;
    
    // Para errores y manejo de mensajes
    HashMap<String,String> errores;
    String mensaje;
    
    // Variable
    int tipo;
    
    public MantenimientoModelo(){}
    
    public void init(){
        List<Curso> filasCurso = new ArrayList<>();
        List<Alumno> filasAlumno = new ArrayList<>();
        List<Carrera> filasCarrera = new ArrayList<>();
        List<Profesor> filasProfesor = new ArrayList<>();
        this.setCursos(filasCurso); // Envia los datos a editar o agregar
        this.setAlumnos(filasAlumno);
        this.setCarreras(filasCarrera);
        this.setProfesores(filasProfesor);
        this.getTipo();
        clearErrors(); //Limpia errores y pantalla
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // CURSOS
    public void setCursos(List<Curso> curso){
        int[] columnas = {
            CursoTableModel.CODIGO,
            CursoTableModel.NOMBRE,
            CursoTableModel.CREDITOS,
            CursoTableModel.HORAS,
            CursoTableModel.CARRERA,
            CursoTableModel.CICLO,
            CursoTableModel.ANNO
        };
        this.cursos = new CursoTableModel(columnas,curso);  
        setChanged();
        notifyObservers();        
    }
    
    public CursoTableModel getCursos() {
        return cursos;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ALUMNOS
    public void setAlumnos(List<Alumno> alumno) {
       int[] columnas = {
           AlumnoTableModel.ID,
           AlumnoTableModel.NOMBRE,
           AlumnoTableModel.TELEFONO,
           AlumnoTableModel.EMAIL,
           AlumnoTableModel.FECHA,
           AlumnoTableModel.CARRERA
       };
        this.alumnos = new AlumnoTableModel(alumno,columnas);  
        setChanged();
        notifyObservers();  
    }
    
    public AlumnoTableModel getAlumnos() {
        return alumnos;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // CARRERAS
    public void setCarreras(List<Carrera> carrera){
        int[] columnas = {
            CarreraTableModel.CODIGO,
            CarreraTableModel.NOMBRE,
            CarreraTableModel.TITULO
        };
        this.carreras = new CarreraTableModel(columnas,carrera);  
        setChanged();
        notifyObservers();        
    }
    
    public CarreraTableModel getCarreras() {
        return carreras;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // PROFESORES
    public void setProfesores(List<Profesor> profesor) {
       int[] columnas = {
           ProfesorTableModel.ID,
           ProfesorTableModel.NOMBRE,
           ProfesorTableModel.TELEFONO,
           ProfesorTableModel.EMAIL };
        this.profesores = new ProfesorTableModel(profesor,columnas);  
        setChanged();
        notifyObservers();  
    }
    
    public ProfesorTableModel getProfesores() {
        return profesores;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // Se mantienen siempre
     public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
        // Para que el modelo sepa acerca del cambio de tipo
        setChanged();
        notifyObservers(); 
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<>());
        setMensaje(""); 
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
