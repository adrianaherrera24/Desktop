/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCProfesor;

import LogicaNegocio.Profesor;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriana Herrera
 */
public class ProfesorVista extends javax.swing.JFrame implements Observer {

    ProfesorControl pcontrol;
    ProfesorModelo pmodelo;
    
    public ProfesorControl getPorfesorControl() {
        return pcontrol;
    }
    public void setProfesorControl(ProfesorControl control){
        this.pcontrol = control;
    }
    public void setProfesorModelo(ProfesorModelo modelo){
        this.pmodelo = modelo;
         modelo.addObserver(this);
    }

    public ProfesorModelo getProfesorModelo() {
        return pmodelo;
    }
    
    public ProfesorVista() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Profesor profesor = pmodelo.getProfesor();
        
        TFcedula.setText(profesor.getId());
        if (pmodelo.getErrores().get("Id")!= null){
             TFcedula.setToolTipText(pmodelo.getErrores().get("Id"));
         }
         else{
             TFcedula.setToolTipText("");
         }
        
        TFnombre.setText(profesor.getNombre());
        if (pmodelo.getErrores().get("Nombre")!= null){
             TFnombre.setToolTipText(pmodelo.getErrores().get("Nombre"));
         }
         else{
             TFnombre.setToolTipText("");
         }
        
        TFtelefono.setText(profesor.getTelefono());
        if (pmodelo.getErrores().get("Telefono")!= null){
             TFtelefono.setToolTipText(pmodelo.getErrores().get("Telefono"));
         }
         else{
             TFtelefono.setToolTipText("");
         }
        
        TFcorreo.setText(profesor.getEmail());
        if (pmodelo.getErrores().get("Email")!= null){
             TFcorreo.setToolTipText(pmodelo.getErrores().get("Email"));
         }
         else{
             TFcorreo.setToolTipText("");
         }
        
        this.validate();
        if (!pmodelo.getMensaje().equals(""))
        {
            JOptionPane.showMessageDialog(this, pmodelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBcedula = new javax.swing.JLabel();
        TFcedula = new javax.swing.JTextField();
        LBnombre = new javax.swing.JLabel();
        TFnombre = new javax.swing.JTextField();
        LBtelefono = new javax.swing.JLabel();
        TFtelefono = new javax.swing.JTextField();
        LBcorreo = new javax.swing.JLabel();
        TFcorreo = new javax.swing.JTextField();
        JBguardar = new javax.swing.JButton();

        setTitle("Profesores");

        LBcedula.setText("Cedula");

        LBnombre.setText("Nombre");

        LBtelefono.setText("Telefono");

        LBcorreo.setText("E-mail");

        JBguardar.setText("Guardar");
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBnombre)
                        .addGap(18, 18, 18)
                        .addComponent(TFnombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBcedula)
                        .addGap(18, 18, 18)
                        .addComponent(TFcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBcorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBtelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(JBguardar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBcedula)
                    .addComponent(TFcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBcorreo)
                    .addComponent(TFcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBnombre)
                    .addComponent(TFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBtelefono)
                    .addComponent(TFtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(JBguardar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        this.pcontrol.guardar();
    }//GEN-LAST:event_JBguardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBguardar;
    private javax.swing.JLabel LBcedula;
    private javax.swing.JLabel LBcorreo;
    private javax.swing.JLabel LBnombre;
    private javax.swing.JLabel LBtelefono;
    public javax.swing.JTextField TFcedula;
    public javax.swing.JTextField TFcorreo;
    public javax.swing.JTextField TFnombre;
    public javax.swing.JTextField TFtelefono;
    // End of variables declaration//GEN-END:variables
}
