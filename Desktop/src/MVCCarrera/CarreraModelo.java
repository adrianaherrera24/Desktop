/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCarrera;

import LogicaNegocio.Carrera;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Adriana Herrera
 */
public class CarreraModelo extends Observable{
    
    Carrera carrera;
    int modo; // El modo define si se va a agregar (1) o editar(2)
    HashMap<String,String> errores;
    String mensaje;
    int fila;
    
    public CarreraModelo(){}
    
    public void init(){
        setCarrera(new Carrera());
        limpiarErrores();
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
    
    public void limpiarErrores(){
        setErrores(new HashMap<>());
        setMensaje("");
        
    }
    
    public void agregarObservador(Observer observador){ // cambia el estado del Modelo
      super.addObserver(observador);
      setChanged(); //cambia la bandera
      notifyObservers(); //envia un null
    }
    
}
