/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import java.util.LinkedList;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author augusto
 */
public abstract class Escalonador {

    LinkedList<BCP> listaBloqueado;
    LinkedList<BCP> listaAptos;
    LinkedList<BCP> listaProcessos;

    public Escalonador() {
        this.listaAptos = new LinkedList<>();
        this.listaBloqueado = new LinkedList<>();
        this.listaProcessos = TabelaDeProcessos.getInstance().getTabelaDeProcesso();
    }

    abstract public BCP escalonar();

    public LinkedList<BCP> getListaBloqueado() {
        return listaBloqueado;
    }

    public void setListaBloqueado(LinkedList<BCP> listaBloqueado) {
        this.listaBloqueado = listaBloqueado;
    }

    public int returnIndexProcessoNaLista(int id, LinkedList<BCP> lista) {
        for (BCP p : lista) {
            if (p.getId() == id) {
                return lista.indexOf(p);
            }
        }
        return -1;
    }
    
    public void retornarProcessosAptos(int ciclo) {

        for (BCP p : this.listaProcessos) {
            if (!p.isBlocked && p.getTempoChegada() <= ciclo && !(processoJaApto(p.getId()))) {
                this.listaAptos.add(p);
            }
        }

    }


    public boolean processoJaApto(int indiceProcesso) {
        boolean tem = false;
        for (BCP p : this.listaAptos) {
            if (p.getId() == indiceProcesso) {
                tem = true;
            }
        }
        return tem;
    }

    public LinkedList<BCP> getListaAptos() {
        return listaAptos;
    }

    public void setListaAptos(LinkedList<BCP> listaAptos) {
        this.listaAptos = listaAptos;
    }

    public LinkedList<BCP> getListaProcessos() {
        return listaProcessos;
    }

    public void setListaProcessos(LinkedList<BCP> listaProcessos) {
        this.listaProcessos = listaProcessos;
    }

    public void removeById(int id, LinkedList<BCP> listaParaRemover) {
        for (int i = 0; i < listaParaRemover.size(); i++) {
            if (id == listaParaRemover.get(i).getId()) {
                listaParaRemover.remove(i);
            }
        }
    }

}
