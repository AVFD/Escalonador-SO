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
 * @author guilherme
 */
public class Sjf extends cpu.Escalonador {

    public Sjf() {
        super();
    }

    @Override
    public BCP escalonar() {

        retornarProcessosAptos(Processador.ciclo);

        if (this.getListaAptos().isEmpty()) {
            return null;
        }

        BCP bcp = this.getListaAptos().get(0);
        for (BCP p : this.getListaAptos()) {
            if (bcp.getTempoTotal() > p.getTempoTotal()) {
                bcp = p;
            }
        }
        return bcp;
    }
    
    
    @Override
    public void retornarProcessosAptos(int ciclo) {

        for (BCP p : this.getListaProcessos()) {
            if (!p.isBlocked && p.getTempoChegada() <= ciclo && !(processoJaApto(p.getId()))) {
                this.getListaAptos().add(p);
            }
        }

    }


    private boolean processoJaApto(int indiceProcesso) {
        boolean tem = false;
        for (BCP p : this.getListaAptos()) {
            if (p.getId() == indiceProcesso) {
                tem = true;
            }
        }
        return tem;
    }
}
