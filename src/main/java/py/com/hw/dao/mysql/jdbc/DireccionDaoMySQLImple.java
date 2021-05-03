
package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py.com.hw.dao.DireccionDao;
import py.com.hw.dao.util.Conexion;
import py.com.hw.modelo.Direccion;

/**
 * Clase de Acceso a datos que implementa los métodos declarados en la Interfaz DireccionDao
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class DireccionDaoMySQLImple implements DireccionDao{
    
    private static final Logger logger = LogManager.getLogger(DireccionDaoMySQLImple.class);
    
    private static final String INSERT = "INSERT INTO direccion (callePrincipal, calleTransversal, barrioComp, nroCasa) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE direccion SET callePrincipal=?, calleTransversal=?, barrioComp=?, nroCasa=? WHERE idDireccion=?";
    private static final String SELECT = "SELECT * FROM direccion WHERE idDireccion = ?";    
    private static final String SELECT_ALL = "SELECT * FROM direccion";
    private static final String DELETE = "DELETE FROM direccion WHERE idDireccion = ?";
    
    private Connection connection = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean estado;
    
    @Override
    public boolean save(Direccion direccion) throws SQLException{
        estado = false;
        //connection = Conexion.getConnection();      
        
        try {
           //connection.setAutoCommit(false);
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, direccion.getCallePrincipal());
            preparedStatement.setString(2, direccion.getCalleTransversal());
            preparedStatement.setString(3, direccion.getBarrioComp());
            preparedStatement.setInt(4, direccion.getNroCasa());
            
            System.out.println("Pasa Por INSERT");
            estado = preparedStatement.executeUpdate() > 0;
            //connection.getAutoCommit();
            //connection.commit();         
        } catch (SQLException e) {
            e.printStackTrace();
            //connection.rollback();
            //logger.fatal("Yupii");
        } finally{
            preparedStatement.close();
            connection.close();
            System.out.println("Conexion Cerrada SAVE");
        }
        return estado;
    }

    @Override
    public boolean update(Direccion direccion) throws SQLException{
        estado = false;
        //connection = Conexion.getConnection();
        
        try {
            connection.setAutoCommit(false);
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, direccion.getCallePrincipal());
            preparedStatement.setString(2, direccion.getCalleTransversal());
            preparedStatement.setString(3, direccion.getBarrioComp());
            preparedStatement.setInt(4, direccion.getNroCasa());
            preparedStatement.setInt(5, direccion.getIdDireccion());
            System.out.println("PASA POR UPDATE");
            estado  = preparedStatement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally{
            preparedStatement.close();
            //Conexion.close(connection);
            connection.close();
            System.out.println("Conexion Cerrada UPDATE");
        }
        
        return estado;
    }

    @Override
    public boolean delete(Direccion direccion) throws SQLException{
        estado = false;
        //connection = Conexion.getConnection();
        
        try {
            //connection.setAutoCommit(false);
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, direccion.getIdDireccion());
            
            estado = preparedStatement.executeUpdate() > 0;
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //connection.rollback();
        } finally{
            preparedStatement.close();
        }
        
        return estado;
    }

    @Override
    public List<Direccion> findAll() throws SQLException{
        estado = false;
       connection = Conexion.getInstance().getConnection();
        List<Direccion> listaDirecciones = new ArrayList<Direccion>();
                
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                Direccion direccion = new Direccion();
                direccion.setCallePrincipal(resultSet.getString("callePrincipal"));
                direccion.setCalleTransversal(resultSet.getString("calleTransversal"));
                direccion.setBarrioComp(resultSet.getString("barrioComp"));
                direccion.setNroCasa(resultSet.getInt("nroCasa"));
                
                listaDirecciones.add(direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
           preparedStatement.close();
        }
        
        return listaDirecciones;
    }

    @Override
    public Direccion findById(Integer idDireccion) throws SQLException {
        connection = Conexion.getInstance().getConnection();
        Direccion direccion = null;
        
        try {
            //connection = Conexion.getConnection();
            preparedStatement = connection.prepareCall(SELECT);
            preparedStatement.setInt(1, idDireccion);           
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                String calleP = resultSet.getString("callePrincipal");
                String calleT = resultSet.getString("calleTransversal");
                String barrio = resultSet.getString("barrioComp");
                int nro = resultSet.getInt("nroCasa");
                
                direccion = new Direccion();
                direccion.setCallePrincipal(calleP);
                direccion.setCalleTransversal(calleT);
                direccion.setBarrioComp(barrio);
                direccion.setIdDireccion(resultSet.getInt("idDireccion"));
            }      
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
           preparedStatement.close();
        }
        
        return direccion;
    }
    
}
