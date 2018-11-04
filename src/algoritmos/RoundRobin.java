/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.LinkedList;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author augusto
 */
public class RoundRobin extends cpu.Escalonador{
    private LinkedList<BCP> listaProcessos;
    private int[] listaOrdemProcessos;
    
    public RoundRobin(){
        this.listaProcessos = TabelaDeProcessos.getInstance().getTabelaDeProcesso();
    }

    @Override
    public BCP escalonar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void retornarProcessosAptos(int ciclo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decrementarProcessos(int ciclo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int returnIndexProcessoNaLista(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
