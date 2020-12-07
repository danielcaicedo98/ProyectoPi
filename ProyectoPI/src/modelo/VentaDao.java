package modelo;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ProductosVenta;

public class VentaDao {

    public void insertar(Venta venta) throws SQLException {
        Connection connection = Fachada.getConnection();

        for (ProductosVenta producto : venta.getProductos()) {
            String sql = "INSERT INTO venta (vendedor_id, producto_id, cantidad, precio, pagado) VALUES ('"
                    + venta.getVendedor().getIdentificacion()
                    + "', '"
                    + producto.getCodigoProducto()
                    + "', "
                    + producto.getCantidad()
                    + ", "
                    + producto.getPrecioProducto()
                    + ", "
                    + venta.isPagado()
                    + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
        }
    }

    public double calcularComision(String vendedorId) throws SQLException {
        Connection connection = Fachada.getConnection();

        String sql = "SELECT SUM(((precio * cantidad) * 10 / 100)) comision FROM venta WHERE pagado = 0 AND vendedor_id = '" + vendedorId + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()) {
            return resultSet.getDouble("comision");
        }

        return 0;
    }

    public void actualizarVenta(String vendedorId) throws SQLException {
        Connection connection = Fachada.getConnection();

        String sql = "UPDATE venta SET pagado = 1 WHERE vendedor_id = '" + vendedorId + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);
    }

}
