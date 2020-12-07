package modelo;

import conexion.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PagoDao {

    public void insertar(String vendedorId, double valor) throws SQLException {
        Connection connection = Fachada.getConnection();
        String sql = "INSERT INTO pago (id, vendedor_id, valor) VALUES ('"
                + new Date().getTime()
                + "', '"
                + vendedorId
                + "', "
                + valor
                + ")";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);

    }

}
