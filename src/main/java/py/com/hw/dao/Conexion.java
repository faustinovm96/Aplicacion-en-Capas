package py.com.hw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Clase de conexión a la base de datos
 *
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class Conexion {

//    private static Conexion instance;
//    private Connection connection;
//    
//    private Conexion() throws SQLException {
//        jdbcConnection();
//    }
//
//    private void jdbcConnection() throws SQLException {
//        try {
//            Class.forName(SystemConstants.DRIVER);
//            this.connection = DriverManager.getConnection(SystemConstants.URL, SystemConstants.USERNAME, SystemConstants.PASSWORD);
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Problema Ocurrido : " + ex.getMessage());
//        }
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public static Conexion getInstance() throws SQLException {
//        if (instance == null) {
//            System.out.println("Pasa Por AQUI SINGLETON");
//            instance = new Conexion();
//        } else if (instance.getConnection().isClosed()) {
//            instance = new Conexion();
//        }
//        return instance;
//    }
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fact?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
