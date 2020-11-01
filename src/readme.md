Considerando as seguintes definições [1]: 

(1) Um grafo é conexo se existe pelo menos um caminho entre quaisquer pares de nós. Caso contrário, ele é chamado
desconexo; 

(2) Um grafo é cíclico quando existem mais de um caminho entre quaisquer pares de nós. Caso contrário, ele é chamado
acíclico; e 

(3) Um grafo é não-orientado quando não existem direções nas arestas. Caso contrário, ele é classificado como orientado. 

Você deve desenvolver um programa em JAVA que, dado um arquivo de entrada (**LIDO SOMENTE UMA VEZ PELO SEU PROGRAMA**),
contendo um grafo, classifique um grafo de acordo com as três definições supracitadas. 

Para o melhor entendimento do problema a ser resolvido, considere que você receba o seguinte arquivo como parâmetro de
entrada:

**1 2 3 4 5 6 7 8 9 10**

**1 3**

**3 1**

**1 8**

**8 1**

**2 6**

**6 2**

**3 7**

**7 3**

**3 8**

**8 3**

**4 5** 

**5 4**

**4 10** 

**10 4**

**7 8**

**8 7**

que representa o grafo a seguir: 

seu programa deve obter como resposta: 

**nao-orientado – ciclico – desconexo**

Para um outro exemplo de arquivo:

**0 1 2 3 4 5 6**

**0 1**

**1 0**

**0 2**

**2 0**

**0 5** 

**5 0**

**0 6**

**6 0**

**3 4**

**4 3**

**3 5**

**5 3**

**4 5**

**5 4**

**4 6**

**6 4** 

que representa o grafo a seguir: 

seu programa deve obter como resposta:

**nao-orientado – ciclico – conexo**

**LEMBRE-SE: SEU PROGRAMA DEVE EXECUTAR COM QUAISQUER DADOS INFORMADOS COMO PAR METROS DE ENTRADA. SE O SEU PROGRAMA
RESOLVER SOMENTE O PROBLEMA DO EXERCÍCIO SUPRACITADO, SUA QUESTÃO SERÁ TOTALMENTE DESCONTADA.**

_[1] T. H. Cormen, C. E. Leiserson, R. L. Rivest e C. Stein, “Algoritmos: teoria e prática”, Editora Campus, 2012._
