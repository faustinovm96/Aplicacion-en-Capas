package py.com.hw.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase de dominio que mapea los datos de la entidad Cliente
 * 
 * @version 1.0
 * @author Faustino Villasboa Martínez
 */
public class Cliente implements Serializable{
    
    private static final Long serialUID = 1L;
   
    private Integer idCliente;
    private String nombreRazonSocial;
    private Direccion direccion;
    private String celular;
    private String email;
    
    public Cliente() {
    }
    
    /**
     * Método que consulta el valor de idCliente
     * @return Retorna el valor del atributo a través del método get consultor* 
     */
    public Integer getIdCliente() {
        return idCliente;
    }
    
    /**
     * Método que asigna valor al atributo idCliente
     * @param idCliente Recibe el valor del atributo a través del método modificador
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Método consultor del atributo nombreRazonSocial
     * @return Retorna el valor del atributo nombreRazonSocial a través del método consultor
     */
    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }
    
    /**
     * Método que asigna valor al atributo nombreRazonSocial
     * @param nombreRazonSocial Recibe el valor del atributo a través del método modificador
     */
    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }
    
    /**
     * Método consultor del atributo direccion
     * @return Retorna el valor del atributo direccion a través del método consultor
     */
    public Direccion getDireccion() {
        return direccion;
    }
    
    /**
     * Método que asigna valor al atributo direccion
     * @param direccion Recibe el valor del atributo a través del método modificador
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Método consultor del atributo celular
     * @return Retorna el valor del atributo celular a través del método consultor
     */
    public String getCelular() {
        return celular;
    }
    
    /**
     * Método que asigna valor al atributo celular
     * @param celular Recibe el valor del atributo a través del método modificador
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", nombreRazonSocial=").append(nombreRazonSocial);
        sb.append(", direccion=").append(direccion);
        sb.append(", celular=").append(celular);
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
        hash = 83 * hash + Objects.hashCode(this.idCliente);
        hash = 83 * hash + Objects.hashCode(this.nombreRazonSocial);
        hash = 83 * hash + Objects.hashCode(this.direccion);
        hash = 83 * hash + Objects.hashCode(this.celular);
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
        if (!Objects.equals(this.nombreRazonSocial, other.nombreRazonSocial)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }


}
