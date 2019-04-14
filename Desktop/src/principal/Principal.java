/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import MVCAlumno.AlumnoControl;
import MVCAlumno.AlumnoModelo;
import MVCAlumno.AlumnoVista;
import MVCCarrera.CarreraControl;
import MVCCarrera.CarreraModelo;
import MVCCarrera.CarreraVista;
import MVCCurso.CursoControl;
import MVCCurso.CursoModelo;
import MVCCurso.CursoVista;
import MVCLogin.LoginControl;
import MVCLogin.LoginVista;
import MVCProfesor.ProfesorControl;
import MVCProfesor.ProfesorModelo;
import MVCProfesor.ProfesorVista;
import javax.swing.UIManager;
import Mantenimiento.MantenimientoControl;
import Mantenimiento.MantenimientoModelo;
import VentanaPrincipal.MantenimientosVista;
import Mantenimiento.MantenimientoVista;
import VentanaPrincipal.MantenimientosControl;
import VentanaPrincipal.MantenimientosModelo;

/**
 *
 * @author Adriana Herrera
 */
public class Principal {

    public static void main(String[] args) throws GlobalException, NoDataException {
        
        // Da estilo a los componentes de la ventanas
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex){ 
            ex.printStackTrace();
        }
        
        // Creacion de estancia unica
        Control principal = Control.instance(); 
        
        /////////////////////////////////////////////////////////////////////////////////////////
        // MANTENIMIENTOS
        MantenimientoModelo mm = new MantenimientoModelo();
        MantenimientoVista vp = new MantenimientoVista();
        
        MantenimientoControl mcontrol = new MantenimientoControl(principal, mm, vp);
        
        /////////////////////////////////////////////////////////////////////////////////////////
        // CARRERAS
        CarreraModelo cmodelo = new CarreraModelo();
        CarreraVista cvista = new CarreraVista();
        
        CarreraControl ccontrol = new CarreraControl(cvista,cmodelo,principal);
        CARRERA_VISTA = cvista;
        
        /////////////////////////////////////////////////////////////////////////////////////////
        // CURSOS
        CursoModelo cumodelo = new CursoModelo();
        CursoVista cuvista = new CursoVista();
        
        CursoControl cccontrol = new CursoControl(cuvista,cumodelo,principal);
        CURSO_VISTA = cuvista;
      
        /////////////////////////////////////////////////////////////////////////////////////////
        // PROFESORES
        ProfesorModelo pmodelo = new ProfesorModelo();
        ProfesorVista pvista = new ProfesorVista();
        
        ProfesorControl pcontrol = new ProfesorControl(pvista,pmodelo,principal);
        PROFESOR_VISTA = pvista;
      
        /////////////////////////////////////////////////////////////////////////////////////////
        // ALUMNOS
        AlumnoModelo amodelo = new AlumnoModelo();
        AlumnoVista avista = new AlumnoVista();
        
        AlumnoControl acontrol = new AlumnoControl(avista,amodelo,principal);
        ALUMNO_VISTA = avista;
       
        /////////////////////////////////////////////////////////////////////////////////////////
        // VENTANA PRINCIPAL
        MantenimientosModelo modelo = new MantenimientosModelo();
        MantenimientosVista vista = new MantenimientosVista();
        
        MantenimientosControl control = new MantenimientosControl(modelo, vista);
        MATENIMIENTO_VISTA = vp;
        MANTENIMIENTOS_VISTA = vista;
        
        LoginVista vistal = new LoginVista();
        LoginControl controll = new LoginControl(vistal,principal);
        vistal.setVisible(true);
        
    }
    
    public static CarreraVista CARRERA_VISTA;
    public static CursoVista CURSO_VISTA;
    public static ProfesorVista PROFESOR_VISTA;
    public static AlumnoVista ALUMNO_VISTA;
    
    public static MantenimientoVista MATENIMIENTO_VISTA; 
    public static MantenimientosVista MANTENIMIENTOS_VISTA; 
    public static LoginVista LOGIN_VISTA; 
    
    public static  final int  MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;
    
    public static final int CARRERA = 1;
    public static final int CURSO = 2;
    public static final int PROFESOR = 3;
    public static final int ALUMNO = 4;
    
}
