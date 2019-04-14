/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditarCursos;

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
public class EditarVista extends javax.swing.JFrame implements Observer{

    EditarModelo modelo;
    EditarControl control;
    
    public EditarVista() {
        initComponents();
    }

    public EditarModelo getModelo() {
        return modelo;
    }

    public void setEditarModelo(EditarModelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public EditarControl getControl() {
        return control;
    }

    public void setEditarControl(EditarControl control) {
        this.control = control;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEditar = new javax.swing.JTable();
        JBagregar = new javax.swing.JButton();
        JBeliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TFbuscar = new javax.swing.JTextField();
        JBbuscar = new javax.swing.JButton();
        JBlistar = new javax.swing.JButton();

        TablaEditar.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEditarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEditar);

        JBagregar.setText("Agregar Curso");
        JBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBagregarActionPerformed(evt);
            }
        });

        JBeliminar.setText("Eliminar Curso");
        JBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBeliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar");

        JBbuscar.setText("Buscar");
        JBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbuscarActionPerformed(evt);
            }
        });

        JBlistar.setText("Listar Cursos");
        JBlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlistarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JBlistar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBagregar)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBbuscar)
                            .addComponent(JBeliminar))
                        .addGap(0, 243, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBbuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBeliminar)
                    .addComponent(JBagregar)
                    .addComponent(JBlistar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBagregarActionPerformed
        Principal.CURSO_VISTA.setLocation(this.JBagregar.getLocationOnScreen());
        this.control.agregarCurso();
    }//GEN-LAST:event_JBagregarActionPerformed

    private void JBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBeliminarActionPerformed
        int row = this.TablaEditar.getSelectedRow();
        if (row != -1){
            int resp =  JOptionPane.showConfirmDialog(this, "¿Desea borrar?","Eliminar",0,0);
            if (resp== JOptionPane.YES_OPTION){
                try {
                    control.eliminarCurso(row);
                } catch (Exception ex) {
                    Logger.getLogger(EditarVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_JBeliminarActionPerformed

    private void JBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBbuscarActionPerformed

    private void TablaEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEditarMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.TablaEditar.getSelectedRow();
            Principal.CURSO_VISTA.setLocation(evt.getLocationOnScreen());
            this.control.editarCurso(fila);
        }
    }//GEN-LAST:event_TablaEditarMouseClicked

    private void JBlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlistarActionPerformed
        try {
            this.control.listarCursos();
        } catch (Exception ex) {
            Logger.getLogger(EditarVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBlistarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBagregar;
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBeliminar;
    private javax.swing.JButton JBlistar;
    private javax.swing.JTextField TFbuscar;
    private javax.swing.JTable TablaEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        
        TablaEditar.setModel(modelo.getCursos());
        
        this.revalidate();
            if (!modelo.getMensaje().equals("")){
                JOptionPane.showMessageDialog(this, modelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE); 
            }
    }
}
