/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.dao.util;

/**
 *
 * @author Faustino Villasboa Martínez
 */
public class SystemConstants {

    /**Datos de Conexión a la DB*/
    public static final String URL = "jdbc:mysql://localhost/test_1?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "holamundo96";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**Queries SQL para la tabla clientes**/
    public static final String INSERT_CLIENTE = "INSERT INTO clientes (cedularuc, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
    public static final String UPDATE_CLIENTE = "UPDATE clientes SET cedularuc=?, nombre=?, direccion=?, telefono=?, email=? WHERE id=?";
    public static final String DELETE_CLIENTE = "DELETE FROM clientes WHERE id=?";
    public static final String FIND_CLIENTE = "SELECT * FROM clientes WHERE id=?";
    public static final String FINDALL_CLIENTES = "SELECT * FROM clientes";
    
    /**Queries SQL para la tabla categorias**/
    public static final String INSERT_CATEGORIA = "INSERT INTO categorias (categoria, descripcion) VALUES (?,?)";
    public static final String UPDATE_CATEGORIA = "UPDATE categorias SET categoria=?, descripcion=? WHERE id=?";
    public static final String DELETE_CATEGORIA = "DELETE FROM categorias WHERE id=?";
    public static final String FIND_CATEGORIA = "SELECT * FROM categorias WHERE id=?";
    public static final String FINDALL_CATEGORIA = "SELECT * FROM categorias";
    
}
