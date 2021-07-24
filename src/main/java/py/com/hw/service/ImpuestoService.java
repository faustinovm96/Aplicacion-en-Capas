/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.com.hw.dao.ImpuestoDao;
import py.com.hw.dao.mysql.jdbc.ImpuestoDaoMySQLImpl;
import py.com.hw.modelo.jdbc.Impuesto;

/**
 *
 * @author F996
 */
public class ImpuestoService {
    private ImpuestoDao impuestoDao = new ImpuestoDaoMySQLImpl();;
    
    public boolean saveImpuesto(Impuesto impuesto){
        try {
            if(impuestoDao.save(impuesto) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateImpuesto(Impuesto impuesto){
        try {
            if(impuestoDao.update(impuesto) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteImpuesto(Integer idImpuesto){
        try {
            if(impuestoDao.delete(idImpuesto) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<Impuesto> findAllImpuestos(){
        try {
            return impuestoDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Impuesto findImpuesto(Integer idImpuesto){
        try {
            return impuestoDao.findById(idImpuesto);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
