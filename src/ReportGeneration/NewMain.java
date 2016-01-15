/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportGeneration;

import javax.swing.JFrame;

/**
 *
 * @author Wilma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        JFrame v = new JFrame ("t");
        v.setSize(500, 500);
        GenerateReport x = new GenerateReport();
        v.add(x);
        x.show();
        v.show();
    }
    
}
