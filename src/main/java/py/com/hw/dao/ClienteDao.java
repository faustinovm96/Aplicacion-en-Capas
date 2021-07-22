/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.jdbc.Cliente;

/**
 *
 * @author Faustino Villasboa Martínez
 * Cambiar esta implementación por ahora
 */
public interface ClienteDao{
    public int save(Cliente a) throws SQLException;
    public int update(Cliente cliente) throws SQLException;    
    public int delete(Integer idCliente) throws SQLException;
    public List<Cliente> findAll() throws SQLException;    
    public Cliente findById(Integer idCliente) throws SQLException;
}
