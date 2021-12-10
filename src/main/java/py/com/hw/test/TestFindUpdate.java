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
public class TestFindUpdate {
    public static void main(String[] args) {
        
        ClienteService servicio = new ClienteService();
        
        Cliente clienteRecuperado = servicio.findCliente(8);
        
        if(clienteRecuperado != null){
            clienteRecuperado.setNombre("Faustino Villasboa");
            clienteRecuperado.setCedulaRUC("5540983");
            if(servicio.update(clienteRecuperado)){
                System.out.println("Cliente Actualizado...");
            }
        }else{
            System.out.println("Cliente no Actualizado (ERROR)");
        }
        
    }
}
