/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author daniel
 */
public class Geolocalizacion extends JFrame implements ActionListener{
    
    private JPanel container;
    private JLabel labelCounter;
    private Timer timer1 = new Timer(3000, this);
    int a = 0;
    int unoX = 0;
    int unoY = 1;
    int conTres = 0;
    int tresX = 0, tresY = 1;
    int dosX = 0, dosY = 1;
    Graphics vendedorTres;
    Graphics vendedorUno;
    Graphics vendedorDos;
    JButton btnRegresar;
    
    Integer coordenadasVendedorUno[] = {
        424, 501, 441, 504, 472, 492,
        476, 471, 485, 447, 448, 432, 408, 426,
        385, 411, 388, 392, 383, 371, 351, 366,
         354, 392, 354, 424, 348, 453, 344, 497,
         344, 513, 373, 508, 425, 506, 424, 501
    };
    Integer coordenadasVendedorDos[] = {
        421, 501, 381, 510, 381, 522, 383, 539, 379, 557, 379, 581,
         376, 602, 372, 619, 375, 644, 389, 621, 411, 592,
         435, 555, 450, 531, 440, 515, 415, 503, 421, 501
    };

    Integer coordenadasVendedorTres[] = {
        417, 508, 388, 506, 371, 510, 343, 510, 317, 518, 287, 525,
        283, 493, 282, 458, 281, 437, 275, 396, 285, 363, 302, 307,
        323, 349, 368, 371, 387, 399, 386, 425, 385, 445, 385, 483,
        379, 511, 417, 508
    };

    public Geolocalizacion(){
        
        
        timer1.setInitialDelay(1000);     
        setLayout(new BorderLayout());
        container = new JPanel(); 
        btnRegresar = new JButton("Regresar");        
        container.setLayout(null);
        JPanel pnlBotones = new JPanel();
        pnlBotones.add(btnRegresar,BorderLayout.CENTER);
        add(pnlBotones,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(999,850);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Utilización del Timer");
        //container.addMouseListener(new mouseXY());
        add(container,BorderLayout.CENTER);   
        btnRegresar.addActionListener(this);
        setVisible(true);
        //
        
        
        /*timer1.setInitialDelay(1000); 
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(999, 850);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Geolocalización Vendedores");
        setVisible(false);
        iniciarComponentes();
        timer1.start();*/
        
    }
    public void run(){
        timer1.start();
    }
    public void iniciarComponentes(){
               
        container = new JPanel();
        btnRegresar = new JButton("Regresar");
        container.setLayout(null);
        JPanel pnlBotones = new JPanel();
        pnlBotones.add(btnRegresar, BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH); 
        add(container, BorderLayout.CENTER);
        btnRegresar.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = container.getGraphics();
        Dimension tamanio = getSize();
        ImageIcon imagen = new ImageIcon(
                new ImageIcon(getClass().getResource("/Imagenes/mapa.jpeg")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);

        Graphics vendedorCuatro = g;
        vendedorTres = container.getGraphics();
        vendedorUno = container.getGraphics();
        vendedorDos = container.getGraphics();

        if (a < 22) {

            //Dibujar vendedor uno
            vendedorUno(unoX, unoY);
            if (a != 2 && a != 5 && a != 12 && a < 20) {
                unoX = unoX + 2;
                unoY = unoY + 2;
            }
            //Dibujar vendedor 2 
            vendedorDos(dosX, dosY);
            if (a != 3 && a != 7 && a != 9 && a < 17) {
                dosY = dosY + 2;
                dosX = dosX + 2;
            }

            //Dibujar vendedor 3 
            vendedorTres(tresX, tresY);
            if (conTres != 4 && conTres != 6 && conTres != 8) {
                tresY = tresY + 2;
                tresX = tresX + 2;
            }

        } else {
            timer1.stop();
            vendedorUno(unoX, unoY);
            vendedorDos(dosX, dosY);
            vendedorTres(tresX, tresY);
        }

        a = a + 1;
        conTres++;

        if (e.getSource() == btnRegresar) {
            dispose();
        }
    }
    public void verGeolocalizacion(){
        setVisible(true);
    }
    public void vendedorUno(int x, int y) {
        vendedorUno.setColor(Color.red);
        vendedorUno.fillOval(coordenadasVendedorUno[x],
                 coordenadasVendedorUno[y], 10, 10);
    }

    public void vendedorDos(int x, int y) {
        vendedorDos.setColor(Color.blue);
        vendedorDos.fillOval(coordenadasVendedorDos[x],
                 coordenadasVendedorDos[y], 10, 10);
    }

    public void vendedorTres(int x, int y) {
        vendedorTres.setColor(Color.black);
        vendedorTres.fillOval(coordenadasVendedorTres[x],
                 coordenadasVendedorTres[y], 10, 10);
    }
}
