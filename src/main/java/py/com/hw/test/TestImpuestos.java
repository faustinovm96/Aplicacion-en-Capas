/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import py.com.hw.dao.ImpuestoDao;
import py.com.hw.modelo.jdbc.Impuesto;
import py.com.hw.service.ImpuestoService;

/**
 *
 * @author F996
 */
public class TestImpuestos {
    public static void main(String[] args) {
//        Impuesto imp = new Impuesto();
//        imp.setDescripcion("IVA GENERAL");
//        imp.setValor(10.0);
//        ImpuestoService impDao = new ImpuestoService();
//        if(impDao.saveImpuesto(imp)) System.out.println("Registro Exitoso");
//        Impuesto imp = null;
//        
//        ImpuestoService impDao = new ImpuestoService();
//        imp = impDao.findImpuesto(1);
//        imp.setDescripcion("IVA REDUCIDO");
//        imp.setValor(9.0);
//        
//        if(impDao.updateImpuesto(imp)) System.out.println("Registro Actualizado");
          ImpuestoService impDao = new ImpuestoService();
        
//          System.out.println("Lista: " + impDao.findAllImpuestos
          if(impDao.deleteImpuesto(1)) System.out.println("Registro Eliminado"); 
    }
}
