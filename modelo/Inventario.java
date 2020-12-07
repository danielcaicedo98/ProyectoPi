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
public class Inventario {
    private String codigoInventario;
    private double costoPrimario;
    private String nombreInventario;
    private int unidadesInventario;
    private String proveedor;
    public Inventario(){
        
    }

    public Inventario(String codigoInventario, double costoPrimario, String nombreInventario, int unidadesInventario, String proveedor) {
        this.codigoInventario = codigoInventario;
        this.costoPrimario = costoPrimario;
        this.nombreInventario = nombreInventario;
        this.unidadesInventario = unidadesInventario;
        this.proveedor = proveedor;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public double getCostoPrimario() {
        return costoPrimario;
    }

    public void setCostoPrimario(double costoPrimario) {
        this.costoPrimario = costoPrimario;
    }

    public String getNombreInventario() {
        return nombreInventario;
    }

    public void setNombreInventario(String nombreInventario) {
        this.nombreInventario = nombreInventario;
    }

    public int getUnidadesInventario() {
        return unidadesInventario;
    }

    public void setUnidadesInventario(int unidadesInventario) {
        this.unidadesInventario = unidadesInventario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
