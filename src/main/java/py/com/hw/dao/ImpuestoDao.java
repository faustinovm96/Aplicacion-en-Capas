/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.jdbc.Impuesto;

/**
 *
 * @author F996
 */
public interface ImpuestoDao {
    public int save(Impuesto impuesto) throws SQLException;
    public int update(Impuesto impuesto) throws SQLException;    
    public int delete(Integer idImpuesto) throws SQLException;
    public List<Impuesto> findAll() throws SQLException;    
    public Impuesto findById(Integer idImpuesto) throws SQLException;
}
