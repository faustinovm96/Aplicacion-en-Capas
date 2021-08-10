/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.jdbc.Caja;

/**
 *
 * @author F996
 */
public interface CajaDao {
    public int save(Caja caja) throws SQLException;
    public int update(Caja caja) throws SQLException;    
    public int delete(Integer idCaja) throws SQLException;
    public List<Caja> findAll() throws SQLException;    
    public Caja findById(Integer idCaja) throws SQLException;  
}
