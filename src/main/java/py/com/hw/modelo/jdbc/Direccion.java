/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo.jdbc;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase de dominio que mapea la entidad Dirección
 *
 * @version 1.0
 * @author F996
 */
public class Direccion implements Serializable {

    private static final Long serialUID = 1L;

    private int idDireccion;
    private String callePrincipal;
    private String calleTransversal;
    private String barrioComp;
    private int nroCasa;

    /**
     * Constructor vacío de la clase Dirección
     */
    public Direccion() {
    }

    /**
     * Método para consultar el atributo idDirección
     * @return Retorna el valor del atributo idDirección
     */
    public int getIdDireccion() {
        return idDireccion;
    }
    
    /**
     * Método modificador del atributo idDireccion
     * @param idDireccion Recibe el valor del atributo a través del modificador 
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
        /**
     * Método para consultar el atributo callePrincipal
     * @return Retorna el valor del atributo callePrincipal
     */
    public String getCallePrincipal() {
        return callePrincipal;
    }

    /**
     * Método modificador del atributo callePrincipal
     * @param callePrincipal Recibe el valor del atributo a través del modificador 
     */
    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

        /**
     * Método para consultar el atributo calleTransversal
     * @return Retorna el valor del atributo calleTransversal
     */
    public String getCalleTransversal() {
        return calleTransversal;
    }

    /**
     * Método modificador del atributo calleTransversal
     * @param calleTransversal Recibe el valor del atributo a través del modificador 
     */
    public void setCalleTransversal(String calleTransversal) {
        this.calleTransversal = calleTransversal;
    }

        /**
     * Método para consultar el atributo barrioComp
     * @return Retorna el valor del atributo barrioComp
     */
    public String getBarrioComp() {
        return barrioComp;
    }

    /**
     * Método modificador del atributo barrioComp
     * @param barrioComp Recibe el valor del atributo a través del modificador 
     */
    public void setBarrioComp(String barrioComp) {
        this.barrioComp = barrioComp;
    }
    
        /**
     * Método para consultar el atributo nroCasa
     * @return Retorna el valor del atributo nroCasa
     */
    public int getNroCasa() {
        return nroCasa;
    }
    
    /**
     * Método modificador del atributo nroCasa
     * @param nroCasa Recibe el valor del atributo a través del modificador 
     */
    public void setNroCasa(int nroCasa) {
        this.nroCasa = nroCasa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Direccion{idDireccion=").append(idDireccion);
        sb.append(", callePrincipal=").append(callePrincipal);
        sb.append(", calleTransversal=").append(calleTransversal);
        sb.append(", barrioComp=").append(barrioComp);
        sb.append(", nroCasa=").append(nroCasa);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.idDireccion;
        hash = 11 * hash + Objects.hashCode(this.callePrincipal);
        hash = 11 * hash + Objects.hashCode(this.calleTransversal);
        hash = 11 * hash + Objects.hashCode(this.barrioComp);
        hash = 11 * hash + this.nroCasa;
        return hash;
    }

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
        final Direccion other = (Direccion) obj;
        if (this.idDireccion != other.idDireccion) {
            return false;
        }
        if (this.nroCasa != other.nroCasa) {
            return false;
        }
        if (!Objects.equals(this.callePrincipal, other.callePrincipal)) {
            return false;
        }
        if (!Objects.equals(this.calleTransversal, other.calleTransversal)) {
            return false;
        }
        if (!Objects.equals(this.barrioComp, other.barrioComp)) {
            return false;
        }
        return true;
    }

}
