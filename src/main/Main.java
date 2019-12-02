/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import forms.Frm_main;
import forms.Frm_pesquisa;
import javax.swing.SwingUtilities;

/**
 *
 * @author alex
 */
public class Main {

    public static void main(String[] args) {

        //chamada assíncrona para a janela principal por uma expressão lambda
        java.awt.EventQueue.invokeLater(() -> {
            Frm_main frm_run = new Frm_main();
            frm_run.setLocationRelativeTo(null);
            frm_run.setVisible(true);
        });
        
//        java.awt.EventQueue.invokeLater(() -> {
//            Frm_pesquisa frm_run = new Frm_pesquisa();
//            frm_run.setLocationRelativeTo(null);
//            frm_run.setVisible(true);
//        });
        
        System.out.println("Main OK!");
    }

}
