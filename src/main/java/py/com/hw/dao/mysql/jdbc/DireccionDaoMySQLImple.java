
package py.com.hw.dao.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.com.hw.dao.DireccionDao;
import py.com.hw.dao.util.Conexion;
import py.com.hw.modelo.Direccion;

/**
 * Clase que implementa la Interfaz DireccionDao
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class DireccionDaoMySQLImple implements DireccionDao{
        
    private static final String INSERT_DIRECCION = "INSERT INTO direccion (callePrincipal, calleTransversal, barrioComp, nroCasa) VALUES (?,?,?,?)";
    private static final String UPDATE_DIRECCION = "UPDATE direccion SET callePrincipal=?, calleTransversal=?, barrioComp=?, nroCasa=? WHERE idDireccion=?";
    private static final String SELECT_DIRECCION = "SELECT * FROM direccion WHERE idDireccion = ?";  
    private static final String SELECT_NRS_DIRECCION = "SELECT * FROM direccion WHERE nroCasa = ?";  
    private static final String SELECT_ALL_DIRECCION = "SELECT * FROM direccion";
    private static final String DELETE_DIRECCION = "DELETE FROM direccion WHERE idDireccion = ?";
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean estado;
    
    @Override
    public boolean save(Direccion direccion) throws SQLException{
        estado = false;
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_DIRECCION);
            preparedStatement.setString(1, direccion.getCallePrincipal());
            preparedStatement.setString(2, direccion.getCalleTransversal());
            preparedStatement.setString(3, direccion.getBarrioComp());
            preparedStatement.setInt(4, direccion.getNroCasa());
            
            System.out.println("Pasa Por INSERT");
            estado = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_DIRECCION);
            preparedStatement.setString(1, direccion.getCallePrincipal());
            preparedStatement.setString(2, direccion.getCalleTransversal());
            preparedStatement.setString(3, direccion.getBarrioComp());
            preparedStatement.setInt(4, direccion.getNroCasa());
            preparedStatement.setInt(5, direccion.getIdDireccion());
            System.out.println("PASA POR UPDATE");
            estado  = preparedStatement.executeUpdate() > 0;
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
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_DIRECCION);
            preparedStatement.setInt(1, direccion.getIdDireccion());
            
            estado = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            preparedStatement.close();
        }
        
        return estado;
    }

    @Override
    public List<Direccion> findAll() throws SQLException{
        estado = false;
        List<Direccion> listaDirecciones = new ArrayList<Direccion>();
                
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_DIRECCION);
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
        Direccion direccion = null;
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareCall(SELECT_DIRECCION);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
           preparedStatement.close();
        }
        
        return direccion;
    }
    
    public Direccion findByNroCasa(Integer nroCasa) throws SQLException {
        Direccion direccion = null;
        
        try {
            connection = Conexion.getInstance().getConnection();
            preparedStatement = connection.prepareCall(SELECT_NRS_DIRECCION);
            preparedStatement.setInt(1, nroCasa);           
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                String calleP = resultSet.getString("callePrincipal");
                String calleT = resultSet.getString("calleTransversal");
                String barrio = resultSet.getString("barrioComp");
                int nro = resultSet.getInt("nroCasa");
                int idDireccion = resultSet.getInt("idDireccion");
                
                direccion = new Direccion();
                direccion.setIdDireccion(idDireccion);
                direccion.setCallePrincipal(calleP);
                direccion.setCalleTransversal(calleT);
                direccion.setBarrioComp(barrio);
                direccion.setIdDireccion(resultSet.getInt("idDireccion"));
            }      
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
           preparedStatement.close();
        }
        
        return direccion;
    }
}
