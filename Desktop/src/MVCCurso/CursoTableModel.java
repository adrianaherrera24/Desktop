/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCurso;

import LogicaNegocio.Curso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriana Herrera
 */
public class CursoTableModel extends AbstractTableModel{

    List<Curso> filas;
    int[] columnas;
    
    // Constructor
    public CursoTableModel(int columnas[], List<Curso> filas){
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
        Curso curso = filas.get(fila);
        
        switch (columnas[columna]){
            case CODIGO: return curso.getId();
            case NOMBRE: return curso.getNombre();
            case CREDITOS: return curso.getCreditos();
            case HORAS: return curso.getHorasSemanales();
            case CARRERA: return curso.getCarrera();
            case CICLO: return curso.getCiclo();
            case ANNO: return curso.getAnno();
            default: return "";
        }
    }
    
    public Curso getRowAt(int row) {
        return filas.get(row);
    }
    
    private void nombresColumnas(){
        colNombres[CODIGO] = "CODIGO";
        colNombres[NOMBRE] = "NOMBRE";
        colNombres[CREDITOS] = "CREDITOS";
        colNombres[HORAS] = "HORAS SEMANALES";
        colNombres[CARRERA] = "CARRERA";
        colNombres[CICLO] = "CICLO";
        colNombres[ANNO] = "AÑO";
        
    }
    
    // Para nombrar las columnas de la tabla
    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int CREDITOS = 2; 
    public static final int HORAS = 3;
    public static final int CARRERA = 4;
    public static final int CICLO = 5;
    public static final int ANNO = 6;
    
    String[] colNombres = new String[7];  
}
