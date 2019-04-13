/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCProfesor;

import LogicaNegocio.Profesor;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Adriana Herrera
 */
public class ProfesorModelo extends Observable {
    
    Profesor profesor;
    HashMap<String,String> errores;
    String mensaje;
    int modo;
    
    public void init(){
        this.setProfesor(new Profesor());
        this.clearErrors();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
        setChanged();
        notifyObservers(); 
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
