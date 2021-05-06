/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py.com.hw.dao.ClienteDao;
import py.com.hw.dao.DireccionDao;
import py.com.hw.dao.mysql.jdbc.ClienteDaoMySQLImple;
import py.com.hw.dao.mysql.jdbc.DireccionDaoMySQLImple;
import py.com.hw.dao.util.Conexion;
import py.com.hw.gui.ClienteFrm;
import py.com.hw.modelo.Cliente;
import py.com.hw.modelo.Direccion;

/**
 *
 * @author Faustino Villasboa Martínez
 */
public class TestConexion {

    private static final Logger logger = LogManager.getLogger(TestConexion.class);

    public static void main(String[] args) throws SQLException {
        /*ClienteFrm formulario = new ClienteFrm();
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
        logger.trace("Log level trace");
        logger.debug("Log level debug");
        /*
            Direccion direccion = new Direccion();     
         */
 /*           System.out.println("Crear objeto direccion");
            Direccion direccion = new Direccion();
            direccion.setCallePrincipal("San Carlos");
            direccion.setCalleTransversal("Necopusemo");
            direccion.setBarrioComp("Las Piedras");
            direccion.setNroCasa(400);
            
            System.out.println("Crear objeto DAO");
            DireccionDao testDireccionDao = new DireccionDaoMySQLImple();
            
            boolean valor = testDireccionDao.save(direccion);
            
            System.out.println("Valor Devuelto: "+ valor);*/

        //System.out.println("Filas Afectadas: " + testDireccionDao.delete(direccion));
        /*
            List<Direccion> lista = new ArrayList<>();
            
            lista = testDireccionDao.findAll();
            
            for(Direccion d: lista){
            System.out.println(d.getCallePrincipal());
            }*/
 /*        System.out.println("Recuperado:" + testDireccionDao.findDireccionById(1));*/
        //int filas = testDireccionDao.save(direccion);
        //System.out.println("Final del programa, filas afectadas: "+ filas);
        /*
          
            
            DireccionDao direccionDao = new DireccionDaoMySQLImple();
            direccionDao.save(direccion);
            
            Direccion direccion1 = new Direccion();
            direccion1 = direccionDao.findByNroCasa(direccion.getNroCasa());
            
            
            
            
            ClienteDao cliClienteDao = new ClienteDaoMySQLImple();
            cliClienteDao.save(c);
            
            System.out.println("FINAL DEL PROGRAMA");*/
 /*           
            Direccion direccion1 = new Direccion();
            
            DireccionDao testDireccionDao = new DireccionDaoMySQLImple();
            
            testDireccionDao.save(direccion);
            
            direccion1 = testDireccionDao.findById(new Integer(13));
            
            direccion1.setBarrioComp("Tape Tuya");
            
            testDireccionDao.update(direccion1);
               
            System.out.println("Objeto Recuperado: "+ direccion1);*/
 /*
            direccion.setCallePrincipal("San Juan Bautista Necopuseno");
            
            testDireccionDao.update(direccion);
            
            direccion = testDireccionDao.findById(new Integer(13));
            
            System.out.println("Objeto Recuperado: "+ direccion);*/
        Direccion direccion = new Direccion();
        direccion.setCallePrincipal("Avda Principal");
        direccion.setCalleTransversal("Ita Potrero");
//        direccion.setBarrioComp("Barrio Nueva Esperanza");
        direccion.setNroCasa(40);
        
        Cliente c = new Cliente();
        c.setNombreRazonSocial("Mercedes Ropas");
        c.setDireccion(direccion);
        c.setCelular("0972458963");
        c.setEmail("mercedesmerceria@gmail.com");
        
        ClienteDao clienteDao = new ClienteDaoMySQLImple();
        clienteDao.save(c);
        
        System.out.println("FINAL DEL PROGRAMA");
    }
}
