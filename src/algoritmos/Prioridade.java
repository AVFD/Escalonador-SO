/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import cpu.Processador;
import processo.BCP;

/**
 *
 * @author augusto
 */
public class Prioridade extends cpu.Escalonador {
    public Prioridade(){
        super();
    }
    @Override
    public BCP escalonar() {
        /*Esta chamada de função faz com que a lista de processos aptos seja montada, 
        baseado na relação de ciclo do processador e o tempo de chegada do processo.*/
        retornarProcessosAptos(Processador.ciclo);

        if (this.getListaAptos().isEmpty()) {
            return null;
        }
        // Selecionar o processo a ser escalonado, baseado na prioridade.
        BCP bcp = this.getListaAptos().get(0);
        for (BCP p : this.getListaAptos()) {
            if (bcp.getPrioridade() > p.getPrioridade()) {
                bcp = p;
            }
        }
        return bcp;
    }

    
}
