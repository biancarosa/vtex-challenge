# vtex-challenge

## 1. Subset Sum Challenge

### Problema
Escreva um programa que, dado uma lista de números e uma soma alvo, retorne todas as combinações de um ou mais itens da lista que a soma seja igual a soma alvo.

Exemplo:

Entrada: Para soma alvo 6 de lista (1, 2, 3, 4, 6) o resultado é:

Saida: (1, 2, 3)

(2, 4)

(6)

### Solução
A solução em Scala foi feita de uma tradução da solução original em Groovy. Pela minha falta de experiência com Scala, preferi fazer em Groovy pra testar a solução, e logo depois traduzi(essa parte foi a mais legal, já que não conhecia muito sobre a linguagem :D).

Possivelmente existe uma solução mais rápida com backtracking, mas a escolhida levou em consideração a simplicidade do código. Basicamente são gerados todos os subconjuntos possíveis (depois de tirar do vetor números acima do valor alvo) com um algoritmo que se baseia na teoria dos [Power Sets](https://en.wikipedia.org/wiki/Power_set).

Não foi considerada a possibilidade de haver números negativos.


### Rodando o código
Usando sdkman, para o exemplo dado, rodei o código da seguinte forma:
```
scala SubsetSumChallenge.scala 6 1 2 3 4 6
```

Output:
```
1,2,3
2,4
6
```

## 2. Path Challenge

### Problema
Fazer um programa que encontra um caminho a partir de uma origem até o destino navegando entre os nós. Cada nó é representado por um número inteiro. Cada possibilidade de caminho é representado por um dicionário no formato (Inteiro -> Lista( Inteiros)), onde a chave é o número do nó, e a lista são as ligações unidirecional daquele nó. O resultado é uma lista de inteiros representando o caminho pelos nós.

Exemplo:

Entrada: origem: 1, destino: 4,

caminhos: ( 1 -> (2, 3), 2 -> (4), 3->(5) )

Saída: (1, 2, 4)

### Solução
A solução foi feita em Java, baseada em um [código meu já existente](https://github.com/biancarosa/algorithms/blob/master/DepthFirstSearch.java), com as modificações necessárias para imprimir o caminho através da DFS e, como sugerido pelo enunciando do problema, trocando a matriz por um mapa.

A idéia de manter inner classes e o código numa classe só foi para facilitar a compilação e leitura.

### Rodando o código
Rodei o código da seguinte forma:
```
javac PathChallenge.java
java PathChallenge
```

Input & Output(o programa vai pedindo as informações enquanto roda):
```
Start node :: 1
End node :: 4
Write number of edges :: 4
Write vertices for each edge (1 1)
Edge #1 1 2
Edge #2 1 3
Edge #3 2 4
Edge #4 3 5
Start path
1
2
4
End path
```
