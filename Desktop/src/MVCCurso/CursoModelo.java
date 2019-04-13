/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCurso;

import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Adriana Herrera
 */
public class CursoModelo extends Observable{
    
    Curso curso;
    ComboBoxModel<Carrera> carreras;
    int modo;
    HashMap<String,String> errores;
    String mensaje;
    
    public void init(Carrera[] carreras){
        setTCarreras(carreras);
        setCurso(new Curso());
        clearErrors();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        setChanged();
        notifyObservers(); 
    }
    
    public ComboBoxModel<Carrera> getTCarreras() {
        return carreras;
    }

    public void setTCarreras(Carrera[] carreras) {
        this.carreras = new DefaultComboBoxModel(carreras);
        setChanged();
        notifyObservers();        
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    } 
    
}
