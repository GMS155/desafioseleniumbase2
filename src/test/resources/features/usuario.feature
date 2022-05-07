#language: pt
Funcionalidade: Criação de usuários
  Como usuário admin
  Eu quero acessar a seção de gerenciar usuários
  Para criar um novo usuário

  Contexto:
    Dado que o usuário esteja na página de login do Mantis
    E que o usuário tenha feito o login com sucesso


  Cenário: Criar um usuário com sucesso
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário "GMS"
    E preencher o nome verdadeiro do usuário "Teste Nome Usuário"
    E preencher o email "Usuario@hotmail.com"
    E preencher o nível de acesso
    E selecionar a opção protegido
    E clicar no botão de criar usuário
    Então o sistema deve efetuar o cadastro com sucesso

  Cenário: Criar um usuário com número no campo nome de usuário
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário "123456789"
    E preencher o nome verdadeiro do usuário "Teste Nome Usuário"
    E preencher o email "Usuario2@hotmail.com"
    E preencher o nível de acesso
    E selecionar a opção protegido
    E clicar no botão de criar usuário
    Então o sistema deve efetuar o cadastro com número com sucesso

  Cenário: Criar um usuário com caractere especial no campo nome de usuário
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário "&#&#&@&*!_->"
    E preencher o nome verdadeiro do usuário "Teste Nome Usuário"
    E preencher o email "Usuario2@hotmail.com"
    E preencher o nível de acesso
    E selecionar a opção protegido
    E clicar no botão de criar usuário
    Então o sistema deve emitir uma mensagem de erro do caractere especial

  Cenário: Criar um usuário sem nome
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário ""
    E preencher o nome verdadeiro do usuário "Usuario Completo"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botão de criar usuário
    Então o sistema deve emitir uma mensagem de erro do usuário sem nome

  Cenário: Criar um usuário com nome igual ao usuário que foi inserido pelo sql
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário "Usuario1"
    E preencher o nome verdadeiro do usuário "Usuario Completo"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botão de criar usuário
    Então o sistema deve emitir uma mensagem de erro

  Cenário: Criar um usuário com o mesmo email do usuário que foi inserido pelo sql
    Quando acessar a tela de criação de usuário
    E preencher o nome de usuário "Nome Diferente"
    E preencher o nome verdadeiro do usuário "Usuario Diferente"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botão de criar usuário
    Então o sistema deve emitir uma mensagem de erro do email igual

    #--------------------------- editar nome -------------------


  Cenário: Editar campo nome usuário com sucesso
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E editar o nome de usuário "Usuario1Editado"
    E clicar no botão de atualizar usuário
    Então o sistema deve editar o nome com sucesso

  Cenário: Editar campo nome usuário para vazio
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E editar o nome de usuário ""
    E clicar no botão de atualizar usuário
    Então o sistema deve emitir uma mensagem de erro do nome vazio

  Cenário: Editar campo nome verdadeiro com sucesso
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E editar o nome verdadeiro "Usuario Completo editado"
    E clicar no botão de atualizar usuário
    Então o sistema deve editar o nome verdadeiro com sucesso

  Cenário: Editar email com sucesso
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E editar o email "usuarioeditado.igual@hotmail.com"
    E clicar no botão de atualizar usuário
    Então o sistema deve editar o email com sucesso

  Cenário: Editar nível de acesso com sucesso
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E editar o nível de acesso "desenvolvedor"
    E clicar no botão de atualizar usuário
    Então o sistema deve editar o nível com sucesso

     #--------------------------- excluir usuário -------------------

  @SoEsse
  Cenário: Excluir usuário com sucesso
    Quando acessar a tela dos usuários cadastrados
    E clicar no campo usuário "Usuario1"
    E clicar no botão apagar usuário
    Então o sistema deve excluir com sucesso