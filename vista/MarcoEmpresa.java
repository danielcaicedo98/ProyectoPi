/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import modelo.*;
import proyecto.*;

/**
 *
 * @author daniel
 */
class MarcoEmpresa extends JFrame{
    JPanel panelPrincipal;
    JPanel panelCentral;
    JPanel panelOpciones;
    JPanel panelSuperior;
    JMenuBar brrOperaciones;
    JMenuBar brrConsultas;
    JMenuBar brrAyuda;
    JMenu operaciones;
    JMenu consultas;
    JMenu ayuda;
    JMenuItem compraMateriaPrima;
    JMenuItem produccionProductos;
    JMenuItem ventaMostrador;
    JMenuItem pagoVendedores;
    JMenuItem consultaInventario;
    JMenuItem consultaTerminado;
    JMenuItem localizacionVendedores;
    JMenuItem chat;
    
    MarcoProduccion misProducciones;
    Menu misMenus;
    MarcoMapa miMarcoMapa;
    ProcesoDos misVentas;
    MarcoServer miServer;
    MarcoVenta marcoVenta;    
    MarcoInventario misInterfaces;
    MarcoProductoTerminado misProductos;
    Menu miMenu;
    PagoVendedores misPagos;
    
    public MarcoEmpresa() {
      
      miMenu = new Menu();
      misVentas = new ProcesoDos();
      miMarcoMapa = new MarcoMapa();
      miServer = new MarcoServer();
      setTitle("La Empresa");  
      setLayout(new GridLayout(2,0));      
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width/3, height/3);
      setLocationRelativeTo(null);
      iniciarComponentes();
      setBackground(Color.blue);
      setVisible(true);
      //misVentas.start();
       // 
    }
    
    public void iniciarComponentes(){
        
        misProducciones = new MarcoProduccion();
        misMenus = new Menu();
        misPagos = new PagoVendedores();
        misPagos.setLocationRelativeTo(null);
        marcoVenta = new MarcoVenta();
        marcoVenta.setLocationRelativeTo(null);
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2,0));
        panelCentral = new JPanel();
        panelCentral.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createEtchedBorder(), "Opciones"));
        panelCentral.setLayout(new BorderLayout());
        panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(3,0)); 
        PanelSuperior miTitulo = new PanelSuperior();
        panelSuperior = new JPanel(); 
        
        
        //Crear los menu
        
        //Menu de operaciones
        operaciones = new JMenu("Operaciones");
        brrOperaciones = new JMenuBar();
        brrConsultas = new JMenuBar();
        brrAyuda = new JMenuBar();
        compraMateriaPrima = new JMenuItem("Compra Materia Prima");
        produccionProductos = new JMenuItem("Producción Productos");
        ventaMostrador = new JMenuItem("Venta por Mostrador");
        pagoVendedores = new JMenuItem("Pago Vendedores");        
        
        operaciones.add(compraMateriaPrima);
        operaciones.add(produccionProductos);
        operaciones.add(ventaMostrador);
        operaciones.add(pagoVendedores);
        brrOperaciones.add(operaciones);
        //Menu de consultas
        
        consultas = new JMenu("Consultas");
        consultaInventario = new JMenuItem("Consultar Inventario");
        consultaTerminado = new JMenuItem("Consultar Producto Terminado");
        localizacionVendedores = new JMenuItem("Localización Vendedores");
        consultas.add(consultaInventario);
        consultas.add(consultaTerminado);
        consultas.add(localizacionVendedores);
        brrConsultas.add(consultas);
        
        //Menu de ayuda
        ayuda = new JMenu("Ayuda");
        chat = new JMenuItem("Chat");
        ayuda.add(chat);
        brrAyuda.add(ayuda);
        
        
        //se agregan menus al panel principal
        
        panelOpciones.add(brrOperaciones);
        panelOpciones.add(brrConsultas);
        panelOpciones.add(brrAyuda);
        panelCentral.add(panelOpciones);
        
        
        compraMateriaPrima.addActionListener(new ManejadorEventos());
        produccionProductos.addActionListener(new ManejadorEventos());
        ventaMostrador.addActionListener(new ManejadorEventos());
        pagoVendedores.addActionListener(new ManejadorEventos());
               
        consultaInventario.addActionListener(new ManejadorEventos());
        consultaTerminado.addActionListener(new ManejadorEventos());
        localizacionVendedores.addActionListener(new ManejadorEventos());
        chat.addActionListener(new ManejadorEventos());
        
        add(miTitulo);
        add(panelCentral);
        misInterfaces = new MarcoInventario();
        misProductos = new MarcoProductoTerminado();
        
        
        
    }
    private class PanelSuperior extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            Dimension tamanio = getSize();
            ImageIcon imagen =  new ImageIcon(
                    new ImageIcon(getClass().getResource("/Imagenes/superior.jpeg")).getImage());
            g.drawImage(imagen.getImage(),0,0, tamanio.width, tamanio.height, null);
        }
        
    }
    
    

     
    private class ManejadorEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //if(e.getActionCommand())
            if(e.getSource() == consultaInventario){
                misInterfaces.inventarioVisible();
            }else if(e.getSource() == consultaTerminado){
                misProductos.productosVentaVisible();
            }else if(e.getSource() == localizacionVendedores){
               misVentas.verMarco();
            }else if(e.getSource() == chat){
                miServer.verServer();
            }else if(e.getSource() == compraMateriaPrima){
                misMenus.setVisible(true);
            } else if(e.getSource() == ventaMostrador){
                marcoVenta.setVisible(true);
            }else if(e.getSource() == pagoVendedores){
                misPagos.setVisible(true);
            }else if(e.getSource() == produccionProductos){
                misProducciones.setVisible(true);
            }
        }
    }
}
