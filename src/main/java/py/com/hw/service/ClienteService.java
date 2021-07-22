/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.mysql.jdbc.ClienteDaoMySQLImple;
import py.com.hw.modelo.jdbc.Cliente;

/**
 *
 * @author F996
 */
public class ClienteService {
    
    private ClienteDao clienteDao = new ClienteDaoMySQLImple();
    
    public boolean save(Cliente cliente){
        try {
            if(clienteDao.save(cliente) > 0){
               return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Cliente findCliente(int idCliente){
        try {
            return clienteDao.findById(idCliente);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Cliente cliente){
        try {
            if(clienteDao.update(cliente) > 0){
                return true;
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
