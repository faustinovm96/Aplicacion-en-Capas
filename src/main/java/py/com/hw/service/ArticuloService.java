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
import py.com.hw.dao.ArticuloDao;
import py.com.hw.dao.mysql.jdbc.ArticuloDaoMySQLImpl;
import py.com.hw.modelo.jdbc.Articulo;

/**
 *
 * @author F996
 */
public class ArticuloService {
    private ArticuloDao articuloDao = new ArticuloDaoMySQLImpl();;
    
    public boolean saveArticulo(Articulo articulo){
        try {
            if(articuloDao.save(articulo) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateArticulo(Articulo articulo){
        try {
            if(articuloDao.update(articulo) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteArticulo(Integer idArticulo){
        try {
            if(articuloDao.delete(idArticulo) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<Articulo> findAllCategorias(){
        try {
            return articuloDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Articulo findCategoria(Integer idArticulo){
        try {
            return articuloDao.findById(idArticulo);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
