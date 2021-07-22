package py.com.hw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py.com.hw.dao.util.CRUDConstants;

/**
 * Clase de conexión a la base de datos
 *
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class Conexion {

    private static Conexion instance;
    private Connection connection;
    
    private Conexion() throws SQLException {
        try {
            Class.forName(CRUDConstants.DRIVER);
            this.connection = DriverManager.getConnection(CRUDConstants.URL, CRUDConstants.USERNAME, CRUDConstants.PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema Ocurrido : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Conexion getInstance() throws SQLException {
        if (instance == null) {
            System.out.println("Pasa Por AQUI SINGLETON");
            instance = new Conexion();
        } else if (instance.getConnection().isClosed()) {
            instance = new Conexion();
        }
        return instance;
    }
}
