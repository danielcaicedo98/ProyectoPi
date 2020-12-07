/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.InventarioDAO;
import modelo.ProductosVentaDAO;

/**
 *
 * @author daniel
 */
public class MarcoProductoTerminado extends JFrame{
    private DefaultTableModel dtmTerminado;
    private JTable jtbTerminado;
    private JScrollPane jspTerminado;
    private JPanel panelTerminado;    
    ProductosVentaDAO misProductos = new ProductosVentaDAO();
    private JButton regresarProdVenta;
    
    public MarcoProductoTerminado(){
      setTitle("Inventario");  
      setLayout(new BorderLayout());      
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width/2, height/4);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      tablaProductoTerminado();
      setVisible(false);
    }
    
    public void borrarTabla(){
        dtmTerminado.setRowCount(0);
        
    }
    
    public void tablaProductoTerminado(){
        
        dtmTerminado = new DefaultTableModel();
        dtmTerminado.addColumn("Código Producto");
        dtmTerminado.addColumn("Costo Producto");
        dtmTerminado.addColumn("Nombre Producto");
        dtmTerminado.addColumn("Unidades");
        dtmTerminado.addColumn("Precio Producto");
        jtbTerminado = new JTable(dtmTerminado);
        jspTerminado = new JScrollPane(jtbTerminado);
        panelTerminado = new JPanel(new BorderLayout());
        panelTerminado.add(jspTerminado,BorderLayout.CENTER);
        
        JPanel panelBoton = new JPanel(new BorderLayout());
        regresarProdVenta = new JButton("Regresar");
        panelBoton.add(regresarProdVenta,BorderLayout.EAST);
        add(panelTerminado,BorderLayout.CENTER);
        add(panelBoton,BorderLayout.SOUTH);
        regresarProdVenta.addActionListener(new EventosProdVenta());
       
    }
    public void datosNuevos(){
        misProductos.resetearInventario();
        misProductos.listaProductosVenta();
        
        for (int i = 0; i < misProductos.getProdVenta().size(); i++) {
            dtmTerminado.addRow(misProductos.getProdVenta().get(i));
        }
    }
    
     public void productosVentaVisible(){
        datosNuevos();
        setVisible(true);
        repaint();
    }
    
    
    private class EventosProdVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //if(e.getActionCommand())
            if(e.getSource() == regresarProdVenta){
                dispose();
                borrarTabla();
               // dtmTerminado.removeRow(0);
            }
        }
    }
}
