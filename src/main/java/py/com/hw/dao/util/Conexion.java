package py.com.hw.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase de conexión a la base de datos
 *
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class Conexion {

    private static Conexion instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "holamundo96";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Conexion() throws SQLException {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
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
