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
import py.com.hw.dao.CategoriaDao;
import py.com.hw.dao.Conexion;
import py.com.hw.dao.util.SystemConstants;
import py.com.hw.modelo.jdbc.Categoria;

/**
 *
 * @author F996
 */
public class CategoriaDaoMySQLImpl implements CategoriaDao{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    @Override
    public int save(Categoria categoria) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            
            preparedStatement = connection.prepareStatement(SystemConstants.INSERT_CATEGORIA);
            
            preparedStatement.setString(1, categoria.getCategoria());
            preparedStatement.setString(2, categoria.getDescripcion());
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Categoria categoria) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.UPDATE_CATEGORIA);
            
            preparedStatement.setString(1, categoria.getCategoria());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.setInt(3, categoria.getId());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int delete(Integer idCategoria) throws SQLException {
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.DELETE_CATEGORIA);
            
            preparedStatement.setInt(1, idCategoria);
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
        
        return 0;
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FINDALL_CATEGORIA);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Categoria cat = new Categoria();
                cat.setId(resultSet.getInt("id"));
                cat.setCategoria(resultSet.getString("categoria"));
                cat.setDescripcion(resultSet.getString("descripcion"));
                listaCategorias.add(cat);
            }
            
            return listaCategorias;
            
        } catch (SQLException e) {
        }
        
        return null;
    }

    @Override
    public Categoria findById(Integer idCategoria) throws SQLException {
        Categoria categoria = null;
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FIND_CATEGORIA);
            preparedStatement.setInt(1, idCategoria);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setCategoria(resultSet.getString("categoria"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categoria;
    }
    
}
