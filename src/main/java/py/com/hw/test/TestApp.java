/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import py.com.hw.modelo.domain.Cliente;
import py.com.hw.modelo.service.ClienteService;

/**
 *
 * @author F996
 */
public class TestApp {
    public static void main(String[] args) {
//        Cliente cliente = new Cliente();
//        cliente.setNombre("Luis Torres");
//        cliente.setCedulaRUC("7485693");
//        cliente.setDireccion("Km 42");
//        cliente.setTelefono("0992145639");
//        cliente.setEmail("luistarma7@gmail.com");
        
        ClienteService servicio = new ClienteService();
        System.out.println(servicio.findAll());
        
//        if(servicio.save(cliente)){
//            System.out.println("Cliente Registrado");
//        }else{
//            System.out.println("Cliente no Registrado (ERROR)");
//        }
        
    }
}
