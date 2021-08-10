/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.modelo.jdbc;

import java.util.Date;

/**
 *
 * @author F996
 */
public class Venta {
    private Integer id;
    private Date fecha;
    private String serie;
    private String numero;
    private Double subTotal;
    private Double iva;
    private Double descuento;
    private Double total;
    private String formaPago;
    private String estado;
    private Integer idCliente;
    private Integer idTipoDoc;
    private Integer idCaja;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{id=").append(id);
        sb.append(", fecha=").append(fecha);
        sb.append(", serie=").append(serie);
        sb.append(", numero=").append(numero);
        sb.append(", subTotal=").append(subTotal);
        sb.append(", iva=").append(iva);
        sb.append(", descuento=").append(descuento);
        sb.append(", total=").append(total);
        sb.append(", formaPago=").append(formaPago);
        sb.append(", estado=").append(estado);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", idTipoDoc=").append(idTipoDoc);
        sb.append(", idCaja=").append(idCaja);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public Integer getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public Venta(Integer id, Date fecha, String serie, String numero, Double subTotal, Double iva, Double descuento, Double total, String formaPago, String estado, Integer idCliente, Integer idTipoDoc, Integer idCaja) {
        this.id = id;
        this.fecha = fecha;
        this.serie = serie;
        this.numero = numero;
        this.subTotal = subTotal;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
        this.formaPago = formaPago;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idTipoDoc = idTipoDoc;
        this.idCaja = idCaja;
    }

    public Venta() {
    }
}
