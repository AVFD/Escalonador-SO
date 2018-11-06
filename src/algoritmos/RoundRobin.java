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
public class RoundRobin extends cpu.Escalonador {

    public RoundRobin() {
        super();
    }

    @Override
    public BCP escalonar() {
        BCP bcp = new BCP();

        retornarProcessosAptos(Processador.ciclo);

        if (this.getListaAptos().isEmpty()) {
            return null;
        }

        bcp = this.getListaAptos().remove(0);
        this.getListaAptos().add(bcp);
        return bcp;
    }

}
