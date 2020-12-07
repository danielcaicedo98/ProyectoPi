package modelo;

import java.util.List;
import modelo.ProductosVenta;

public class Venta {

    private Vendedor vendedor;
    private List<ProductosVenta> productos;
    private boolean pagado = false;

    public Venta() {
    }

    public Venta(Vendedor vendedor, List<ProductosVenta> productos) {
        this.vendedor = vendedor;
        this.productos = productos;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<ProductosVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductosVenta> productos) {
        this.productos = productos;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isPagado() {
        return pagado;
    }

}
