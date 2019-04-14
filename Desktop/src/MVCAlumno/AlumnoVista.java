/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCAlumno;

import LogicaNegocio.Alumno;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriana Herrera
 */
public class AlumnoVista extends javax.swing.JFrame implements Observer {

    AlumnoControl control;
    AlumnoModelo modelo;
    
    public AlumnoControl getAlumnoControl() {
        return control;
    }
    public void setAlumnoControl(AlumnoControl control){
        this.control = control;
    }
    public void setAlumnoModelo(AlumnoModelo modelo){
        this.modelo = modelo;
         modelo.addObserver(this);
    }

    public AlumnoModelo getAlumnoModelo() {
        return modelo;
    }
    
    public AlumnoVista() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Alumno alumno = modelo.getAlumno();
        
        TFcedula.setText(alumno.getId());
        if (modelo.getErrores().get("Id")!= null){
             TFcedula.setToolTipText(modelo.getErrores().get("Id"));
         }
         else{
             TFcedula.setToolTipText("");
         }
        
        TFnombre.setText(alumno.getNombre());
        if (modelo.getErrores().get("Nombre")!= null){
             TFnombre.setToolTipText(modelo.getErrores().get("Nombre"));
         }
         else{
             TFnombre.setToolTipText("");
         }
        
        TFtelefono.setText(alumno.getTelefono());
        if (modelo.getErrores().get("Telefono")!= null){
             TFtelefono.setToolTipText(modelo.getErrores().get("Telefono"));
         }
         else{
             TFtelefono.setToolTipText("");
         }
        
        TFcorreo.setText(alumno.getEmail());
        if (modelo.getErrores().get("Email")!= null){
             TFcorreo.setToolTipText(modelo.getErrores().get("Email"));
         }
         else{
             TFcorreo.setToolTipText("");
         }
        
        JTfecha.setText(alumno.getFechaNacimiento());
        if (modelo.getErrores().get("Fecha")!= null){
             JTfecha.setToolTipText(modelo.getErrores().get("Fecha"));
         }
         else{
             JTfecha.setToolTipText("");
         }
        
        CBcarrera.setSelectedItem(alumno.getCarrera());
        
        this.validate();
        if (!modelo.getMensaje().equals(""))
        {
            JOptionPane.showMessageDialog(this, modelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
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
        JLfecha = new javax.swing.JLabel();
        JTfecha = new javax.swing.JTextField();
        JLcarrera = new javax.swing.JLabel();
        CBcarrera = new javax.swing.JComboBox<>();

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

        JLfecha.setText("Fecha Nacimiento");

        JLcarrera.setText("Carrera");

        CBcarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EIF", "ADM", "RRI" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBcedula)
                        .addGap(18, 18, 18)
                        .addComponent(TFcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLfecha)
                        .addGap(18, 18, 18)
                        .addComponent(JTfecha))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBnombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFnombre)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LBcorreo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TFcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LBtelefono)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TFtelefono)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLcarrera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBguardar)
                .addGap(58, 58, 58))
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLfecha)
                    .addComponent(JTfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLcarrera)
                    .addComponent(CBcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(JBguardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        this.control.guardar();
    }//GEN-LAST:event_JBguardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBcarrera;
    private javax.swing.JButton JBguardar;
    private javax.swing.JLabel JLcarrera;
    private javax.swing.JLabel JLfecha;
    public javax.swing.JTextField JTfecha;
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
