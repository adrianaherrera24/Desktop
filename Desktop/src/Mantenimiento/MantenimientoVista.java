/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class MantenimientoVista extends javax.swing.JFrame implements Observer {

    MantenimientoControl control;
    MantenimientoModelo modelo;
    
    public MantenimientoVista() {
        initComponents();
    }
    
    public void setMantenimientoControl(MantenimientoControl control){
        this.control = control;
    }
    public void setMantenimientoModelo(MantenimientoModelo modelo){
        this.modelo = modelo;
         modelo.addObserver(this);
    }

    public MantenimientoModelo getMantenimientoModelo() {
        return modelo;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        switch(modelo.getTipo()){
            case Principal.ALUMNO:
                this.setTitle("ALUMNOS");
                Tabla.setModel(modelo.getAlumnos());
            break;
            case Principal.CARRERA:
                this.setTitle("CARRERAS");
                Tabla.setModel(modelo.getCarreras());
            break;
            case Principal.CURSO:
                this.setTitle("CURSOS");
                Tabla.setModel(modelo.getCursos());
            break;
            case Principal.PROFESOR:
                this.setTitle("PROFESORES");
                Tabla.setModel(modelo.getProfesores());
            break;
        }
        
        this.revalidate();
        if (!modelo.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, modelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBbuscar = new javax.swing.JButton();
        LBbuscar = new javax.swing.JLabel();
        TFbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        JBlistar = new javax.swing.JButton();
        JBagregar = new javax.swing.JButton();
        JBeliminar = new javax.swing.JButton();

        JBbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBbuscar.setText("Buscar");

        LBbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBbuscar.setText("Buscar");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        JBlistar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBlistar.setText("Listar");
        JBlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlistarActionPerformed(evt);
            }
        });

        JBagregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBagregar.setText("Agregar");
        JBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBagregarActionPerformed(evt);
            }
        });

        JBeliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBeliminar.setText("Eliminar");
        JBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBeliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBlistar)
                        .addGap(31, 31, 31)
                        .addComponent(JBagregar)
                        .addGap(28, 28, 28)
                        .addComponent(JBeliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(TFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(JBbuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBlistar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBagregar)
                        .addComponent(JBeliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlistarActionPerformed
        try {
            this.control.listar();
           
        } catch (Exception ex) {
            Logger.getLogger(MantenimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBlistarActionPerformed

    private void JBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBagregarActionPerformed
        Principal.CURSO_VISTA.setLocation(this.JBagregar.getLocationOnScreen());
        this.control.agregar();
    }//GEN-LAST:event_JBagregarActionPerformed

    private void JBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBeliminarActionPerformed
        int row = this.Tabla.getSelectedRow();
        if (row != -1){
            int resp =  JOptionPane.showConfirmDialog(this, "¿Desea borrar?","Eliminar",0,0);
            if (resp== JOptionPane.YES_OPTION){
                try {
                    control.eliminar(row);
                } catch (Exception ex) {
                    Logger.getLogger(MantenimientoVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_JBeliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.Tabla.getSelectedRow();
            Principal.CURSO_VISTA.setLocation(evt.getLocationOnScreen());
            this.control.editar(fila);
        }
    }//GEN-LAST:event_TablaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBagregar;
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBeliminar;
    private javax.swing.JButton JBlistar;
    private javax.swing.JLabel LBbuscar;
    private javax.swing.JTextField TFbuscar;
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
