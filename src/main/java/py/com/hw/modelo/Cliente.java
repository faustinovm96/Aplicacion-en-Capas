package py.com.hw.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase de dominio que mapea los datos de la entidad Cliente
 * 
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */

public class Cliente implements Serializable{
    
    private static final Long serialUID = 1L;
   
    private Integer id;
    
    private String cedulaRUC;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    public Cliente() {
    }
    
    /**
     * Método que consulta el valor de idCliente
     * @return Retorna el valor del atributo a través del método get consultor* 
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Método que asigna valor al atributo idCliente
     * @param id Recibe el valor del atributo a través del método modificador
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Método consultor del atributo nombreRazonSocial
     * @return Retorna el valor del atributo nombreRazonSocial a través del método consultor
     */
    public String getNombre() {
        return nombre;
    }  
    
    public String getCedulaRUC() {
        return cedulaRUC;
    }

    public void setCedulaRUC(String cedulaRUC) {
        this.cedulaRUC = cedulaRUC;
    }
    
    /**
     * Método que asigna valor al atributo nombreRazonSocial
     * @param nombre Recibe el valor del atributo a través del método modificador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método consultor del atributo direccion
     * @return Retorna el valor del atributo direccion a través del método consultor
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Método que asigna valor al atributo direccion
     * @param direccion Recibe el valor del atributo a través del método modificador
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Método consultor del atributo celular
     * @return Retorna el valor del atributo celular a través del método consultor
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Método que asigna valor al atributo celular
     * @param telefono Recibe el valor del atributo a través del método modificador
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Método consultor del atributo email
     * @return Retorna el valor del atributo email a través del método consultor
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Método que asigna valor al atributo email
     * @param email Recibe el valor del atributo a través del método modificador
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Método de representación en cadena
     * @return Retorna la representación en cadena del objeto
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idCliente=").append(id);
        sb.append(", nombreRazonSocial=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", celular=").append(telefono);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * Método hashCode 
     * @return Retorna el valor hash generado para el objeto dado
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.direccion);
        hash = 83 * hash + Objects.hashCode(this.telefono);
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * Método equals del objeto
     * @param obj Recibe un objeto para realizar una comparación
     * @return Retorna un valor booleano si el objeto coincide con la condición
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }


}
