/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import modelo.Inventario;

/**
 *
 * @author MIGUEL ANGEL
 */
public class Menu extends javax.swing.JFrame
{
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> nombre = new ArrayList<>();
    ArrayList<String> proveedor = new ArrayList<>();
    ArrayList<Integer> cantidad = new ArrayList<>();
    
    String[] materiales = null;
    String[] proveedores = new String[]{"Juanito","Pepito","Adolfito","Jaimito","Camilito","Danielito"};
    ArrayList<String>ingredientes=new ArrayList<>();
    ArrayList<String>proveedores1=new ArrayList<>();

    /**
     * Creates new form Ventana
     */
    public Menu()
    {
        materiales = inicializarComponentes();
        initComponents();
        cargarBD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jComboIngrediente = new javax.swing.JComboBox<>();
        jButtonAñadirNuevoIngrediente = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInventario = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Material a comprar"));

        jComboIngrediente.setModel(new DefaultComboBoxModel<String>(materiales));
        jComboIngrediente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboIngredienteActionPerformed(evt);
            }
        });

        jButtonAñadirNuevoIngrediente.setText("Añadir nuevo");
        jButtonAñadirNuevoIngrediente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAñadirNuevoIngredienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAñadirNuevoIngrediente)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAñadirNuevoIngrediente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSalirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        jTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "ID", "Nombre", "Cantidad", "Proveedor"
            }
        ));
        jScrollPane1.setViewportView(jTableInventario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        jTextCantidad.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextCantidadActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        jButtonComprar.setText("Comprar");
        jButtonComprar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButtonComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirNuevoIngredienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAñadirNuevoIngredienteActionPerformed
    {//GEN-HEADEREND:event_jButtonAñadirNuevoIngredienteActionPerformed
    
        VentanaAuxiliar ventana = new VentanaAuxiliar("ingrediente");
        ventana.setVisible(true);
    }//GEN-LAST:event_jButtonAñadirNuevoIngredienteActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSalirActionPerformed
    {//GEN-HEADEREND:event_jButtonSalirActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboIngredienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboIngredienteActionPerformed
    {//GEN-HEADEREND:event_jComboIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboIngredienteActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextCantidadActionPerformed
    {//GEN-HEADEREND:event_jTextCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonComprarActionPerformed
    {//GEN-HEADEREND:event_jButtonComprarActionPerformed
        // TODO add your handling code here:
        String dbUrl ="jdbc:mysql://localhost:3306/ProyecoPruebas?characterEncoding=utf8";
        String user = "root";
        String pass = "7649";
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection con = null;
        boolean encontro = false;
        int rstdo;
        int cantidad = 0;
        int affectedRows = 0;
        try {
            con = DriverManager.getConnection(dbUrl, user, pass);
            //stmt = con.createStatement();
            //String sql = "select * from Inventario";
            String sql = "SELECT * FROM inventario";
            pstmt = con.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next())
            {
                if(jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase(resultado.getString("nombreinventario")))
                {
                    encontro = true;
                    cantidad = resultado.getInt("unidadesinventario");
                }
            }
            if(encontro = true)
            {
                sql = "UPDATE inventario SET unidadesinventario = ? WHERE nombreinventario = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, cantidad + Integer.parseInt(jTextCantidad.getText()));
                pstmt.setString(2, jComboIngrediente.getSelectedItem().toString());
                affectedRows = pstmt.executeUpdate();
            }
            else
            {
            sql = "INSERT INTO inventario values (DEFAULT,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            //pstmt.setInt(1, 0);
            pstmt.setString(1, "A004");            
            pstmt.setDouble(2, 2000.0);
            pstmt.setString(3, jComboIngrediente.getSelectedItem().toString());
            //pstmt.setString(5, jComboProveedor.getSelectedItem().toString());
            pstmt.setInt(4, Integer.parseInt(jTextCantidad.getText()));
            if((jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Harina"))||(jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Huevos"))||(jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Queso")))
            {
                pstmt.setString(5, "Inter");
            }
            else if((jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Naranja"))||(jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Papa")))
            {
                pstmt.setString(5, "Santa Helena");
            }
            else if((jComboIngrediente.getSelectedItem().toString().equalsIgnoreCase("Pollo")))
            {
                pstmt.setString(5, "Sevi");
            }
            else 
            {
                pstmt.setString(5, "Desconocido");
            }
            //ResultSet resultado = stmt.executeUpdate(sql);
            rstdo=pstmt.executeUpdate();
                System.out.println("Materia prima adquirida satisfactoriamente");
            }
            
            
            /*String listado="";
            pantalla.setText("Codigo \t Programa \n" );
            while(resultado.next()){
                listado = resultado.getString("cod_prog") + "\t" +
                        resultado.getString("nom_pro")+"\n";
                pantalla.append(listado);
            }
            JOptionPane.showMessageDialog(null,desliza);
        */
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage());
        } finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage());
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage()); 
        }//fin finally try
        }// Fin de try

        /* Create and display the form */
        
    }//GEN-LAST:event_jButtonComprarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
   
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Menu().setVisible(false);
            }
        });
    }
    private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTableInventario.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    public void cargarInventario(ArrayList<String> Id,ArrayList<String> nombre,ArrayList<Integer> cantidad,ArrayList<String> proveedor){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTableInventario.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < Id.size(); i++){
              modelo.addRow(new Object[]{
              Id.get(i),
              nombre.get(i),
              cantidad.get(i),
              proveedor.get(i)});
        }
    }
    public void cargarBD()
    {
        limpiarListadoTabla(); String dbUrl ="jdbc:mysql://localhost:3306/ProyecoPruebas?characterEncoding=utf8";
        String user = "root";
        String pass = "7649";
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection con = null;
        int rstdo;

        try {
            con = DriverManager.getConnection(dbUrl, user, pass);
            //stmt = con.createStatement();
            //String sql = "select * from Inventario";
            String sql = "select * from inventario";
            pstmt = con.prepareStatement(sql);
            //pstmt.setInt(1, 0);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next())
            {
                id.add(resultado.getString("codigoInventario"));
                nombre.add(resultado.getString("nombreInventario"));
                ingredientes.add(resultado.getString("nombreinventario"));
                proveedor.add(resultado.getString("proveedor"));
                cantidad.add(resultado.getInt("unidadesInventario"));
            }
            cargarInventario(id,nombre,cantidad,proveedor);
            /*String listado="";
            pantalla.setText("Codigo \t Programa \n" );
            while(resultado.next()){
                listado = resultado.getString("cod_prog") + "\t" +
                        resultado.getString("nom_pro")+"\n";
                pantalla.append(listado);
            }
            JOptionPane.showMessageDialog(null,desliza);
        */
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage());
        } finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage());
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode() 
                    + "\n " + ex.getMessage()); 
        }//fin finally try
        }// Fin de try

        /* Create and display the form */
        
    }
    public void añadirIngrediente(String ingrediente)
    {
        ingredientes.add(ingrediente);
    }
    public void añadirProveedor(String proveedor)
    {
        proveedores1.add(proveedor);
    }
    public String[] inicializarComponentes()
    {
        ingredientes.clear();
        cargarMateriales();
        int j = 0;
        String[] materiales = new String[ingredientes.size()];
        materiales = ingredientes.toArray(materiales);
        return materiales;
    }
    public void cargarCombo()
    {
        for (String i:materiales)
        {
            ingredientes.add(i);
        }
        System.out.println(ingredientes.get(ingredientes.size()-1));
        for (String i:ingredientes)
        {
            jComboIngrediente.addItem(i);
        }
        for (String i:proveedores1)
        {
            //jComboProveedor.addItem(i);
        }
    }
    public void cargarMateriales(){   
       
        Connection miConexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            miConexion = Fachada.getConnection();
            String sql="";            
            sql = "select * from inventario";
            pstm = miConexion.prepareStatement(sql);
            rs = pstm.executeQuery(); 
            while(rs.next()){                
                 ingredientes.add(rs.getString("nombreinventario"));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        
       //return listado;
       
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirNuevoIngrediente;
    private javax.swing.JButton jButtonComprar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboIngrediente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInventario;
    private javax.swing.JTextField jTextCantidad;
    // End of variables declaration//GEN-END:variables
}