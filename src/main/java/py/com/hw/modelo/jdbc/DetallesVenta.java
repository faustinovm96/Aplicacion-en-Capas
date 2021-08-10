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
public class DetallesVenta {
    private Integer idVenta;
    private Integer idArticulo;
    private Integer cantidad;
    private Double precioUnitario;
    private Double precioTotal;

    public DetallesVenta() {
    }

    public DetallesVenta(Integer idVenta, Integer idArticulo, Integer cantidad, Double precioUnitario, Double precioTotal) {
        this.idVenta = idVenta;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetallesVenta{idVenta=").append(idVenta);
        sb.append(", idArticulo=").append(idArticulo);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precioUnitario=").append(precioUnitario);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append('}');
        return sb.toString();
    }
    
}
