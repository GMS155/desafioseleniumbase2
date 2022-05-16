#language: pt
Funcionalidade: Criação de projetos
  Como usuário admin
  Eu quero acessar a seção de criação de projeto
  Para criar um projeto

  Contexto:
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario tenha feito o login com sucesso


  Cenário: Criar um projeto com sucesso
    Quando acessar a tela de criacao de projeto
    E preencher o nome do projeto
    E preencher o estado do projeto
    E marcar a opcao herdar categorias globais
    E selecionar a visibilidade do projeto
    E preencher a descricao do projeto "Projeto criado como teste"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar o cadastro com sucesso

  Cenário: Criar um projeto sem preencher o nome do projeto
    Quando acessar a tela de criacao de projeto
    E clicar no botao de salvar projeto
    Então o sistema deve permanecer na mesma tela de cadastro

  Cenário: Criar um projeto com nome repetido
    E que tenha cadastrado um projeto
    Quando acessar a tela de criacao de projeto
    E preencher o nome do projeto
    E preencher o estado do projeto
    E marcar a opcao herdar categorias globais
    E selecionar a visibilidade do projeto
    E preencher a descricao do projeto "Projeto criado como teste"
    E clicar no botao de salvar projeto
    Então o sistema deve emitir uma mensagem de erro

  Cenário: Criar projeto com caractere especial no campo nome
    Quando acessar a tela de criacao de projeto
    E preencher o nome do projeto com caractere especial
    E preencher o estado do projeto
    E marcar a opcao herdar categorias globais
    E selecionar a visibilidade do projeto
    E preencher a descricao do projeto "Projeto criado como teste"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar o cadastro do caractere especial com sucesso

  Cenário: Criar projeto com número no campo nome
    Quando acessar a tela de criacao de projeto
    E preencher o nome do projeto com numero
    E preencher o estado do projeto
    E marcar a opcao herdar categorias globais
    E selecionar a visibilidade do projeto
    E preencher a descricao do projeto "Projeto criado como teste"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar o cadastro do numero com sucesso

  Cenário: Editar campo nome projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 01"
    E definir o nome do projeto "Teste projeto SQL 01_Editado"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar o cadastro editado com sucesso

  Esquema do Cenário: Editar campo estado do projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 02"
    E definir o estado do projeto <estado>
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar o cadastro do <estado> editado com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Cenário: Editar campo habilitado do projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 03"
    E clicar no campo habilitado
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar a alteracao do habilitado com sucesso
  @SoEsse
  Cenário: Editar campo visibilidade do projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 04"
    E definir a visibilidade do projeto "privado"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar a alteracao da visibilidade com sucesso

  Cenário: Editar campo descrição do projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 05"
    E definir a descricao do projeto "Projeto criado e alterado com sucesso"
    E clicar no botao de salvar projeto
    Então o sistema deve efetuar a alteracao da descricao com sucesso

  Cenário: Editar campo nome com parâmetro vazio
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 01"
    E definir o nome do projeto ""
    E clicar no botao de salvar projeto
    Então o sistema deve permanecer na mesma tela de cadastro

  Cenário: Excluir projeto com sucesso
    Quando acessar a tela de gerencia de projeto
    E clicar no projeto desejado "Teste projeto SQL 06"
    E clicar no botao apagar projeto
    Então o sistema deve excluir com sucesso