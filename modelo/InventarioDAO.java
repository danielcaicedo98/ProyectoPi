/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexion.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class InventarioDAO {
    private LinkedList <String[]> listInventario; 
    public InventarioDAO(){
        listInventario = new LinkedList<String[]>();
    }
    public void resetearInventario(){
        listInventario.clear();
    }
    
    public void listaInventario(){   
       
        Connection miConexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Inventario> listado = new ArrayList<>();
        try{
            miConexion = Fachada.getConnection();
            String sql="";            
            sql = "select * from inventario";
            pstm = miConexion.prepareStatement(sql);
            rs = pstm.executeQuery(); 
            while(rs.next()){                
                 String [] inventarioBBDD = {
                     rs.getString(1),""+rs.getDouble(2),rs.getString(3),
                     ""+rs.getInt(4),rs.getString(5)}; 
                 listInventario.add(inventarioBBDD);
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
    }
    
    // Método que actualiza la base de datos de inventario
    // de acuerdo al uso que se le de
    public void usoInventario(String codigo, int cantidad){
        
        Connection miConexion = null;
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Inventario> listado = new ArrayList<>();
        try{
            miConexion = Fachada.getConnection();
            miConexion.setAutoCommit(false);
            String sql="";            
            sql = "select * from inventario";
            pstm = miConexion.prepareStatement(sql);
            rs = pstm.executeQuery();
                        
            Inventario programa = null;
            while(rs.next()){
                listado.add(new Inventario(rs.getString(1),rs.getDouble(2)
                        ,rs.getString(3),rs.getInt(4),rs.getString(1)));                
            }
            
            miConexion.commit();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            try{
                miConexion.rollback();
            }catch(Exception e){
                e.printStackTrace();
            }
            
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
        
    }
    
    public LinkedList<String[]> getInventario(){
        
        return listInventario;
    }
    
    
}
 
