/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py.com.hw.dao.CategoriaDao;
import py.com.hw.dao.Conexion;
import py.com.hw.dao.util.SystemConstants;
import py.com.hw.modelo.Categoria;

/**
 *
 * @author F996
 */
public class CategoriaDaoMySQLImpl implements CategoriaDao{
    
    private static final Logger LOGGER = LogManager.getLogger(CategoriaDaoMySQLImpl.class);
    
    private Connection connTransactional;

    public CategoriaDaoMySQLImpl(Connection connection) {
        this.connTransactional = connection;
    }

    public CategoriaDaoMySQLImpl() {
    }
    
    
    @Override
    public int save(Categoria categoria) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            
            preparedStatement = connection.prepareStatement(SystemConstants.INSERT_CATEGORIA);
            
            preparedStatement.setString(1, categoria.getCategoria());
            preparedStatement.setString(2, categoria.getDescripcion());
            
            LOGGER.info("Bien por aqui");
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("MAL POR ACA");
        }
        return 0;
    }

    @Override
    public int update(Categoria categoria) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.DELETE_CATEGORIA);
            
            preparedStatement.setInt(1, idCategoria);
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
        
        return 0;
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Categoria categoria = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
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
