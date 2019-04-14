/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import principal.Principal;

/**
 *
 * @author Adriana Herrera
 */
public class MantenimientosVista extends javax.swing.JFrame {

    MantenimientosControl control;
    
    public void setMantenimientoControl(MantenimientosControl control){
        this.control = control;
    }
    
    public MantenimientosVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBtitulo = new javax.swing.JLabel();
        JBcarreras = new javax.swing.JButton();
        JBalumnos = new javax.swing.JButton();
        JBcursos = new javax.swing.JButton();
        JBprofesores = new javax.swing.JButton();

        setTitle("Mantenimiento");

        LBtitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LBtitulo.setText("MANTENIMIENTOS");

        JBcarreras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBcarreras.setText("Carreras");
        JBcarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcarrerasActionPerformed(evt);
            }
        });

        JBalumnos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBalumnos.setText("Alumnos");
        JBalumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalumnosActionPerformed(evt);
            }
        });

        JBcursos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBcursos.setText("Cursos");
        JBcursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcursosActionPerformed(evt);
            }
        });

        JBprofesores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JBprofesores.setText("Profesores");
        JBprofesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBprofesoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBcursos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBalumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBprofesores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LBtitulo)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBalumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBcursos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBprofesores, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBcursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcursosActionPerformed
        Principal.MATENIMIENTO_VISTA.setLocation(this.JBcursos.getLocationOnScreen());
        this.control.Curso();
    }//GEN-LAST:event_JBcursosActionPerformed

    private void JBcarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcarrerasActionPerformed
        Principal.MATENIMIENTO_VISTA.setLocation(this.JBcarreras.getLocationOnScreen());
        this.control.Carrera();
    }//GEN-LAST:event_JBcarrerasActionPerformed

    private void JBalumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalumnosActionPerformed
        Principal.MATENIMIENTO_VISTA.setLocation(this.JBalumnos.getLocationOnScreen());
        this.control.Alumno();
    }//GEN-LAST:event_JBalumnosActionPerformed

    private void JBprofesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBprofesoresActionPerformed
        Principal.MATENIMIENTO_VISTA.setLocation(this.JBprofesores.getLocationOnScreen());
        this.control.Profesor();
    }//GEN-LAST:event_JBprofesoresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalumnos;
    private javax.swing.JButton JBcarreras;
    private javax.swing.JButton JBcursos;
    private javax.swing.JButton JBprofesores;
    private javax.swing.JLabel LBtitulo;
    // End of variables declaration//GEN-END:variables
}
