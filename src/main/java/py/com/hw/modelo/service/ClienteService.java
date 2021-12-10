/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.Conexion;
import py.com.hw.dao.mysql.ClienteDaoMySQLImple;
import py.com.hw.modelo.domain.Cliente;

/**
 *
 * @author F996
 */
public class ClienteService {
    private Connection connection = null;
    private ClienteDao clienteDao = null;
    
    public boolean save(Cliente cliente){
        try {
            connection = Conexion.getConnection();
            clienteDao = new ClienteDaoMySQLImple(connection);
            
            if(clienteDao.save(cliente) > 0){
               return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Cliente cliente){
        try {
            connection = Conexion.getConnection();
            clienteDao = new ClienteDaoMySQLImple(connection);
            if(clienteDao.update(cliente) > 0){
                return true;
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Integer idCliente){
        try {
            connection = Conexion.getConnection();
            clienteDao = new ClienteDaoMySQLImple(connection);
            if(clienteDao.delete(idCliente) > 0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Cliente findCliente(int idCliente){
        try {
            connection = Conexion.getConnection();
            clienteDao = new ClienteDaoMySQLImple(connection);
            return clienteDao.findById(idCliente);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Cliente> findAll(){
        try {
            connection = Conexion.getConnection();
            clienteDao = new ClienteDaoMySQLImple(connection);
            return clienteDao.findAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
