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
public class ProductosVenta {
    private String codigoProducto;
    private int costoProducto;
    private String nombreProducto;
    private int cantidad;
    private double precioProducto;

    public ProductosVenta(String codigoProducto, int costoProducto, String nombreProducto, int cantidad, double precioProducto) {
        this.codigoProducto = codigoProducto;
        this.costoProducto = costoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
    }

    public ProductosVenta() {
        
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
}
