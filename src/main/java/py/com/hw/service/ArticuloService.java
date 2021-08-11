/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.com.hw.dao.ArticuloDao;
import py.com.hw.dao.Conexion;
import py.com.hw.dao.mysql.ArticuloDaoMySQLImpl;
import py.com.hw.modelo.Articulo;

/**
 *
 * @author F996
 */
public class ArticuloService {
    private Connection connection;
    private ArticuloDao articuloDao = null;
    
    public boolean saveArticulo(Articulo articulo){
        try {
            connection = Conexion.getConnection();
            articuloDao = new ArticuloDaoMySQLImpl();
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
            connection = Conexion.getConnection();
            articuloDao = new ArticuloDaoMySQLImpl();
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
            connection = Conexion.getConnection();
            articuloDao = new ArticuloDaoMySQLImpl();
            if(articuloDao.delete(idArticulo) > 0){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<Articulo> findAllArticulos(){
        try {
            connection = Conexion.getConnection();
            articuloDao = new ArticuloDaoMySQLImpl();
            return articuloDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Articulo findArticulo(Integer idArticulo){
        try {
            connection = Conexion.getConnection();
            articuloDao = new ArticuloDaoMySQLImpl();
            return articuloDao.findById(idArticulo);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
