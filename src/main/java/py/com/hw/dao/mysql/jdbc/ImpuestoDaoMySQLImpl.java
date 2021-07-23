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
import py.com.hw.dao.Conexion;
import py.com.hw.dao.ImpuestoDao;
import py.com.hw.dao.util.SystemConstants;
import py.com.hw.modelo.jdbc.Impuesto;

/**
 *
 * @author F996
 */
public class ImpuestoDaoMySQLImpl implements ImpuestoDao{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    @Override
    public int save(Impuesto impuesto) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareCall(SystemConstants.INSERT_IMPUESTOS);
            preparedStatement.setString(1, impuesto.getDescripcion());
            preparedStatement.setDouble(2, impuesto.getValor());
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Impuesto impuesto) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.UPDATE_IMPUESTOS);
            preparedStatement.setString(1, impuesto.getDescripcion());
            preparedStatement.setDouble(2, impuesto.getValor());
            preparedStatement.setInt(3, impuesto.getId());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Integer idImpuesto) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.DELETE_IMPUESTOS);
            preparedStatement.setInt(1, idImpuesto);
            
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Impuesto> findAll() throws SQLException {
        List<Impuesto> listaImpuestos = new ArrayList<Impuesto>();
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareCall(SystemConstants.FINDALL_IMPUESTOS);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Impuesto imp = new Impuesto();
                imp.setDescripcion(resultSet.getString("descripcion"));
                imp.setValor(resultSet.getDouble("valor"));
                imp.setId(resultSet.getInt("id"));
                
                listaImpuestos.add(imp);
            }
            return listaImpuestos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Impuesto findById(Integer idImpuesto) throws SQLException {
        Impuesto impuesto = null;
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FIND_IMPUESTOS);
            preparedStatement.setInt(1, idImpuesto);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                impuesto = new Impuesto();
                impuesto.setDescripcion(resultSet.getString("descripcion"));
                impuesto.setValor(resultSet.getDouble("valor"));
                impuesto.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return impuesto;
    }
    
}
