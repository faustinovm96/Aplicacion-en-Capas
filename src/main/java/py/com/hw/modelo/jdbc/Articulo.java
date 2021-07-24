/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo.jdbc;

/**
 *
 * @author F996
 */
public class Articulo {
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioCompra;
    private Double precioVenta;
    private Integer stock;
    private int idCategoria;
    private int idImpuesto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public Articulo() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Articulo{id=").append(id);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precioCompra=").append(precioCompra);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append(", stock=").append(stock);
        sb.append(", idCategoria=").append(idCategoria);
        sb.append(", idImpuesto=").append(idImpuesto);
        sb.append('}');
        return sb.toString();
    }
    
}
