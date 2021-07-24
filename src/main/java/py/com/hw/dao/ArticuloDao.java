/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.jdbc.Articulo;

/**
 *
 * @author F996
 */
public interface ArticuloDao {
    public int save(Articulo articulo) throws SQLException;
    public int update(Articulo articulo) throws SQLException;    
    public int delete(Integer idArticulo) throws SQLException;
    public List<Articulo> findAll() throws SQLException;    
    public Articulo findById(Integer idArticulo) throws SQLException;    
}
