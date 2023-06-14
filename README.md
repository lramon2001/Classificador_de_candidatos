# Classificador de Candidatos
About
O "Classificador de Candidatos" é um sistema que lê um arquivo de texto (txt) com informações sobre candidatos, cria uma estrutura de dados para armazenar essas informações e os ordena com base em sua classificação. O software em questão é baseado para tratar especificamente o resultado do Enem para a Universidade de Brasĺília

## Links utéis

- [Consulta online aos candidatos em convocados em primeira chamada](https://security.cebraspe.org.br/ConsultaOnline/UNB_23_ACESSOENEM/1983/7d6638f3-928d-46f4-b7bd-9ace99ad2b70/Consulta);
- [EDITAL Nº 8 – UnB – ACESSO ENEM UnB 2023](https://cdn.cebraspe.org.br/vestibulares/UNB_23_ACESSOENEM/arquivos/ED_8_2023_ACESSO_ENEM_RES_FINAL_BIOP_HETERO.PDF)

## Como usar o software

Infelizmente, é um softwware um pouco complicado de usa, mas pretendo evouluir a usabilidade para a proxima divulgação de resultados de sistemas de seleção para UnB. A UnB a ordenação por nome ficando difícil do usuário consultar o ranking.

Passo 1: Clone o repositório

``` git clone git@github.com:lramon2001/Classificador_de_candidatos.git```

Passo 2: Subsitiua o Path no código fonte:

 ```Path path = Paths.get("/home/lramon2001/medicina.txt");```
 
 Para saber o caminho do diretório bastar fazer este comando:
 
``` pwd ```

concatene com o nome do arquivo igual no exemplo
Passo 3: Compile o programa:

```javac VestibularResults.java```

Passo 4: Execute o programa:

```java VestibularResults```

Como estamos na versão 1.0.0, o software ainda não está muito fácil de usar. Porém, fiz bem rapidinho e pretendo evouluir.

