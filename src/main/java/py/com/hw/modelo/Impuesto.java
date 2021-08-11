/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo;

import java.io.Serializable;

/**
 *
 * @author F996
 */
public class Impuesto implements Serializable {
    private int id;
    private String descripcion;
    private Double valor;

    public Impuesto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Impuesto{id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
    
}
