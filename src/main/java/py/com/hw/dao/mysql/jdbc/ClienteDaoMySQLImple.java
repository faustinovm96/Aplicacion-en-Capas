/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.util.Conexion;
import py.com.hw.modelo.Cliente;

/**
 *
 * @author F996
 */
public class ClienteDaoMySQLImple implements ClienteDao{
    
    private static final String INSERT_CLIENTE = "INSERT INTO cliente (nombreRazonSocial, idDireccion, celular, email) VALUES (?,?,?,?)";
    private static final String UPDATE_CLIENTE = "UPDATE cliente SET nombreRazonSocial=?, idDireccion=?. celular=?, email=? WHERE idCliente=?";
    private static final String DELETE_CLIENTE = "DELETE FROM cliente WHERE idCliente=?";
    private static final String SELECT_CLIENTE = "SELECT * FROM cliente WHERE idCliente=?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente";
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean estado;
    
    @Override
    public boolean save(Cliente cliente) throws SQLException {
        estado = false;
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CLIENTE);
            preparedStatement.setString(1, cliente.getNombreRazonSocial());
            preparedStatement.setInt(2, cliente.getDireccion().getIdDireccion());
            preparedStatement.setString(3, cliente.getCelular());
            preparedStatement.setString(4, cliente.getEmail());
            
            System.out.println("Pasa Por INSERT");
            estado = preparedStatement.executeUpdate() > 0;
 
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally{
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
