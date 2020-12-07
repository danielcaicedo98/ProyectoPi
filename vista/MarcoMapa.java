
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author daniel
 */
public class MarcoMapa extends JFrame{
    private JButton btnRegresar;
    LaminaMapa miLamina;
    int unoX, unoY;
    int dosX, dosY;
    int tresX, tresY;
    public MarcoMapa(){
        
        setTitle("Geolocalización");
        setLayout(new BorderLayout());
        btnRegresar = new JButton("Regresar");
        setSize(999,650);
        setResizable(false);
        miLamina = new LaminaMapa();
        JPanel mapa = new JPanel();
        miLamina.addMouseListener(new mouse());        
        add(miLamina,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnRegresar.addActionListener(new ManejadorEventos());
        JPanel pnlBotones = new JPanel();
        pnlBotones.add(btnRegresar);
        add(pnlBotones,BorderLayout.SOUTH);  
        unoX = 0;
        unoY = 1;
        dosX = 0;
        dosY = 1;
        tresX = 0;
        tresY = 1;
        setVisible(false);
    }
    
    public void mapaVisible(){
        setVisible(true);
    }
    int contador;
    public class mouse extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            setCoordenadasUno(e.getX(), e.getY());
            /*unoX = e.getX();
            unoY = e.getY();*/
            repaint();
            //System.out.println(e.getX()+" " + e.getY());
            if(contador < 5){
                System.out.print(e.getX() + ", " + e.getY()+ ", ");
                contador++;
            }else{
                contador = 0;
                System.out.println("");
            }  
        }
       
   }
    
   public class ManejadorEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnRegresar){
                //miLamina.setCoordenadasUno(1, 1);
                dispose();
            }
        }
        
    }
   
 public class LaminaMapa extends JPanel{
    private Image imagen;
    private Graphics vendedorUno;
    private Graphics vendedorDos;
    private Graphics vendedorTres;
    
    JPanel container;
    public LaminaMapa(){
        
        
        
    }
    public void paintComponent(Graphics g) {
        //Graphics g = container.getGraphics();
        super.paintComponents(g);
        vendedorUno = g;
        vendedorDos = g;
        vendedorTres = g;
        try{    
            imagen = ImageIO.read(new File("/home/daniel/Escritorio/Java EE/Requerimiento_2/src/Imagenes/mapa.jpeg"));
        }catch(Exception e){
            
        }  
       
        g.drawImage(imagen,0,0,null);   
        
        
        
        vendedorUno.setColor(Color.red);
        vendedorUno.fillOval(unoX,
                 unoY, 10, 10);
        
       vendedorDos.setColor(Color.blue);
        vendedorDos.fillOval(dosX,
                 dosY, 10, 10);
        
        vendedorTres.setColor(Color.black);
        vendedorTres.fillOval(tresX,
                 tresY, 10, 10);
    }    
    
 }  
  public void setCoordenadasUno(int x, int y){
        this.unoX = x;
        this.unoY = y;
        this.repaint();
        
  }
  public void setCoordenadasDos(int a, int b){
        dosX = a;
        dosY = b;
        this.repaint();
        
  }
  public void setCoordenadasTres(int c, int d){
        tresX = c;
        tresY = d;
        this.repaint();
        
  }
}