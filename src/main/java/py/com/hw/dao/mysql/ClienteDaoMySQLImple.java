package py.com.hw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.Conexion;
import py.com.hw.modelo.domain.Cliente;


/**
 *
 * @author Faustino Villasboa Martínez
 */
public class ClienteDaoMySQLImple implements ClienteDao {
    
    /**Queries SQL para la tabla clientes**/
    public static final String INSERT_CLIENTE = "INSERT INTO clientes (cedula_ruc, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
    public static final String UPDATE_CLIENTE = "UPDATE clientes SET cedula_ruc=?, nombre=?, direccion=?, telefono=?, email=? WHERE id_cliente=?";
    public static final String DELETE_CLIENTE = "DELETE FROM clientes WHERE id_cliente=?";
    public static final String FIND_CLIENTE = "SELECT * FROM clientes WHERE id_cliente=?";
    public static final String FINDALL_CLIENTES = "SELECT * FROM clientes";

    private Connection connTransactional;

    public ClienteDaoMySQLImple(Connection connTransactional) {
        this.connTransactional = connTransactional;
    }

    public ClienteDaoMySQLImple() {
    }
    
    @Override
    public int save(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();

            preparedStatement = connection.prepareStatement(INSERT_CLIENTE);
            preparedStatement.setString(1, cliente.getCedulaRUC());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getEmail());

            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CLIENTE);
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
       
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();

            preparedStatement = connection.prepareStatement(DELETE_CLIENTE);
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
    public List<Cliente> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();

            preparedStatement = connection.prepareStatement(FINDALL_CLIENTES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCedulaRUC(resultSet.getString("cedula_ruc"));
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cliente cliente = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();

            preparedStatement = connection.prepareStatement(FIND_CLIENTE);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("cedula_ruc"));
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
