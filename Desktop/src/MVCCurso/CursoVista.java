/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCCurso;

import LogicaNegocio.Curso;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriana Herrera
 */
public class CursoVista extends javax.swing.JFrame implements Observer{
    
    CursoControl cursocontrol;
    CursoModelo cursomodelo;

    public CursoVista() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CursoControl getCursoControl() {
        return cursocontrol;
    }
    public void setCursoControl(CursoControl control){
        this.cursocontrol = control;
    }
    public void setCursoModelo(CursoModelo modelo){
        this.cursomodelo = modelo;
         modelo.addObserver(this);
    }

    public CursoModelo getCursoModelo() {
        return cursomodelo;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Curso curso = cursomodelo.getCurso();
        
       TFcodigo.setText(curso.getId());
       if (cursomodelo.getErrores().get("Codigo")!= null){
            TFcodigo.setToolTipText(cursomodelo.getErrores().get("Codigo"));
        }
        else{
            TFcodigo.setToolTipText("");
        }
       
       TFnombre.setText(curso.getNombre());
       if (cursomodelo.getErrores().get("Nombre")!= null){
            TFnombre.setToolTipText(cursomodelo.getErrores().get("Nombre"));
        }
        else{
            TFnombre.setToolTipText("");
        }
       
       TFcreditos.setText(Integer.toString(curso.getCreditos()));
       if (cursomodelo.getErrores().get("Creditos")!= null){
            TFcreditos.setToolTipText(cursomodelo.getErrores().get("Creditos"));
        }
        else{
            TFcreditos.setToolTipText("");
        }
       
       TFhoras.setText(Integer.toString(curso.getHorasSemanales()));
       if (cursomodelo.getErrores().get("Horas semanales")!= null){
            TFhoras.setToolTipText(cursomodelo.getErrores().get("Horas semanales"));
        }
        else{
            TFhoras.setToolTipText("");
        }
       
      CBcarrera.setSelectedItem(curso.getCarrera());
      CBciclo.setSelectedItem(curso.getCiclo());
      
      TFanno.setText(curso.getAnno());
       if (cursomodelo.getErrores().get("Año")!= null){
            TFanno.setToolTipText(cursomodelo.getErrores().get("Año"));
        }
        else{
            TFanno.setToolTipText("");
        }
       
       this.validate();
        if (!cursomodelo.getMensaje().equals(""))
        {
            JOptionPane.showMessageDialog(this, cursomodelo.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBcodigo = new javax.swing.JLabel();
        TFcodigo = new javax.swing.JTextField();
        LBnombre = new javax.swing.JLabel();
        TFnombre = new javax.swing.JTextField();
        LBcreditos = new javax.swing.JLabel();
        TFcreditos = new javax.swing.JTextField();
        LBhoras = new javax.swing.JLabel();
        TFhoras = new javax.swing.JTextField();
        LBcarrera = new javax.swing.JLabel();
        CBcarrera = new javax.swing.JComboBox();
        LBciclo = new javax.swing.JLabel();
        CBciclo = new javax.swing.JComboBox<>();
        JBguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TFanno = new javax.swing.JTextField();

        setTitle("CURSO");

        LBcodigo.setText("Codigo");

        LBnombre.setText("Nombre");

        LBcreditos.setText("Creditos");

        LBhoras.setText("Horas Semanales");

        LBcarrera.setText("Carrera");

        CBcarrera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EIF", "ILE" }));

        LBciclo.setText("Ciclo");

        CBciclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        JBguardar.setText("Guardar");
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Año");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBnombre)
                            .addComponent(LBcodigo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(TFnombre)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(LBcreditos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFcreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LBhoras)
                            .addGap(18, 18, 18)
                            .addComponent(TFhoras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TFanno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JBguardar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBcarrera)
                            .addComponent(LBciclo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBciclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBcodigo)
                    .addComponent(TFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBcarrera)
                    .addComponent(CBcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBnombre)
                    .addComponent(TFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBciclo)
                    .addComponent(CBciclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBcreditos)
                    .addComponent(TFcreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TFanno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBhoras)
                            .addComponent(TFhoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(JBguardar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        this.cursocontrol.agregarCurso();
    }//GEN-LAST:event_JBguardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox CBcarrera;
    public javax.swing.JComboBox<String> CBciclo;
    private javax.swing.JButton JBguardar;
    private javax.swing.JLabel LBcarrera;
    private javax.swing.JLabel LBciclo;
    private javax.swing.JLabel LBcodigo;
    private javax.swing.JLabel LBcreditos;
    private javax.swing.JLabel LBhoras;
    private javax.swing.JLabel LBnombre;
    public javax.swing.JTextField TFanno;
    public javax.swing.JTextField TFcodigo;
    public javax.swing.JTextField TFcreditos;
    public javax.swing.JTextField TFhoras;
    public javax.swing.JTextField TFnombre;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
