/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditarCursos;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import LogicaNegocio.Curso;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */

public class EditarControl {
    public static String filaCarrera;
    
    Control principal;
    EditarModelo modelo;
    EditarVista vista;
    
    public EditarControl(Control controlPrincipal, EditarModelo modelo, EditarVista vista) {
        modelo.init();
        this.principal = controlPrincipal;
        this.modelo = modelo;
        this.vista = vista;
        vista.setEditarControl(this);
        vista.setEditarModelo(modelo);
    }
    
    public void agregarCurso(){       
        Principal.CURSO_VISTA.getCursoModelo().clearErrors();
        Principal.CURSO_VISTA.getCursoModelo().setModo(Principal.MODO_AGREGAR);
        Principal.CURSO_VISTA.getCursoModelo().setCurso(new Curso());
        Principal.CURSO_VISTA.setVisible(true);
        Principal.CURSO_VISTA.toFront();
    }
    
    public void editarCurso(int row){
        Principal.CURSO_VISTA.getCursoModelo().clearErrors();
        Curso seleccionada = modelo.getCursos().getRowAt(row); 
        Principal.CURSO_VISTA.getCursoModelo().setModo(Principal.MODO_EDITAR);
        Principal.CURSO_VISTA.getCursoModelo().setCurso(seleccionada);
        Principal.CURSO_VISTA.setVisible(true);
        Principal.CURSO_VISTA.toFront();
    }
    
    public void listarCursos()  {
        try {
            List<Curso> curso = principal.obtenerCursoPorCarrera(filaCarrera); 
            Principal.EDITAR_CURSO.getModelo().setCursos(curso);
        } catch (NoDataException | GlobalException ex) {
            JOptionPane.showMessageDialog(this.vista, "No hay cursos asociados.", "",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void eliminarCurso(int row) throws Exception {
        principal.opcionesCursos("ELIMINAR", modelo.getCursos().getRowAt(row).getId());
        this.listarCursos();
    }
}
