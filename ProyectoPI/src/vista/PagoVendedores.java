/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Fachada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class PagoVendedores extends javax.swing.JFrame {
    private ArrayList listaCodigos;
    /**
     * Creates new form PagoVendedores
     */
    public PagoVendedores() {
        listaCodigos = new ArrayList();
        initComponents();
        agregarElementosCombo();
        jcbVendedores.addActionListener(new ManejoEventos());
        btnPagar.addActionListener(new ManejoEventos());
        btnRegresar.addActionListener(new ManejoEventos());
    }
    
    public void agregarElementosCombo(){
        
         //ArrayList precios = new ArrayList();
        
         Connection connection = Fachada.getConnection();
         try{
             
             String sql = "select * from vendedor";
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery();
             while(rs.next()){
                 jcbVendedores.addItem(rs.getString(2)+" "+rs.getString(3));
                 listaCodigos.add(rs.getInt(1));
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    public void resetVentas(int index){
        try{
            Connection connection = Fachada.getConnection();
            String sql = "update venta set total_ventas = 0 where vendedor_id='"
                        +listaCodigos.get(index)+"'";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate(sql);
            
        }catch(Exception e){
           e.printStackTrace();
            
        }
    }
    //public void 
    
    public void realizarPago(int index){
        Connection connection = Fachada.getConnection();
        ArrayList codigos = new ArrayList();
        try {
            int monto = 0;
            String sql = "select * from venta where vendedor_id = '"
                    + listaCodigos.get(index) +"'";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                monto = rs.getInt(2);
                //codigos.add(rs.getSQLXML(sql))
            }
            monto = (int) (monto*0.4); 
            lblPago.setText((monto)+"");
            
            String sqlAlter = "update vendedor set pago = '"
                        +monto+"' where identificacion = '"+listaCodigos.get(index)+"'";
                
            PreparedStatement pstma = connection.prepareStatement(sqlAlter);                
            pstma.executeUpdate(sqlAlter);
        } catch (Exception e) {
            e.printStackTrace();
        }                        
    }
    private class ManejoEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jcbVendedores){
                realizarPago(jcbVendedores.getSelectedIndex());
            }else if(e.getSource() == btnPagar){
                realizarPago(jcbVendedores.getSelectedIndex());
                resetVentas(jcbVendedores.getSelectedIndex());
                //System.out.println(jcbVendedores.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "Se ha realizado el pago");
                lblPago.setText("0");
            }else if(e.getSource() == btnRegresar){
                dispose();
            }
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jcbVendedores = new javax.swing.JComboBox<>();
        lblPago = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVendedoresActionPerformed(evt);
            }
        });

        lblPago.setText("0");

        jLabel2.setText("Vendedor:");

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnPagar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPagar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbVendedoresActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagoVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PagoVendedores().setVisible(false);
                PagoVendedores misPagos = new PagoVendedores();
                
                misPagos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                misPagos.setLocationRelativeTo(null);
                misPagos.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcbVendedores;
    private javax.swing.JLabel lblPago;
    // End of variables declaration//GEN-END:variables
}