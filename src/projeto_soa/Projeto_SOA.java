/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_soa;

import algoritmos.Prioridade;
import algoritmos.RoundRobin;
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

        // Instanciação dos 3 algoritmos e da lista de algoritmos para serem executados na plasse Processador.
        Escalonador sjf = new Sjf();
        Escalonador pri =  new Prioridade();
        Escalonador roundRobin = new RoundRobin();
        LinkedList<Escalonador> listaAlg = new LinkedList<>();

        listaAlg.add(sjf);
        listaAlg.add(pri);
        listaAlg.add(roundRobin);
        Processador p = new Processador(listaAlg);
        
        //realiza escalonamento.
        p.processar();
        int i = 0;
        for (LinkedList<BCP> lk : p.getOrdemExecutados()) {
            System.out.println(p.getListaAlg().get(i).getClass().getName());
            i++;
            for (BCP processo : lk) {
                processo.printProcesso();
            }
                System.out.println("\n-------");
        }

    }

}
