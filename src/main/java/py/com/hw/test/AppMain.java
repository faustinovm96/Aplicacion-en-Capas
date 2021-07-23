/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.test;

import java.util.Scanner;

/**
 *
 * @author F996
 */
public class AppMain {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String salir = "salir";
        
        do {            
            salir = sc.next();
            System.out.println(salir);
        } while (salir != "salir");
    }
}
