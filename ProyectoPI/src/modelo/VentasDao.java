/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author daniel
 */
public class VentasDao {
    
    LinkedList <Ventas> miListaVentas;

    public VentasDao() {
        miListaVentas = new LinkedList<>();
    }
    
    public void nuevaVenta(Ventas nuevaVenta){
        miListaVentas.add(nuevaVenta);
    }
    public void actualizarDatos(String codigoVendedor,String codigoPoducto
            ,int cantidadProducto, double valorProducto){
        try{
            
            Connection connection = Fachada.getConnection();
            //for (int i = 0; i < miListaVentas.size(); i++) {
            
                String sql = "update venta set total_ventas = total_ventas + "
                        +valorProducto * cantidadProducto+" where vendedor_id= '"+codigoVendedor+"'";
                
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate(sql);
                
                
                String sqlAlter = "update productosVenta set cantidad = cantidad - "+cantidadProducto+" where codigoProducto = '"+codigoPoducto+"'";
                
                PreparedStatement pstm = connection.prepareStatement(sqlAlter);                
                pstm.executeUpdate(sqlAlter);
                
                
                
                
           //}
            
        }catch(Exception e){
           e.printStackTrace();
            
        }
    }
    
}
