/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author F996
 */
public interface GenericDAO<T,K> {
    public int save(T g) throws SQLException;
    public int update(T g) throws SQLException;    
    public int delete(Integer g) throws SQLException;
    public List<T> findAll() throws SQLException;    
    public T findById(Integer g) throws SQLException;
}
