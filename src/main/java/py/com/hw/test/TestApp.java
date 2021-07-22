/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import py.com.hw.modelo.jdbc.Cliente;
import py.com.hw.service.ClienteService;

/**
 *
 * @author F996
 */
public class TestApp {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Faustino Villasboa Martínez");
        cliente.setCedulaRUC("5540983");
        cliente.setDireccion("Km 42");
        cliente.setTelefono("0971868761");
        cliente.setEmail("fvillasboa96@gmail.com");
        
        ClienteService servicio = new ClienteService();
        
        if(servicio.save(cliente)){
            System.out.println("Cliente Registrado");
        }else{
            System.out.println("Cliente no Registrado (ERROR)");
        }
        
    }
}
