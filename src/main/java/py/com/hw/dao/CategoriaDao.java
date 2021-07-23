/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.jdbc.Categoria;

/**
 *
 * @author F996
 */
public interface CategoriaDao {
    public int save(Categoria categoria) throws SQLException;
    public int update(Categoria categoria) throws SQLException;    
    public int delete(Integer idCategoria) throws SQLException;
    public List<Categoria> findAll() throws SQLException;    
    public Categoria findById(Integer idCategoria) throws SQLException;
}
