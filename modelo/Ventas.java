/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daniel
 */
public class Ventas {
    private String codigoVendedor;
    private String idProducto;
    private int canidadProducto;
    private double precioProducto;

    public Ventas(String codigoVendedor, String idProducto, int canidadProducto, double precioProducto) {
        this.codigoVendedor = codigoVendedor;
        this.idProducto = idProducto;
        this.canidadProducto = canidadProducto;
        this.precioProducto = precioProducto;
    }
    public Ventas(){
        
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCanidadProducto() {
        return canidadProducto;
    }

    public void setCanidadProducto(int canidadProducto) {
        this.canidadProducto = canidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

}
