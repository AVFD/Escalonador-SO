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
public class Sjf extends cpu.Escalonador{
    private LinkedList<BCP> listaProcessos;
    private int[] listaOrdemProcessos;
    private int[] listaOrdemProcessosTempoChegada;
    private LinkedList<BCP> listaAptos = new LinkedList<>();
    private LinkedList<BCP> listaBloqueados = new LinkedList<>();
    
    public Sjf(){
        this.listaProcessos = TabelaDeProcessos.getInstance().getTabelaDeProcesso();
    }
    
    @Override
    public BCP escalonar(){
        BCP processoRetornar = new BCP();
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
        return processoRetornar;
    }
    
    @Override
    public void ordenar(){
        int[] baseParaPrdenacao;
        int primeiroProcesso;
        BCP processoTemp = null;
        LinkedList<BCP> listaAuxiliar = new LinkedList<>();
        
        primeiroProcesso = this.listaProcessos.get(0).getTempoChegada();
        
        for (int i = 0; i < this.listaProcessos.size(); i++){
            if (primeiroProcesso > this.listaProcessos.get(i).getTempoChegada()){
                primeiroProcesso = this.listaProcessos.get(i).getTempoChegada();
            }
        }
        
        listaAuxiliar = (LinkedList<BCP>) this.listaProcessos.clone();
        
        System.out.println("---->>>" + listaAuxiliar.size());
        
        baseParaPrdenacao = new int[this.listaProcessos.size()];
        
        for (int i = 0; i < this.listaProcessos.size(); i++){
            baseParaPrdenacao[i] = this.listaProcessos.get(i).getTempoTotal();
            }
        
        Arrays.sort(baseParaPrdenacao);
        
        for (int j = 0; j<baseParaPrdenacao.length; j++){
            for (int i=0; i<this.listaProcessos.size(); i++){
                if (this.listaProcessos.get(i).getTempoTotal() == baseParaPrdenacao[j]){
                    listaAuxiliar.add(this.listaProcessos.get(i));
                    break;
                }
            }
        }
        
        for (int i = 0; i < listaAuxiliar.size(); i++){
            if (listaAuxiliar.get(i).getTempoChegada() == primeiroProcesso){
                processoTemp = listaAuxiliar.get(i);
                listaAuxiliar.remove(listaAuxiliar.get(i));
            }
            else {
                
            }
        }        
        
        listaAuxiliar.addFirst(processoTemp);
        
        
        this.listaProcessos = (LinkedList<BCP>) listaAuxiliar.clone();
        /*
        baseParaPrdenacao = new int[this.listaProcessos.size()];
        
        for (int i = 0; i < this.listaProcessos.size(); i++){
            baseParaPrdenacao[i] = this.listaProcessos.get(i).getTempoTotal();
            }
        
        Arrays.sort(baseParaPrdenacao);
        
        this.listaOrdemProcessos = baseParaPrdenacao.clone();*/
    }

    public LinkedList<BCP> getListaProcessos() {
        return listaProcessos;
    }

    public void setListaProcessos(LinkedList<BCP> listaProcessos) {
        this.listaProcessos = listaProcessos;
    }
    
    public void escalonador (){
        BCP processoExecutando = null;
        String resultadoEscalonador = "";
        
        int ciclo = 0;
        
        do {
            processoExecutando = controleFilas(ciclo, processoExecutando);
            
            resultadoEscalonador += processoExecutando.getId();
            
            ciclo++;
            
        } while (listaAptos.size() > 0 && listaBloqueados.size() > 0);
        
        System.out.println("-> " + resultadoEscalonador);
    }
    
    public BCP controleFilas (int ciclo, BCP processoExecutando){
        BCP processoAtual = processoExecutando;
        int indiceProcessoNaLista;
                
        if (ciclo == this.listaOrdemProcessosTempoChegada[ciclo]){
            
            if (ciclo == 0){
                this.listaAptos.add(this.listaProcessos.get(0));
                processoAtual = this.listaProcessos.get(0);
                indiceProcessoNaLista = this.listaProcessos.indexOf(processoAtual);
                System.out.println("<<<: " + indiceProcessoNaLista);
            }
            else {//quando não se é o primeiro processo.
                
            }
            
        }
        else {
            processoAtual = new BCP();
            processoAtual.setId(-1);
        }
        
        return processoAtual;
        
    }
    
    public void ordenaPorTempoChegada(){
        int[] vetorOrdenadoTempoChegada = new int[this.listaProcessos.size()];

        for (int i = 0; i < this.listaProcessos.size(); i++){
            vetorOrdenadoTempoChegada[i] = this.listaProcessos.get(i).getTempoChegada();
        }
        
        Arrays.sort(vetorOrdenadoTempoChegada);
        
        this.listaOrdemProcessosTempoChegada = vetorOrdenadoTempoChegada.clone();
        
        System.out.println("--> " + Arrays.toString(this.listaOrdemProcessosTempoChegada));
    }
    
    public void arrumarListaOrdenadaDosProcessos(){
        LinkedList<BCP> listaAuxiliar = new LinkedList<>();

            for (int j = 0; j < this.listaProcessos.size(); j++){
                for (int k = 0; k < this.listaProcessos.size(); k++){
                    if (this.listaOrdemProcessosTempoChegada[j] == this.listaProcessos.get(k).getTempoChegada()){
                        listaAuxiliar.add(this.listaProcessos.get(k));
                    }
                }
            }
        
        this.listaProcessos = (LinkedList<BCP>) listaAuxiliar.clone();
    }
    
}
