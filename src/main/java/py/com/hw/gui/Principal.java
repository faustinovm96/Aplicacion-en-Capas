/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.hw.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino Villasboa Martínez
 */
public class Principal {

    public static void main(String[] args) {
        ClienteFrm formulario = null;
        try {
            formulario = new ClienteFrm();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
    }
}
