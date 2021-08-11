/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo;

/**
 *
 * @author F996
 */
public class Caja {
    private Integer id;
    private String nombre;
    private Boolean estado;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caja{id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Caja(Integer id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Caja() {
    }
}
