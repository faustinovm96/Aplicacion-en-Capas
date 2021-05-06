package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.util.CRUDConstants;
import py.com.hw.dao.util.Conexion;
import py.com.hw.modelo.Cliente;

/**
 *
 * @author F996
 */
public class ClienteDaoMySQLImple implements ClienteDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean estado;

    @Override
    public boolean save(Cliente cliente) throws SQLException {
        estado = false;
        //PreparedStatement preparedStatement1;
        int idGenerado = 0;
        try {
            connection = Conexion.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(CRUDConstants.INSERT_DIRECCION, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cliente.getDireccion().getCallePrincipal());
            preparedStatement.setString(2, cliente.getDireccion().getCalleTransversal());
            preparedStatement.setString(3, cliente.getDireccion().getBarrioComp());
            preparedStatement.setInt(4, cliente.getDireccion().getNroCasa());

            System.out.println("Pasa Por INSERT");
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("IDINSERTADA: " + rs.getInt(1));
                idGenerado += rs.getInt(1);
            }
            
            preparedStatement = connection.prepareStatement(CRUDConstants.INSERT_CLIENTE);
            preparedStatement.setString(1, cliente.getNombreRazonSocial());
            preparedStatement.setInt(2, idGenerado);
            preparedStatement.setString(3, cliente.getCelular());
            preparedStatement.setString(4, cliente.getEmail());
            
            estado = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
            System.out.println("Conexion Cerrada SAVE");
        }
        
        return estado;
    }

    @Override
    public boolean update(Cliente a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cliente a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findById(Integer b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
