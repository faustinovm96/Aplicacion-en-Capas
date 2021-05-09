/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao.util;

/**
 *
 * @author F996
 */
public class CRUDConstants {

    /**Datos de Conexión a la DB*/
    public static final String URL = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "holamundo96";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /**SQL
     *Queries SQL para la tabla direcciones*/
    public static final String INSERT_DIRECCION = "INSERT INTO direccion (callePrincipal, calleTransversal, barrioComp, nroCasa) VALUES (?,?,?,?)";
    public static final String UPDATE_DIRECCION = "UPDATE direccion SET callePrincipal=?, calleTransversal=?, barrioComp=?, nroCasa=? WHERE idDireccion=?";
    public static final String SELECT_DIRECCION = "SELECT * FROM direccion WHERE idDireccion = ?";
    public static final String SELECT_NRS_DIRECCION = "SELECT * FROM direccion WHERE nroCasa = ?";
    public static final String SELECT_ALL_DIRECCION = "SELECT * FROM direccion";
    public static final String DELETE_DIRECCION = "DELETE FROM direccion WHERE idDireccion = ?";

    /**Queries SQL para la tabla clientes**/
    public static final String INSERT_CLIENTE = "INSERT INTO cliente (nombreRazonSocial, idDireccion, celular, email) VALUES (?,?,?,?)";
    public static final String UPDATE_CLIENTE = "UPDATE cliente SET nombreRazonSocial=?, celular=?, email=? WHERE idCliente=?";
    public static final String DELETE_CLIENTE = "DELETE FROM cliente WHERE idCliente=?";
    public static final String SELECT_CLIENTE = "SELECT * FROM cliente WHERE idCliente=?";
    public static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente";
}
