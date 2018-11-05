/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import cpu.Processador;
import java.util.LinkedList;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author augusto
 */
public class RoundRobin extends cpu.Escalonador{

    public RoundRobin(){
        super();
    }

    @Override
    public BCP escalonar() {
        BCP bcp = new BCP();
        int menorTempo;

        retornarProcessosAptos(Processador.ciclo);

        if (this.getListaAptos().isEmpty()) {
            return null;
        }

        menorTempo = this.getListaAptos().get(0).getTempoChegada();
        bcp.copiaProcesso(this.getListaAptos().get(0));
        for (BCP p : this.getListaAptos()) {
            for (BCP p1 : this.getListaAptos()) {

                if (menorTempo > p1.getTempoChegada()) {
                    menorTempo = p1.getTempoChegada();
                    bcp.copiaProcesso(p1);

                }
            }
        }
        return bcp;
    }

    @Override
    public void retornarProcessosAptos(int ciclo) {
        for (BCP p : this.getListaProcessos()) {
            if (p.getTempoChegada() <= ciclo && !(processoJaApto(p.getId()))) {
                this.getListaAptos().add(p);
            }
        }
    }

    @Override
    public int returnIndexProcessoNaLista(int id) {
        for (BCP p : this.getListaProcessos()) {
            if (p.getId() == id) {
                return getListaProcessos().indexOf(p);
            }
        }
        return -1;
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
