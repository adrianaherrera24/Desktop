/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCLogin;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import LogicaNegocio.Usuario;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class LoginControl {
    
    LoginVista vista;
    Control principal;
    List<Usuario> usuario = new ArrayList<>();
    String rol, estado;
    
    public LoginControl(LoginVista vista, Control principal){
        this.vista = vista;
        this.principal = principal;
        vista.setLoginControl(this);
    }
    
    public void comprobarUsuario(){
        String user = vista.TFusuario.getText();
        String password = vista.TFcontrasena.getText();
        
        try {
            usuario = principal.obtenerUsuarios();
            int tamano = principal.obtenerUsuarios().size();
            
            for(int i = 0; i < tamano; i++){
                if(user.equals(principal.obtenerUsuarios().get(i).getNombreusuario()) && password.equals(principal.obtenerUsuarios().get(i).getContrasena())) {
                    rol = principal.obtenerUsuarios().get(i).getRol();
                    estado = "encontrado";
                    JOptionPane.showMessageDialog(vista, "Ingresando..", "",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (GlobalException | NoDataException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(!"encontrado".equals(estado)){
            JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos.", "",JOptionPane.INFORMATION_MESSAGE);
            estado = "";
        }
        
        if(rol != null)switch (rol) {
            case "ALUM":
                JOptionPane.showMessageDialog(vista, "Eres ALUMNO no hay modulos disponibles!", "",JOptionPane.INFORMATION_MESSAGE);
                rol = "";
                estado = "";
                break;
            case "PROF":
                JOptionPane.showMessageDialog(vista, "Eres PROFESOR no hay modulos disponibles!", "",JOptionPane.INFORMATION_MESSAGE);
                rol = "";
                estado = "";
                break;
            case "ADMI":
                Principal.MANTENIMIENTOS_VISTA.setVisible(true);
                Principal.MANTENIMIENTOS_VISTA.toFront();
                rol = "";
                estado = "";
                break;
            case "MATR":
                JOptionPane.showMessageDialog(vista, "Eres MATRICULADOR no hay modulos disponibles!", "",JOptionPane.INFORMATION_MESSAGE);
                rol = "";
                estado = "";
                break;
            default:
                break;
        }
    }
}
