#language: pt
Funcionalidade: Gerenciamento de perfis globais
  Como usuário admin
  Eu quero acessar a seção de gerenciamento de perfis globais
  Para adicionar um pefil para o sistema

  Contexto:
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário tenha feito o login com sucesso

  @SoEsse
  Cenário: Adicionar um perfil com sucesso
    Quando acessar a tela de gerenciar perfil
    E preencher a plataforma corretamente
    E preencher o SO corretamente
    E preencher a versão do SO corretamente
    E preencher a descricao do sistema corretamente
    E clicar no botão adicionar perfil
    Então o sistema deve cadastrar o perfil com sucesso


  Cenário: Adicionar um perfil com campo plataforma em branco
    Quando acessar a tela de gerenciar perfil
    E deixar o campo plataforma em branco
    E preencher o SO corretamente
    E preencher a versão do SO corretamente
    E preencher a descricao do sistema corretamente
    E clicar no botão adicionar perfil
    Então o sistema deve permanecer na mesma tela de cadastro


  Cenário: Adicionar um perfil com campo SO em branco
    Quando acessar a tela de gerenciar perfil
    E preencher a plataforma corretamente
    E deixar o campo SO em branco
    E preencher a versão do SO corretamente
    E preencher a descricao do sistema corretamente
    E clicar no botão adicionar perfil
    Então o sistema deve permanecer na mesma tela de cadastro


  Cenário: Adicionar um perfil com campo versão SO em branco
    Quando acessar a tela de gerenciar perfil
    E preencher a plataforma corretamente
    E preencher o SO corretamente
    E e deixar o campo versão SO em branco
    E preencher a descricao do sistema corretamente
    E clicar no botão adicionar perfil
    Então o sistema deve permanecer na mesma tela de cadastro


  Cenário: Excluir perfil com sucesso
    Quando acessar a tela de gerenciar perfil
    E clicar no botão apagar
    Então o sistema deve excluir o perfil desejado corretamente