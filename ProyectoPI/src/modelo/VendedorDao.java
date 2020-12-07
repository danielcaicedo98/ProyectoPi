package modelo;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao {

    public List<Vendedor> listar() throws SQLException {
        Connection connection = Fachada.getConnection();

        String sql = "SELECT identificacion, nombres, apellidos FROM vendedor";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Vendedor> vendedores = new ArrayList<>();
        while (resultSet.next()) {
            Vendedor vendedor = new Vendedor();
            vendedor.setIdentificacion(resultSet.getString("identificacion"));
            vendedor.setNombres(resultSet.getString("nombres"));
            vendedor.setApellidos(resultSet.getString("apellidos"));

            vendedores.add(vendedor);
        }
        
        return vendedores;
    }
    
}
