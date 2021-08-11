/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import py.com.hw.modelo.Categoria;
import py.com.hw.service.CategoriaService;

/**
 *
 * @author F996
 */
public class TestCategorias {
    public static void main(String[] args) {
        Categoria cat = new Categoria();
        cat.setCategoria("TINTAS");
        cat.setDescripcion("Tintas para impresoras");
//        
        CategoriaService catService = new CategoriaService();
        if(catService.saveCategoria(cat)) System.out.println("Registro Exitoso");
//        cat = catService.findCategoria(2);
//        cat.setDescripcion("TINTA PARA IMPRESORAS Y SUBLIMADORAS");
//        
//        if(catService.updateCategoria(cat)){
//            System.out.println("Cambios Guardados Correctamente");
//        }else{
//            System.out.println("ERROR");
//        }
//        if(catService.saveCategoria(cat)) System.out.println("Registro Exitoso");

//          System.out.println("Lista"+ catService.findAllCategorias());");
    }
}
