/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import AccesoDatos.ServicioAlumnos;
import AccesoDatos.ServicioCarreras;
import AccesoDatos.ServicioCursos;
import AccesoDatos.ServicioProfesores;
import AccesoDatos.ServicioUsuarios;
import LogicaNegocio.Alumno;
import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import LogicaNegocio.Profesor;
import LogicaNegocio.Usuario;
import java.util.List;

/**
 *
 * @author Adriana Herrera
 */
public class Control {
    
    private ServicioCarreras sc;
    private ServicioCursos scc;
    private ServicioAlumnos sa;
    private ServicioProfesores sp;
    private ServicioUsuarios su;
    
    // Preguntar sobre instancia unica
    private static Control uniqueInstance;
    
    public static Control instance()
    {
        if (uniqueInstance == null)
        {
            uniqueInstance = new Control();
        }
        return uniqueInstance;
    }
    
    // Constructor
    public Control(){
        sc = new ServicioCarreras();
        scc = new ServicioCursos();
        sa = new ServicioAlumnos();
        sp = new ServicioProfesores();
        su = new ServicioUsuarios();
    }
    
    //////////////////// LISTAR DATOS
    public List<Carrera> listarCarreras() throws GlobalException, NoDataException{
        return sc.listarCarreras();
    }
    
    public List<Curso> listarCursos() throws GlobalException, NoDataException{
        return scc.listarCursos();
    }
    
    public List<Alumno> listarAlumnos() throws GlobalException, NoDataException{
        return sa.listarAlumnos();
    }
    
    public List<Profesor> listarProfesores() throws GlobalException, NoDataException{
        return sp.listarProfesores();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// CARRERAS /////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void opcionesCarreras(String op2, Carrera carrera) throws GlobalException, NoDataException{
        switch(op2){
            case "AGREGAR":
                sc.insertarCarreras(carrera);
            break;
            case "MODIFICAR":
                sc.modificarCarreras(carrera);
            break;
        }
    }
    
    public void opcionesCarreras(String op2, String codigo) throws GlobalException, NoDataException{
        switch(op2){
            case "BUSCAR":
                sc.buscarCarreras(codigo);
            break;
            case "ELIMINAR":
                sc.eliminarCarreras(codigo);
            break;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// CURSO ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void opcionesCursos(String op2, Curso curso) throws GlobalException, NoDataException{
        switch(op2){
            case "AGREGAR":
                scc.insertarCursos(curso);
            break;
            case "MODIFICAR":
                scc.modificarCursos(curso);
            break;
        }
    }
    
    public void opcionesCursos(String op2, String codigo) throws GlobalException, NoDataException{
        switch(op2){
            case "BUSCAR":
                scc.buscarCursos(codigo);
            break;
            case "ELIMINAR":
                scc.eliminarCursos(codigo);
            break;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// ALUMNOS //////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void opcionesAlumnos(String op2, Alumno alumno) throws GlobalException, NoDataException{
        switch(op2){
            case "AGREGAR":
                sa.insertarAlumnos(alumno);
            break;
            case "MODIFICAR":
                sa.modificarAlumnos(alumno);
            break;
        }
    }
    
    public void opcionesAlumnos(String op2, String codigo) throws GlobalException, NoDataException{
        switch(op2){
            case "BUSCAR":
                sa.buscarAlumnos(codigo);
            break;
            case "ELIMINAR":
                sa.eliminarAlumnos(codigo);
            break;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// PROFESORES ///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void opcionesProfesores(String op2, Profesor profesor) throws GlobalException, NoDataException{
        switch(op2){
            case "AGREGAR":
                sp.insertarProfesores(profesor);
            break;
            case "MODIFICAR":
                sp.modificarProfesores(profesor);
            break;
        }
    }
    
    public void opcionesProfesores(String op2, String codigo) throws GlobalException, NoDataException{
        switch(op2){
            case "BUSCAR":
                sp.buscarProfesores(codigo);
            break;
            case "ELIMINAR":
                sp.eliminarProfesores(codigo);
            break;
        }
    }
    
    public List<Usuario> obtenerUsuarios() throws GlobalException, NoDataException{
        return su.listarUsuarios();
    }
    
    public List<Curso> obtenerCursoPorCarrera(String carrera) throws NoDataException, GlobalException {
        List<Curso> cursos = scc.buscarCursosPorCarrera(carrera);
        return cursos;
    }
 
    ////////////////////////////// Busquedas de datos
    public List<Alumno> buscarAlumnos(String palabra) throws GlobalException, NoDataException{
        return sa.buscarAlumnos(palabra);
    }
    public List<Curso> buscarCursos(String palabra) throws GlobalException, NoDataException{
        return scc.buscarCursos(palabra);
    }
    public List<Carrera> buscarCarreras(String palabra) throws GlobalException, NoDataException{
        return sc.buscarCarreras(palabra);
    }
    public List<Profesor> buscarProfesores(String palabra) throws GlobalException, NoDataException{
        return sp.buscarProfesores(palabra);
    }
}
