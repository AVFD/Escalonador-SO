# Simulador do escalonador de processos

## Pré-requisitos

* Necessário java 7 ou posteriores.
* Passar por parâmetro (argumento) o nome do arquivo que contém as informações dos processos.
** O arquivo deve seguir o seguinte padrão:
*** Cada processo será uma linha e atributos são separados por vírgula.
*** Todos os atributos são números
*** 1º atributo: ID do processo
*** 2º atributo: Tempo total que o processo necessita para executar.
*** 3° atributo: Prioridade do processo
*** 4° atributo: Tempo de chegada a CPU
**** 5º ou mais atributos (opicional): será o tempo (ciclo do processador) em que o processo fará um procedimento de IO.

# Valores Padrões
* Quantum do processador = 1
* Tempo em que um processo realizará IO (bloqueado): 2
