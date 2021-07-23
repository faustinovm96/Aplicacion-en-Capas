package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.util.SystemConstants;
import py.com.hw.dao.Conexion;
import py.com.hw.modelo.jdbc.Cliente;


/**
 *
 * @author Faustino Villasboa Martínez
 */
public class ClienteDaoMySQLImple implements ClienteDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public int save(Cliente cliente) throws SQLException {        
        try {
            connection = Conexion.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(SystemConstants.INSERT_CLIENTE);
            preparedStatement.setString(1, cliente.getCedulaRUC());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getEmail());

            return preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
            System.out.println("Conexion Cerrada SAVE");
        }

        return 0;
    }
    
    @Override
    public int update(Cliente cliente) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.UPDATE_CLIENTE);
            preparedStatement.setString(1, cliente.getCedulaRUC());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setInt(6, cliente.getId());
            
            System.out.println("PASA POR UPDATE");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
            System.out.println("Conexion Cerrada UPDATE");
        }

        return 0;
    }

    @Override
    public int delete(Integer idCliente) throws SQLException {

        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.DELETE_CLIENTE);
            preparedStatement.setInt(1, idCliente);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }

        return 0;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {;
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FINDALL_CLIENTES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCedulaRUC(resultSet.getString("cedularuc"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setEmail(resultSet.getString("email"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }

        return listaClientes;
    }

    @Override
    public Cliente findById(Integer idCliente) throws SQLException {
        Cliente cliente = null;
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FIND_CLIENTE);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("cedularuc"));
                cliente.setCedulaRUC(resultSet.getString("nombre"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }

        return cliente;
    }

}
