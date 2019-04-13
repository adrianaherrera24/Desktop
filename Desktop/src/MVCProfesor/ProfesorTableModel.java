/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCProfesor;

import LogicaNegocio.Profesor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriana Herrera
 */
public class ProfesorTableModel extends AbstractTableModel{

    List<Profesor> filas;
    int[] columnas;
    
    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int TELEFONO = 2;
    public static final int EMAIL = 3;
    
    String[] nombreColumnas = new String[4]; 

    public ProfesorTableModel(List<Profesor> filas, int[] columnas) {
        this.filas = filas;
        this.columnas = columnas;
        initNombreColumnas();
    }
    
    
    public String getColumnName(int columna){
        return nombreColumnas[columnas[columna]];
    }
    
    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int filaI, int columnaI) {
        Profesor profesor = filas.get(filaI);
        
        switch (columnas[columnaI]){
            case ID: return profesor.getId();           
            case NOMBRE: return profesor.getNombre();
            case TELEFONO: return profesor.getTelefono();
            case EMAIL: return profesor.getEmail();
            default: return "";
        }
    }
    
    public Profesor getRowAt(int fila) {
        return filas.get(fila);
    }
    
    private void initNombreColumnas(){
        nombreColumnas[ID]= "ID";
        nombreColumnas[NOMBRE]= "NOMBRE";
        nombreColumnas[TELEFONO]= "TELEFONO";
        nombreColumnas[EMAIL]= "EMAIL";
    }
    
}
