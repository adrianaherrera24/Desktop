/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCarrera;

import LogicaNegocio.Carrera;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriana Herrera
 */
public class CarreraTableModel extends AbstractTableModel{

    List<Carrera> filas;
    int[] columnas;
    
    // Constructor
    public CarreraTableModel(int columnas[], List<Carrera> filas){
        this.columnas = columnas;
        this.filas = filas;
        nombresColumnas();
    }
    
    public String getColumnName(int columna){
        return colNombres[columnas[columna]];
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
    public Object getValueAt(int fila, int columna) {
        Carrera carrera = filas.get(fila);
        
        switch (columnas[columna]){
            case CODIGO: return carrera.getId();
            case NOMBRE: return carrera.getNombre();
            case TITULO: return carrera.getTitulo();
            default: return "";
        }
    }
    
    public Carrera getRowAt(int row) {
        return filas.get(row);
    }
    
    private void nombresColumnas(){
        colNombres[CODIGO] = "CÓDIGO";
        colNombres[NOMBRE] = "NOMBRE";
        colNombres[TITULO] = "TÍTULO";
    }
    
    // Para nombrar las columnas de la tabla
    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int TITULO = 2; 
    
    String[] colNombres = new String[3];  
}
