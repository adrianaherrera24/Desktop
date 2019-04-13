/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCAlumno;

import LogicaNegocio.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriana Herrera
 */
public class AlumnoTableModel extends AbstractTableModel{

    List<Alumno> filas;
    int[] columnas;
    
    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int TELEFONO = 2;
    public static final int EMAIL = 3;
    public static final int FECHA = 4;
    public static final int CARRERA = 5;
    
    String[] nombreColumnas = new String[6]; 

    public AlumnoTableModel(List<Alumno> filas, int[] columnas) {
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
        Alumno alumno = filas.get(filaI);
        
        switch (columnas[columnaI]){
            case ID: return alumno.getId();           
            case NOMBRE: return alumno.getNombre();
            case TELEFONO: return alumno.getTelefono();
            case EMAIL: return alumno.getEmail();
            case FECHA: return alumno.getFechaNacimiento();
            case CARRERA: return alumno.getCarrera();
            default: return "";
        }
    }
    
    public Alumno getRowAt(int fila) {
        return filas.get(fila);
    }
    
    private void initNombreColumnas(){
        nombreColumnas[ID]= "ID";
        nombreColumnas[NOMBRE]= "NOMBRE";
        nombreColumnas[TELEFONO]= "TELEFONO";
        nombreColumnas[EMAIL]= "EMAIL";
        nombreColumnas[FECHA]= "FECHA NACIMIENTO";
        nombreColumnas[CARRERA]= "CARRERA";
    }
    
}
