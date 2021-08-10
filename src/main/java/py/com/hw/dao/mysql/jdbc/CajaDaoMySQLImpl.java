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
import java.util.ArrayList;
import java.util.List;
import py.com.hw.dao.CajaDao;
import py.com.hw.dao.Conexion;
import py.com.hw.modelo.jdbc.Caja;

/**
 *
 * @author F996
 */
public class CajaDaoMySQLImpl implements CajaDao {

    /**Queries SQL para la tabla cajas**/
    public static final String INSERT_CAJA = "INSERT INTO cajas (nombre, estado) VALUES (?,?)";
    public static final String UPDATE_CAJA = "UPDATE cajas SET nombre=?, estado=? WHERE id=?";
    public static final String DELETE_CAJA = "DELETE FROM cajas WHERE id=?";
    public static final String FIND_CAJA = "SELECT * FROM cajas WHERE id=?";
    public static final String FINDALL_CAJA = "SELECT * FROM cajas";
    
    private Connection connTransactional;

    public CajaDaoMySQLImpl(Connection connTransactional) {
        this.connTransactional = connTransactional;
    }

    public CajaDaoMySQLImpl() {
    }
    
    @Override
    public int save(Caja caja) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CAJA);
            preparedStatement.setString(1, caja.getNombre());
            preparedStatement.setBoolean(2, caja.getEstado());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
        return 0;
    }

    @Override
    public int update(Caja caja) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CAJA);
            preparedStatement.setString(1, caja.getNombre());
            preparedStatement.setBoolean(2, caja.getEstado());
            preparedStatement.setInt(3, caja.getId());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int delete(Integer idCaja) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CAJA);
            
            preparedStatement.setInt(1, idCaja);
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public List<Caja> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Caja> listaCajas = new ArrayList<Caja>();
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(FINDALL_CAJA);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Caja caja = new Caja(resultSet.getInt("id"), resultSet.getString("nombre"),
                                        resultSet.getBoolean("estado"));
                
                listaCajas.add(caja);
            }
            
            return listaCajas;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Caja findById(Integer idCaja) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Caja caja = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(FIND_CAJA);
            preparedStatement.setInt(1, idCaja);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                caja = new Caja(resultSet.getInt("id"), resultSet.getString("nombre"),
                                resultSet.getBoolean("estado"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caja;
    }
    
}
