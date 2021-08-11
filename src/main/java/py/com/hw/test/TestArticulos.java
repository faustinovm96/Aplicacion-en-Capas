/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import py.com.hw.modelo.Articulo;
import py.com.hw.service.ArticuloService;

/**
 *
 * @author F996
 */
public class TestArticulos {
    public static void main(String[] args) {
//        Articulo articulo = new Articulo();
//        articulo.setCodigo("123456");
//        articulo.setNombre("Tinta XXL");
//        articulo.setDescripcion("TINTA para impresoras HP");
//        articulo.setPrecioCompra(new Double("120000"));
//        articulo.setPrecioVenta(new Double("130000"));
//        articulo.setStock(100);
//        articulo.setIdCategoria(3);
//        articulo.setIdImpuesto(2);
//        
//        ArticuloService service = new ArticuloService();
//        if(service.saveArticulo(articulo)) System.out.println("Articulo Registrado");
        ArticuloService service = new ArticuloService();        
////        System.out.println("Lista: " + service.findAllCategorias());
//        Articulo articulo = service.findCategoria(1);
//        articulo.setStock(150);
//  
//        if(service.updateArticulo(articulo)) System.out.println("Articulo Cambiado");
        if(service.deleteArticulo(1)) System.out.println("Articulo Eliminado");
    }
}
