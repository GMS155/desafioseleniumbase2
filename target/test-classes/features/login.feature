#language: pt

Funcionalidade: Login no Mantis
  Eu Como usuário da ferramenta Mantis
  Quero logar no sistema
  Para ter acesso as funcionalidades do Mantis


  Cenário: Login com sucesso
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario preencha o campo usuario corretamente
    E clique no botao Entrar
    E preencha o campo senha corretamente
    Quando e clicado no botao Entrar
    Então o login deve ser realizado com sucesso

  Cenário: Login com senha inválida
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario preencha o campo usuario corretamente
    E clique no botao Entrar
    E preencha o campo senha com valor invalido
    Quando e clicado no botao Entrar
    Então a aplicacao deve emitir uma mensagem de erro

  Cenário: Login com usuário inválido
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario preencha o campo usuario com valor invalido
    E clique no botao Entrar
    E preencha o campo senha corretamente
    Quando e clicado no botao Entrar
    Então a aplicacao deve emitir uma mensagem de erro

  Cenário: Login com usuário e login sem preencher
    Dado que o usuario esteja na pagina de login do Mantis
    E clique no botao Entrar
    Quando e clicado no botao Entrar novamente
    Então a aplicacao deve emitir uma mensagem de erro

  Cenário: Login com usuário sem preencher
    Dado que o usuario esteja na pagina de login do Mantis
    Quando e clicado no botao Entrar
    Então a aplicacao deve emitir uma mensagem de erro

  Cenário: Login com o campo senha sem preencher
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario preencha o campo usuario corretamente
    E clique no botao Entrar
    Quando e clicado no botao Entrar novamente
    Então a aplicacao deve emitir uma mensagem de erro

  Cenário: Login com sucesso usando Java Script
    Dado que o usuario esteja na pagina de login do Mantis
    Quando que o usuario preencha o campo usuario e senha
    E e clicado no botao Entrar
    Então o login deve ser realizado com sucesso
