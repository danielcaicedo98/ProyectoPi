/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MIGUEL ANGEL
 */
public class ProductosManufacturaDAO
{

    ArrayList<ProductosManufactura> productos = new ArrayList<>();
    ArrayList<String> productoTerminado = new ArrayList<>();

    public void vaciarArrays()
    {
        productos.clear();
        productoTerminado.clear();
    }

    public void cargarMateriaPrima()
    {

        Connection miConexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try
        {
            miConexion = Fachada.getConnection();
            String sql = "";
            sql = "select * from inventario";
            pstm = miConexion.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                /*inventarioBBDD ={
                        ""+rs.getString(1),""+rs.getDouble(2)
                        ,""+rs.getString(3),""+rs.getInt(4),""+rs.getString(5)};*/
                ProductosManufactura producto = new ProductosManufactura(rs.getString("codigoinventario"), rs.getString("nombreinventario"), rs.getInt("unidadesinventario"));
                productos.add(producto);
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (pstm != null)
                {
                    pstm.close();
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        //return listado;

    }

    public void cargarProductos()
    {
        Connection miConexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try
        {
            miConexion = Fachada.getConnection();
            String sql = "";
            sql = "select * from productosVenta";
            pstm = miConexion.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                /*inventarioBBDD ={
                        ""+rs.getString(1),""+rs.getDouble(2)
                        ,""+rs.getString(3),""+rs.getInt(4),""+rs.getString(5)};*/
                //ProductosManufactura producto = new ProductosManufactura(rs.getString("codigoinventario"),rs.getString("nombreinventario"),rs.getInt("unidadesinventario"));
                productoTerminado.add(rs.getString("nombreProducto"));
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (pstm != null)
                {
                    pstm.close();
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        //return listado;

    }

    public void actualizarBD(ArrayList<String> materiaPrima, String producto)
    {                       
        String dbUrl = "jdbc:mysql://localhost:3306/ProyecoPruebas?characterEncoding=utf8";
        String user = "root";
        String pass = "7649";
        Statement stmt = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet resultado = null;
        Connection con = null;
        int affectedRows = 0;
        int cantidad = 0;
        boolean flag = false;
        boolean encontrado = false;
        try
        {
            con = DriverManager.getConnection(dbUrl, user, pass);
            //stmt = con.createStatement();
            //String sql = "select * from Inventario";
            
            

            for (int i = 0; i < materiaPrima.size(); i++)
            {
                sql = "SELECT * FROM inventario";
                pstmt = con.prepareStatement(sql);
                resultado = pstmt.executeQuery();
                //System.out.println(materiaPrima);
                //ResultSet resultado = pstmt.executeQuery();
                while (resultado.next())
                {
                    if (materiaPrima.get(i).equalsIgnoreCase(resultado.getString("nombreInventario")))
                    {
                        encontrado = true;
                        //System.out.println("Se encontró "+materiaPrima.get(i));
                        cantidad = resultado.getInt("unidadesInventario");
                        //System.out.println(cantidad);
                        //System.out.println(cantidad);
                        if (cantidad < 1)
                        {
                            flag = true;
                        }
                        break;
                    }
                    if(!encontrado)
                    {
                        //System.out.println("No se encontró "+materiaPrima.get(i));
                    }
                }
                if (!flag){
                sql = "UPDATE inventario SET unidadesInventario = ? WHERE nombreInventario = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, cantidad - 1);
                pstmt.setString(2, materiaPrima.get(i));
                affectedRows = pstmt.executeUpdate();
                }
                else
                {
                    System.out.println("Hubo un error al intentar fabricar el producto");
                }
                
            }
            if(!flag){
            sql = "SELECT * FROM productosVenta";
            pstmt = con.prepareStatement(sql);
            resultado = pstmt.executeQuery();
            while (resultado.next())
            {
                if (producto.equalsIgnoreCase(resultado.getString("nombreProducto")))
                {
                    cantidad = resultado.getInt("cantidad");
                }
            }
            sql = "UPDATE productosVenta SET cantidad = ? WHERE nombreProducto = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cantidad + 10);
            pstmt.setString(2, producto);
            affectedRows = pstmt.executeUpdate();

            //stmt = con.createStatement();
            //String sql = "select * from Inventario";
            System.out.println("Fabricados 10 productos de manera satisfactoria");
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
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                    + "\n " + ex.getMessage());
        } finally
        {
            try
            {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }// nothing we can do
            try
            {
                if (con != null)
                {
                    con.close();
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }//fin finally try
        }
    }

    public ArrayList<ProductosManufactura> getProductosInventario()
    {
        return productos;
    }

    public ArrayList<String> getListaProductos()
    {
        return productoTerminado;
    }

}
