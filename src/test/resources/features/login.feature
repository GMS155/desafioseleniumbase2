#language: pt

Funcionalidade: Login no Mantis
  Eu Como usuário da ferramenta Mantis
  Quero logar no sistema
  Para ter acesso as funcionalidades do Mantis


  Cenário: Login com sucesso
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário preencha o campo usuário corretamente
    E clique no botão Entrar
    E preencha o campo senha corretamente
    Quando é clicado no botão Entrar
    Então o login deve ser realizado com sucesso

  Cenário: Login com senha inválida
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário preencha o campo usuário corretamente
    E clique no botão Entrar
    E preencha o campo senha com valor inválido
    Quando é clicado no botão Entrar
    Então a aplicação deve emitir uma mensagem de erro

  Cenário: Login com usuário inválido
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário preencha o campo usuário com valor inválido
    E clique no botão Entrar
    E preencha o campo senha corretamente
    Quando é clicado no botão Entrar
    Então a aplicação deve emitir uma mensagem de erro

  Cenário: Login com usuário e login sem preencher
    Dado que o usuário esteja na página de login do Mantis
    E clique no botão Entrar
    Quando é clicado no botão Entrar novamente
    Então a aplicação deve emitir uma mensagem de erro

  Cenário: Login com usuário sem preencher
    Dado que o usuário esteja na página de login do Mantis
    Quando é clicado no botão Entrar
    Então a aplicação deve emitir uma mensagem de erro

  Cenário: Login com o campo senha sem preencher
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário preencha o campo usuário corretamente
    E clique no botão Entrar
    Quando é clicado no botão Entrar novamente
    Então a aplicação deve emitir uma mensagem de erro

  Cenário: Login com sucesso usando Java Script
    Dado que o usuário esteja na página de login do Mantis
    Quando que o usuário preencha o campo usuário e senha
    E é clicado no botão Entrar
    Então o login deve ser realizado com sucesso
