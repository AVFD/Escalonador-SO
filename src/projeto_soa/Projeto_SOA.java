/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_soa;

import algoritmos.Sjf;
import processo.BCP;

/**
 *
 * @author guilherme
 */
public class Projeto_SOA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        Sjf sjf = new Sjf();
        sjf.escalonar();
        
        for (BCP p : sjf.getListaProcessos()){
            p.printProcesso();
            System.out.println("-------");
        }
        
        
        
    }
    
}
