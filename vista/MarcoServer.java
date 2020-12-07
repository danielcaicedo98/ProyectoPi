/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author daniel
 */



class MarcoServer extends JFrame{
	
	public MarcoServer(){
		
                
            
                setTitle("Soporte");
            
		setSize(250,320);
				
		LaminaMarcoServer milamina=new LaminaMarcoServer();
                
                setLocationRelativeTo(null);
                
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                setResizable(false);
		
		add(milamina);
		
		setVisible(false);
	}	

    public void verServer() {
        setVisible(true);
    }
    
    
    
    
    private class LaminaMarcoServer extends JPanel implements Runnable {

        private JTextField campo1;
        private JButton miboton, regresar;
        private JTextArea campoChat;
        final int port = 12345;
        byte[] bufferCliente = new byte[1024];
        byte[] bufferServer = new byte[1024];
        DatagramSocket socketUDP;
        DatagramPacket peticion;
        Date fecha = new Date();
        String datoFecha = "Chat_"+fecha.getMinutes()+"_"+fecha.getDay()+"-"+fecha.getMonth()+"-"+"2020";
       
        String frase; 
        FileWriter escritura;

        public LaminaMarcoServer() {
            
            conexion();
            
            campoChat = new JTextArea(12, 20);

            campo1 = new JTextField(20);

            campoChat.setEditable(false);

            add(campoChat);

            add(campo1);

            miboton = new JButton("Enviar");

            miboton.addActionListener(new EnviaTexto());

            add(miboton);

            regresar = new JButton("Regresar");

            regresar.addActionListener(new EnviaTexto());

            add(regresar);

            setBackground(Color.red);

            Thread miHilo = new Thread(this);

            miHilo.start();

        }

        public void conexion() {

            try {
                 //String x =  "/home/daniel/Escritorio/Java EE/Requerimiento2.4/src";
                escritura = new FileWriter("/home/daniel/Escritorio/Java EE/Requerimiento2.4/src/ChatClientes/"+datoFecha+".txt");
                socketUDP = new DatagramSocket(port);
            } catch (SocketException ex) {
                Logger.getLogger(LaminaMarcoServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MarcoServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        public void cerrarConexion() {
            try {
                escritura.close();
            } catch (IOException ex) {
                Logger.getLogger(MarcoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void mensaje(String mensaje) {
            try {

               
                String mensajeCliente = mensaje;
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();
                bufferServer = null;
                bufferServer = mensajeCliente.getBytes();
                DatagramPacket respuesta = new DatagramPacket(bufferServer,
                        bufferServer.length, direccion, puertoCliente);
                
                socketUDP.send(respuesta);
                
            } catch (IOException ex) {
                Logger.getLogger(LaminaMarcoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            //peticion = new DatagramPacket(bufferCliente, bufferCliente.length);
            
            try {
                //DatagramSocket socket = new DatagramSocket();
                
              while(true){  
                //socket.receive(peticion);
                DatagramPacket peticion = new DatagramPacket(bufferCliente, bufferCliente.length);
                socketUDP.receive(peticion);
                setPeticion(peticion);
               if(peticion != null){
                    
                    String mensajeServidor = new String(peticion.getData());
                    campoChat.append("Cliente: " + mensajeServidor + "\n");
                    String frase = "Cliente: " + mensajeServidor + "\n";
                    for (int i = 0; i < frase.length(); i++) {

                        escritura.write(frase.charAt(i));
                   }
                }
              } 
            } catch (IOException ex) {
                Logger.getLogger(LaminaMarcoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            
        
        }
        public void setPeticion(DatagramPacket peticion){
           
                this.peticion=peticion;
            
        }
        private class EnviaTexto implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == miboton) {
                    campoChat.append("Yo: " + campo1.getText()+"\n");
                    frase = "Asesor: " + campo1.getText() + "\n";
                    for (int i = 0; i < frase.length(); i++) {
                        try {
                            escritura.write(frase.charAt(i));
                        } catch (IOException ex) {
                            Logger.getLogger(MarcoServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    mensaje("" + campo1.getText());
                    campo1.setText("");
                } else if (e.getSource() == regresar) {
                    dispose();
                    cerrarConexion();
                }

            }

        }

    }
	
}

