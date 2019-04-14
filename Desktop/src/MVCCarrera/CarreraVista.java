/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCarrera;

import LogicaNegocio.Carrera;
import java.util.Observable;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class CarreraVista extends javax.swing.JFrame implements java.util.Observer{

    CarreraControl carreracontrol;
    CarreraModelo carreramodelo;
    
    public CarreraVista() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CarreraModelo getCarreraModelo() {
        return carreramodelo;
    }
    
    public void setCarreraControl(CarreraControl control){
        this.carreracontrol = control;
    }
    public void setCarreraModelo(CarreraModelo modelo){
        this.carreramodelo = modelo;
         modelo.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Carrera carrera = carreramodelo.getCarrera();
        
        // Para la opcion de editar
        TFcodigo.setText(carrera.getId());
        if (carreramodelo.getErrores().get("Codigo")!= null){
            TFcodigo.setToolTipText(carreramodelo.getErrores().get("Codigo"));
        }
        else{
            TFcodigo.setToolTipText("");
        }
        
        TFnombre.setText(carrera.getNombre());
        if (carreramodelo.getErrores().get("Nombre")!= null){
            TFnombre.setToolTipText(carreramodelo.getErrores().get("Nombre"));
        }
        else{
            TFnombre.setToolTipText("");
        }
        
        TFtitulo.setText(carrera.getTitulo());
        if (carreramodelo.getErrores().get("Titulo")!= null){
            TFtitulo.setToolTipText(carreramodelo.getErrores().get("Titulo"));
        }
        else{
            TFtitulo.setToolTipText("");
        }
        
        // para validar los errores.
        this.validate();
        if (!carreramodelo.getMensaje().equals(""))
        {
            JOptionPane.showMessageDialog(this, carreramodelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLcodigo = new javax.swing.JLabel();
        TFcodigo = new javax.swing.JTextField();
        JLnombre = new javax.swing.JLabel();
        TFnombre = new javax.swing.JTextField();
        JLtitulo = new javax.swing.JLabel();
        TFtitulo = new javax.swing.JTextField();
        JBguardar = new javax.swing.JButton();
        JBeditar = new javax.swing.JButton();

        setTitle("CARRERA");

        JLcodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JLcodigo.setText("Código");

        JLnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JLnombre.setText("Nombre");

        JLtitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JLtitulo.setText("Título");

        JBguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBguardar.setText("Guardar");
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JBeditar.setBackground(new java.awt.Color(102, 153, 255));
        JBeditar.setText("Editar Cursos");
        JBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBeditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBguardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLcodigo)
                            .addComponent(JLnombre)
                            .addComponent(JLtitulo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcodigo)
                    .addComponent(TFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(TFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLtitulo)
                    .addComponent(TFtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(JBeditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(JBguardar)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        this.carreracontrol.agregarCarrera();
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBeditarActionPerformed
        Principal.EDITAR_CURSO.setLocation(this.JBeditar.getLocationOnScreen());
        this.carreracontrol.edicionCursos();
    }//GEN-LAST:event_JBeditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBeditar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JLabel JLcodigo;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLtitulo;
    public javax.swing.JTextField TFcodigo;
    public javax.swing.JTextField TFnombre;
    public javax.swing.JTextField TFtitulo;
    // End of variables declaration//GEN-END:variables
}
