/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditarCursos;

import LogicaNegocio.Curso;
import MVCCurso.CursoTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Adriana Herrera
 */
public class EditarModelo extends Observable {
    
    CursoTableModel curso_editar;
    HashMap<String,String> errores;
    String mensaje;
    
    public EditarModelo(){}
    
    public void init(){
        List<Curso> filas = new ArrayList<>();
        this.setCursos(filas);
        clearErrors();
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
        this.curso_editar = new CursoTableModel(columnas,curso);  
        setChanged();
        notifyObservers();        
    }
    
    public CursoTableModel getCursos() {
        return curso_editar;
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    } 
}
