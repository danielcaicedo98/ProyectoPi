/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MIGUEL ANGEL
 */
public class ProductosManufactura
{
    String nombre;
    String id;
    int cantidadDisponible;
    
    public ProductosManufactura(String id, String nombre, int cantidadDisponible)
    {
        this.nombre = nombre;
        this.id = id;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getCantidadDisponible()
    {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible)
    {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    
}
