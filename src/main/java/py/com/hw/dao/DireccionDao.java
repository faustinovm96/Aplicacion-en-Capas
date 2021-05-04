
package py.com.hw.dao;

import java.sql.SQLException;
import java.util.List;
import py.com.hw.modelo.Direccion;

/**
 * Interfaz que declara los métodos CRUD
 * @author Faustino Villasboa Martínez
 * @version 1.0
 */
public interface DireccionDao extends GenericDAO<Direccion, Integer>{
    public Direccion findByNroCasa(Integer nroCasa) throws SQLException;
}
