package vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
                /*
                    Realizar métodos para consulta de los inventarios 
                    de materia prima y producto terminado
        
                 */
        /*VentasDao misVentas = new VentasDao();
        misVentas.actualizarDatos("12129280", "CF28", 4, 500);*/
        //misVentas.actualizarDatos("12129280", "CR24", 2, 900);
                
         MarcoEmpresa miMarco = new MarcoEmpresa();            
         miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         /*Geolocalizacion l = new Geolocalizacion();
         l.verGeolocalizacion();*/
         /*ProcesoDos x = new ProcesoDos();
        
         x.verMarco();
         x.start();
        */
        
        /* MarcoMapa miMarco = new MarcoMapa();
         miMarco.setVisible(true);*/
        
        /*MarcoInventario miMarcoI = new MarcoInventario();
        miMarcoI.nuevoInventario();
        miMarcoI.setVisible(true);*/
    }
    
}

