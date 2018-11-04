/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_soa;

import algoritmos.Sjf;
import cpu.Escalonador;
import cpu.Processador;
import java.util.LinkedList;
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
        
        LinkedList<Escalonador> listaAlg = new LinkedList<>();
        
        listaAlg.add(sjf);
        
        Processador p = new Processador(listaAlg);

        p.processar();
        
        for (BCP processo : p.getOrdemExecutados()){
            processo.printProcesso();
            //System.out.println("-------");
        }
        
    }
    
}
