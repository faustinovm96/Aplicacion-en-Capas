package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public boolean update(Cliente cliente) throws SQLException {
        estado = false;

        try {
            //connection.setAutoCommit(false);
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(CRUDConstants.UPDATE_CLIENTE);
            preparedStatement.setString(1, cliente.getNombreRazonSocial());
            preparedStatement.setString(2, cliente.getCelular());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setInt(4, cliente.getIdCliente());
            
            //preparedStatement.setInt(5, direccion.getIdDireccion());
            System.out.println("PASA POR UPDATE");
            estado = preparedStatement.executeUpdate() > 0;
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //connection.rollback();
        } finally {
            preparedStatement.close();
            //Conexion.close(connection);
            connection.close();
            System.out.println("Conexion Cerrada UPDATE");
        }

        return estado;
    }

    @Override
    public boolean delete(Cliente a) throws SQLException {

        estado = false;

        try {
            //connection.setAutoCommit(false);
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(CRUDConstants.DELETE_CLIENTE);
            preparedStatement.setInt(1, a.getIdCliente());

            estado = preparedStatement.executeUpdate() > 0;
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //connection.rollback();
        } finally {
            preparedStatement.close();
        }

        return estado;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        estado = false;
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(CRUDConstants.SELECT_ALL_CLIENTE);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idcliente"));
                cliente.setNombreRazonSocial(resultSet.getString("nombrerazonsocial"));
                cliente.setCelular(resultSet.getString("celular"));
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
    public Cliente findById(Integer b) throws SQLException {
        Cliente cliente = null;

        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareCall(CRUDConstants.SELECT_CLIENTE);
            preparedStatement.setInt(1, b);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nombreRazonSocial = resultSet.getString("nombreRazonSocial");
                String celular = resultSet.getString("celular");
                String email = resultSet.getString("email");
                //int idDireccion = resultSet.getInt("id_direccion");
                //int nro = resultSet.getInt("nroCasa");

                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idcliente"));
                cliente.setNombreRazonSocial(resultSet.getString("nombrerazonsocial"));
                cliente.setCelular(resultSet.getString("celular"));
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
