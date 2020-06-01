## Documentação de Projeto de Software Versão 4.0

## Área de negócio do Sistema
O presente projeto é voltado para a área educacional, em específico para as bibliotecas. O intuito é proporcionar o gerenciamento do empréstimo de livros de forma similar ao software PERGAMUM já existente nas universidades públicas do estado.

## Principais funcionalidades
O sistema de controle de biblioteca tem como funcionalidades: cadastrar, consultar, editar e excluir: leitores, livros, autores, editoras, funcionários, extrair relatórios, determinar prazo de devolução e aplicar multa em caso de descumprimento da data limite.

## Método de trabalho
Inicialmente foi realizado o levantamento de requisitos do sistema. Em seguida, deu-se prosseguimento à criação de um diagrama entidade relacionamento (modelo ER) visando um melhor entendimento acerca do funcionamento do banco de dados. Para tal utilizou-se a ferramenta de modelagem em banco de dados BrModelo. O projeto, Sistema de Biblioteca, foi desenvolvido com a linguagem de programação Java, cuja interação deu-se com SGBD MySQL. Este foi manipulado através do software HeidiSQL.

## Modelo de Visão
* Apenas o login do tipo administrador poderá cadastrar funcionários, leitores, livros, autores, editoras.
* Os leitores só poderão ser pessoas físicas e, no cadastro, será solicitado: Nome, data de nascimento, telefone, CPF, E-mail e endereço. Ao final, se atribuirá um ID que será o Primary Key.
* Para cadastrar um livro, será necessário primeiramente cadastra o autor e editora do mesmo para poder realizar o cadastro do livro, que será solicitado: Título, autor, editora, ano da edição e quantidade. Ao final, se atribuirá um ID que será o Primary Key.
*  O empréstimo será realizado apenas pelo funcionário.
*  No empréstimo, será requisitado o nome do leitor previamente cadastrado. Este escolherá um ou mais livros, será registrado a data do empréstimo e a data de devolução e será atribuído um ID que será o Primary Key.
* O prazo para devolução é de uma semana. Ao leitor, não será permitido a entrega de apenas um dos livros, caso tenha pego mais de um. Devolve-se tudo de uma só vez, ou renova. A opção de renovação pode ser feita por duas vezes. A cada dia de atraso, será cobrado um valor de R$1,00.
O sistema possibilitará a extração de relatórios de várias formas:
* Relação dos leitores;
* Relação dos livros;
* Quantidade de livros emprestados por leitor;
* Quantidade de leitores que fizeram empréstimos de um determinado livro.

## Modelo Conceitual

![modelo conceitual](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca-V4/blob/master/imagens/Modelo%20Conceitual%203.0%20-%20Sistema%20de%20Biblioteca.jpg)

## Modelo Lógico
```
login (id_login, nome, senha, tipo)
	id_login – Primary Key
  
autor (id_autor, nome, id_login)
	id-autor – Primary Key
         id_login referencia login - Foreign Key
	
editora (id_editora, nome, id_login)
	id_editora - Primary Key
	id_login referencia login - Foreign Key

livro (id_livro, titulo, volume, ano, id_login, id_editora, id_autor)
	id_livro - Primary Key
	id_login referenca login - Foreign Key
         id_editora referencia edtora - Foreign Key
         Id_autor referencia autor - Foreign Key

leitor (id_leitor, nome, cpf, data_nascimento, telefone, email, rua, número, bairro, cidade, cep, uf, id_login)
id_leitor – Primary Key
id_login referencia Login                                                     

emprestimo (id_emprestimo, data_emprestimo, data_devolucao, id_funcionario, id_leitor)
id_emprestimo – Primary Key
id_funcionario referencia funcionário - Foreign Key
id_leitor referencia leitor - Foreign Key

funcionario (id_funcionario, nome, senha, id_login)
	id_funcionario – Primary Key
	id_login referencia login - Foreign Key

emprestimo_livro (id_emprestimo, id_livro)
              id_emprestimo referencia empréstimo – Primary Key
              id_livro referencia livro - Primary Key
```
## Dicionário de Dados

##### Tabela Login

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Nome       |Varchar, 100  |     Sim     |          |Nome do usuário que está logando                        |
|    Senha      |Varchar,50    |     Sim     |          |Senha do usuário que está logando                       |
|    Tipo       |Varchar       |     Sim     |          |Contém os dados se a conta logada é Admin ou Funcionário|

##### Tabela Autor

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Nome       |Varchar, 100  |     Sim     |          |Nome do autor                                           |
|    id_login   |integer       |     Sim     |          |Referência à tabela login                               |

##### Tabela Livro




## Sistema de Biblioteca

O presente projeto é voltado para a área educacional, em específico para as bibliotecas. O intuito é proporcionar o gerenciamento do empréstimo de livros de forma similar ao software PERGAMUM já existente nas universidades públicas do estado.

## Descrição do Sistema.

O presente projeto é voltado para a área educacional, em específico para as bibliotecas. O intuito é proporcionar o gerenciamento do empréstimo de livros de forma similar ao software PERGAMUM já existente nas universidades públicas do estado.

## Sobre o sistema
O sistema de controle de biblioteca tem como funcionalidades: cadastrar, consultar, editar e excluir: leitores, livros, autores, editoras, funcionários, extrair relatórios, determinar prazo de devolução e aplicar multa em caso de descumprimento da data limite.

# Camada View

## Login

![Tela de Login](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca-V4/blob/master/imagens/login.png)

A tela é a de Login do sistema, cuja a função é autenticar o usuário. Uma vez autenticado, ele tem permissão para acessar o sistema.
