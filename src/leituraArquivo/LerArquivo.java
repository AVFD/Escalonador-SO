/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituraArquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import processo.BCP;
import processo.TabelaDeProcessos;

/**
 *
 * @author guilherme
 */
public class LerArquivo {

    private final String file1 = "algoritmo1.txt";

    public TabelaDeProcessos lerArquivo() {
        TabelaDeProcessos tabelaDeProcessos = new TabelaDeProcessos();
        try {
            FileReader arq = new FileReader(file1);
            BufferedReader lerArq = new BufferedReader(arq);
            String line = "";
            String parts[];

            while ((line = lerArq.readLine()) != null) {
                BCP novoProcesso = new BCP();
                
                System.out.println("--> " + line);
                parts = line.split(" ");
                novoProcesso.setId(Integer.valueOf(parts[0]));
                novoProcesso.setTempoTotal(Integer.valueOf(parts[1]));
                novoProcesso.setPrioridade(Integer.valueOf(parts[2]));
                novoProcesso.setTempoChegada(Integer.valueOf(parts[3]));
                // Este for executa caso o processo tenha uma lista de IO.
                for (int i = 4; i < parts.length; i++) {
                    novoProcesso.getListaIO().add(Integer.valueOf(parts[i]));
                }
                tabelaDeProcessos.getTabelaDeProcesso().add(novoProcesso);
            }
            System.out.println("---------");

        } catch (FileNotFoundException ex) {
            System.out.println("Na classe LerAlgoritmos, não foi encontrado o arquivo com esse nome: " + file1);
            Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tabelaDeProcessos;
    }
}
