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


class MarcoInventario extends JFrame{
    private DefaultTableModel dtmInventario;
    private JTable jtbInventario;
    private JScrollPane jspInventario;
    private JPanel panelInventario;
    InventarioDAO miInventario;
    ProductosVentaDAO misProductos = new ProductosVentaDAO();
    private JButton regresarInventario;
    
    public MarcoInventario(){
        
      setTitle("Inventario");  
      setLayout(new BorderLayout());      
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width/2, height/4);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      tablaInvetario();
      setVisible(false);
     // miInventario.start();
    }
    
    public void tablaInvetario(){
        miInventario = new InventarioDAO();
        dtmInventario = new DefaultTableModel();
        dtmInventario.addColumn("Código");
        dtmInventario.addColumn("Costo Primario");
        dtmInventario.addColumn("Nombre");
        dtmInventario.addColumn("Unidades");
        dtmInventario.addColumn("Proveedor");
        jtbInventario = new JTable(dtmInventario);
        jspInventario = new JScrollPane(jtbInventario);
        panelInventario = new JPanel(new BorderLayout());
        panelInventario.add(jspInventario,BorderLayout.CENTER);
        JPanel panelBoton = new JPanel(new BorderLayout());
        regresarInventario = new JButton("Regresar");
        panelBoton.add(regresarInventario,BorderLayout.EAST);
        add(panelInventario,BorderLayout.CENTER);
        add(panelBoton,BorderLayout.SOUTH);
        regresarInventario.addActionListener(new EventosInventario());
    }
    public void inventarioVisible(){
        nuevoInventario();
        setVisible(true);
        repaint();
    }
    
    public void nuevoInventario(){
        miInventario.resetearInventario();
        miInventario.listaInventario();
        for (int i = 0; i < miInventario.getInventario().size(); i++) {
            dtmInventario.addRow(miInventario.getInventario().get(i));            
        }
    }
    
    public void borrarInventario(){
        dtmInventario.setRowCount(0);
    }
      
    public void tablaProductosVenta(){
        
        dtmInventario = new DefaultTableModel();
        dtmInventario.addColumn("Código");
        dtmInventario.addColumn("Costo Primario");
        dtmInventario.addColumn("Nombre");
        dtmInventario.addColumn("Unidades");
        dtmInventario.addColumn("Proveedor");
        jtbInventario = new JTable(dtmInventario);
        jspInventario = new JScrollPane(jtbInventario);
        panelInventario = new JPanel(new BorderLayout());
        panelInventario.add(jspInventario,BorderLayout.CENTER);
        miInventario.resetearInventario();
        miInventario.listaInventario();
        
        for (int i = 0; i < miInventario.getInventario().size(); i++) {
            dtmInventario.addRow(miInventario.getInventario().get(i));            
        }
        JPanel panelBoton = new JPanel(new BorderLayout());
        regresarInventario = new JButton("Regresar");
        panelBoton.add(regresarInventario,BorderLayout.EAST);
        add(panelInventario,BorderLayout.CENTER);
        add(panelBoton,BorderLayout.SOUTH);
        regresarInventario.addActionListener(new EventosInventario());
    }
    public void productosVentaVisible(){
        setVisible(true);
    }
    
    
    private class EventosInventario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //if(e.getActionCommand())
            if(e.getSource() == regresarInventario){
                dispose();
                borrarInventario();
            }
        }
    }
    
}