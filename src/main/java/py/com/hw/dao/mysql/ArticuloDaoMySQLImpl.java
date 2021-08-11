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
import py.com.hw.dao.ArticuloDao;
import py.com.hw.dao.Conexion;
import py.com.hw.dao.util.SystemConstants;
import py.com.hw.modelo.Articulo;

/**
 *
 * @author F996
 */
public class ArticuloDaoMySQLImpl implements ArticuloDao{
    
    private Connection connTransactional;

    public ArticuloDaoMySQLImpl(Connection connTransactional) {
        this.connTransactional = connTransactional;
    }

    public ArticuloDaoMySQLImpl() {
    }
    
    @Override
    public int save(Articulo articulo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.INSERT_ARTICULO);
            preparedStatement.setString(1, articulo.getCodigo());
            preparedStatement.setString(2, articulo.getNombre());
            preparedStatement.setString(3, articulo.getDescripcion());
            preparedStatement.setDouble(4, articulo.getPrecioCompra());
            preparedStatement.setDouble(5, articulo.getPrecioVenta());
            preparedStatement.setInt(6, articulo.getStock());
            preparedStatement.setInt(7, articulo.getIdCategoria());
            preparedStatement.setInt(8, articulo.getIdImpuesto());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int update(Articulo articulo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.UPDATE_ARTICULO);
            
            preparedStatement.setString(1, articulo.getCodigo());
            preparedStatement.setString(2, articulo.getNombre());
            preparedStatement.setString(3, articulo.getDescripcion());
            preparedStatement.setDouble(4, articulo.getPrecioCompra());
            preparedStatement.setDouble(5, articulo.getPrecioVenta());
            preparedStatement.setInt(6, articulo.getStock());
            preparedStatement.setInt(7, articulo.getIdCategoria());
            preparedStatement.setInt(8, articulo.getIdImpuesto());
            preparedStatement.setInt(9, articulo.getId());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Integer idArticulo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.DELETE_ARTICULO);
            
            preparedStatement.setInt(1, idArticulo);
            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public List<Articulo> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Articulo> listaArticulos = new ArrayList<Articulo>();
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareCall(SystemConstants.FINDALL_ARTICULO);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){//Refactorizar en el constructor
                Articulo art = new Articulo();
                art.setId(resultSet.getInt("id"));
                art.setCodigo(resultSet.getString("codigo"));
                art.setNombre(resultSet.getString("nombre"));
                art.setDescripcion(resultSet.getString("descripcion"));
                art.setPrecioCompra(resultSet.getDouble("p_compra"));
                art.setPrecioVenta(resultSet.getDouble("p_venta"));
                art.setStock(resultSet.getInt("stock"));
                art.setIdCategoria(resultSet.getInt("id_categoria"));
                art.setIdImpuesto(resultSet.getInt("id_impuesto"));
                listaArticulos.add(art);
            }
            return listaArticulos;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Articulo findById(Integer idArticulo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Articulo articulo = null;
        
        try {
            connection = this.connTransactional != null ? this.connTransactional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SystemConstants.FIND_ARTICULO);
            preparedStatement.setInt(1, idArticulo);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                articulo = new Articulo();
                articulo.setId(resultSet.getInt("id"));
                articulo.setCodigo(resultSet.getString("codigo"));
                articulo.setNombre(resultSet.getString("nombre"));
                articulo.setDescripcion(resultSet.getString("descripcion"));
                articulo.setPrecioCompra(resultSet.getDouble("p_compra"));
                articulo.setPrecioVenta(resultSet.getDouble("p_venta"));
                articulo.setStock(resultSet.getInt("stock"));
                articulo.setIdCategoria(resultSet.getInt("id_categoria"));
                articulo.setIdImpuesto(resultSet.getInt("id_impuesto"));
            }
            return articulo;
        } catch (SQLException e) {
        }
        
        return articulo;
    }
    
}
