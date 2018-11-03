/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_soa;

import leituraArquivo.lerAlgoritmos;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author guilherme
 */
public class Projeto_SOA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lerAlgoritmos leituraArquivo = new lerAlgoritmos();
        TabelaDeProcessos tp;
        //tp = new TabelaDeProcessos();
        
        tp = leituraArquivo.lerArquivo();
        
        System.out.println("-> " + tp.getTabelaDeProcesso());
        
        for (BCP p : tp.getTabelaDeProcesso()){
            p.printProcesso();
            System.out.println("-------");
        }
        
    }
    
}
