/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;

/**
 *
 * @author daniel
 */
public class ControladorEmpresa {
    InventarioDAO miInventario;
    ProductosVentaDAO miProductoVentas;
    
    public ControladorEmpresa(InventarioDAO inventario, ProductosVentaDAO prodVentas){
        
        this.miInventario = inventario;
        
        
    }
    
}
