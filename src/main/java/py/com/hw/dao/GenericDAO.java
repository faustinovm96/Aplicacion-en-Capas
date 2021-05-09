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
 * @author Faustino Villasboa Martínez
 */
public interface GenericDAO<T, K> {
    
    public boolean save(T a) throws SQLException;
    public boolean update(T a) throws SQLException;    
    public boolean delete(T a) throws SQLException;
    public List<T> findAll() throws SQLException;    
    public T findById(K b) throws SQLException;
    
}
