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
import py.com.hw.dao.CategoriaDao;
import py.com.hw.dao.mysql.jdbc.CategoriaDaoMySQLImpl;
import py.com.hw.modelo.jdbc.Categoria;

/**
 *
 * @author F996
 */
public class CategoriaService {
    private CategoriaDao categoriaDao = new CategoriaDaoMySQLImpl();;
    
    public boolean saveCategoria(Categoria categoria){
        try {
            if(categoriaDao.save(categoria) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCategoria(Categoria categoria){
        try {
            if(categoriaDao.update(categoria) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteCategoria(Integer idCategoria){
        try {
            if(categoriaDao.delete(idCategoria) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<Categoria> findAllCategorias(){
        try {
            return categoriaDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Categoria findCategoria(Integer idCategoria){
        try {
            return categoriaDao.findById(idCategoria);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
