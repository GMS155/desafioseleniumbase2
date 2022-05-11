#language: pt
Funcionalidade: Criação de usuários
  Como usuário admin
  Eu quero acessar a seção de gerenciar usuários
  Para criar um novo usuário

  Contexto:
    Dado que o usuario esteja na pagina de login do Mantis
    E que o usuario tenha feito o login com sucesso

  @SoEsse
  Cenário: Criar um usuário com sucesso
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario "GMS"
    E preencher o nome verdadeiro do usuario "Teste Nome Usuário"
    E preencher o email "Usuario@hotmail.com"
    E preencher o nivel de acesso
    E selecionar a opcao protegido
    E clicar no botao de criar usuario
    Então o sistema deve efetuar o cadastro com sucesso

  Cenário: Criar um usuário com número no campo nome de usuário
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario "123456789"
    E preencher o nome verdadeiro do usuario "Teste Nome Usuário"
    E preencher o email "Usuario2@hotmail.com"
    E preencher o nivel de acesso
    E selecionar a opcao protegido
    E clicar no botao de criar usuario
    Então o sistema deve efetuar o cadastro com numero com sucesso

  Cenário: Criar um usuário com caractere especial no campo nome de usuário
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario "&#&#&@&*!_->"
    E preencher o nome verdadeiro do usuario "Teste Nome Usuário"
    E preencher o email "Usuario2@hotmail.com"
    E preencher o nivel de acesso
    E selecionar a opcao protegido
    E clicar no botao de criar usuario
    Então o sistema deve emitir uma mensagem de erro do caractere especial

  @SoEsse
  Cenário: Criar um usuário sem nome
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario ""
    E preencher o nome verdadeiro do usuario "Usuario Completo"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botao de criar usuario
    Então o sistema deve emitir uma mensagem de erro do usuario sem nome

  Cenário: Criar um usuário com nome igual ao usuário que foi inserido pelo sql
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario "Usuario1"
    E preencher o nome verdadeiro do usuario "Usuario Completo"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botao de criar usuario
    Então o sistema deve emitir uma mensagem de erro

  Cenário: Criar um usuário com o mesmo email do usuário que foi inserido pelo sql
    Quando acessar a tela de criacao de usuario
    E preencher o nome de usuario "Nome Diferente"
    E preencher o nome verdadeiro do usuario "Usuario Diferente"
    E preencher o email "usuario.igual@hotmail.com"
    E clicar no botao de criar usuario
    Então o sistema deve emitir uma mensagem de erro do email igual

    #--------------------------- editar nome -------------------


  Cenário: Editar campo nome usuário com sucesso
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E editar o nome de usuario "Usuario1Editado"
    E clicar no botao de atualizar usuario
    Então o sistema deve editar o nome com sucesso

  Cenário: Editar campo nome usuário para vazio
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E editar o nome de usuario ""
    E clicar no botao de atualizar usuario
    Então o sistema deve emitir uma mensagem de erro do nome vazio

  Cenário: Editar campo nome verdadeiro com sucesso
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E editar o nome verdadeiro "Usuario Completo editado"
    E clicar no botao de atualizar usuario
    Então o sistema deve editar o nome verdadeiro com sucesso

  Cenário: Editar email com sucesso
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E editar o email "usuarioeditado.igual@hotmail.com"
    E clicar no botao de atualizar usuario
    Então o sistema deve editar o email com sucesso

  Cenário: Editar nível de acesso com sucesso
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E editar o nivel de acesso "desenvolvedor"
    E clicar no botao de atualizar usuario
    Então o sistema deve editar o nível com sucesso

     #--------------------------- excluir usuário -------------------


  Cenário: Excluir usuário com sucesso
    Quando acessar a tela dos usuarios cadastrados
    E clicar no campo usuario "Usuario1"
    E clicar no botao apagar usuario
    Então o sistema deve excluir com sucesso