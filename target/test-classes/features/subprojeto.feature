#language: pt
Funcionalidade: Criação de subprojetos
  Como usuário admin
  Eu quero acessar a seção de criação de subprojeto
  Para criar um subprojeto

  Contexto:
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario tenha feito o login com sucesso

  @SoEsse
  Esquema do Cenário: Criar um subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar o cadastro do subprojeto com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Cenário: Criar um subprojeto sem nome
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E clicar no botao de salvar subprojeto
    Então o sistema deve permanecer na mesma tela de cadastro

  Cenário: Criar um subprojeto com o mesmo nome do subprojeto
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E clicar no botao de salvar subprojeto
    E clicar no projeto desejado "Teste projeto SQL 02" novamente
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E clicar no botao de salvar subprojeto
    Então o sistema deve emitir uma mensagem de erro

  Cenário: Criar um subprojeto com o mesmo nome do projeto
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Teste projeto SQL 02"
    E clicar no botao de salvar subprojeto
    Então o sistema deve emitir uma mensagem de erro

  Esquema do Cenário: Criar um subprojeto com número no nome
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "123456789"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar o cadastro do subprojeto com número com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Esquema do Cenário: Criar um subprojeto com caracter especial no nome
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "#$#$%#%&*(!!_>"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar o cadastro do subprojeto com caracter especial com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Esquema do Cenário: Criar um subprojeto sem preencher a descrição
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar o cadastro do subprojeto com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |


  Esquema do Cenário: Editar nome do subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E preencher o nome do subprojeto "Subprojeto 02 editado"
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar o cadastro do subprojeto editado com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Esquema do Cenário: Editar estado do subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E definir o estado do subprojeto <estadoEditado>
    E clicar no botao de salvar subprojeto
    Então o sistema deve realizar o cadastro do subprojeto com <estadoEditado> com sucesso

    Exemplos:
      | estado          | estadoEditado   |
      | desenvolvimento | release         |
      | release         | desenvolvimento |
      | obsoleto        | release         |

  Esquema do Cenário: Editar habilitado do subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E clicar no campo habilitado
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar a alteracao do habilitado com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Esquema do Cenário: Editar visibilidade do subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E  selecionar a visibilidade do projeto novamente
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar a alteracao da visiblidade com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Esquema do Cenário: Editar descrição do subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E preencher a descricao do subprojeto "SubProjeto criado como teste editado" novamente
    E clicar no botao de salvar subprojeto
    Então o sistema deve efetuar a alteracao da descricao com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |

  Cenário: Editar um subprojeto com o nome vazio
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E clicar no botao de salvar subprojeto
    E clicar no projeto desejado "Teste projeto SQL 02" novamente
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto ""
    E clicar no botao de salvar subprojeto
    Então o sistema deve permanecer na mesma tela de cadastro

  Esquema do Cenário: Excluir subprojeto com sucesso
    Quando clicar no projeto desejado "Teste projeto SQL 02"
    E clicar no botao de cadastrar subProjeto
    E preencher o nome do subprojeto "Subprojeto 02"
    E definir o estado do subprojeto <estado>
    E marcar a opcao herdar categorias globais
    E marcar a opcao herdar categorias da tarefa pai
    E selecionar a visibilidade do projeto
    E preencher a descricao do subprojeto "SubProjeto criado como teste"
    E clicar no botao de salvar subprojeto
    E clicar no subprojeto desejado "Subprojeto 02" novamente
    E clicar no botao apagar projeto
    Então o sistema deve excluir com sucesso

    Exemplos:
      | estado          |
      | desenvolvimento |
      | release         |
      | obsoleto        |