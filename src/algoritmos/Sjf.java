/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.Arrays;
import java.util.LinkedList;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author guilherme
 */
public class Sjf extends escalonador.Escalonador{
    private BCP processo;
    private LinkedList<BCP> listaProcessos;
    private int[] listaOrdemProcessos;
    
    public Sjf(){
        this.listaProcessos = TabelaDeProcessos.getInstance().getTabelaDeProcesso();
    }
    
    @Override
    public void escalonar(){
        int tamanhoLista = listaProcessos.size();
        LinkedList<BCP> listaAuxiliar = new LinkedList<>();
        
        for (int j = 0; j < tamanhoLista; j++){
            for (int k = 0; k < tamanhoLista; k++){

                if (this.listaOrdemProcessos[j] == this.listaProcessos.get(k).getTempoTotal()){
                    listaAuxiliar.add(this.listaProcessos.get(k));
                }
            }
        }
        
        this.listaProcessos = (LinkedList<BCP>) listaAuxiliar.clone();
        
    }
    
    @Override
    public void ordenar(){
        int[] baseParaPrdenacao;
        
        baseParaPrdenacao = new int[this.listaProcessos.size()];
        
        for (int i = 0; i < this.listaProcessos.size(); i++){
            baseParaPrdenacao[i] = this.listaProcessos.get(i).getTempoTotal();
        }
        
        Arrays.sort(baseParaPrdenacao);
        
        this.listaOrdemProcessos = baseParaPrdenacao.clone();
    }

    public LinkedList<BCP> getListaProcessos() {
        return listaProcessos;
    }

    public void setListaProcessos(LinkedList<BCP> listaProcessos) {
        this.listaProcessos = listaProcessos;
    }
    
}
