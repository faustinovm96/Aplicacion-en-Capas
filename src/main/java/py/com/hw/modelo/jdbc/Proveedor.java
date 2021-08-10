/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo.jdbc;

import java.io.Serializable;

/**
 *
 * @author F996
 */
public class Proveedor implements Serializable{
    private Integer id;
    private String ruc;
    private String proveedor;
    private String tipoEmpresa;
    private String direccion;
    private String telefono;
    private String email;

    public Proveedor() {
    }

    public Proveedor(Integer id, String ruc, String proveedor, String tipoEmpresa, String direccion, String telefono, String email) {
        this.id = id;
        this.ruc = ruc;
        this.proveedor = proveedor;
        this.tipoEmpresa = tipoEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor{id=").append(id);
        sb.append(", ruc=").append(ruc);
        sb.append(", proveedor=").append(proveedor);
        sb.append(", tipoEmpresa=").append(tipoEmpresa);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
    
}
