# **Desafio Automação - Selenium WebDriver**

### Requisitos

- Instalação do Xampp 7.4.29 / PHP 7.4.29
  *[Xampp](https://www.apachefriends.org/pt_br/download.html)*

- Instalação do Mantis 2.25.4.
  *[Mantis](https://www.mantisbt.org/download.php)*

- Importação das dependências presentes no pom.xml.

- Instalação do Gitlab-runner.
  *[GitLab-runner](https://docs.gitlab.com/runner/install/windows.html)*


###  Instalação

#### 	Passos

1. Instalar o xampp juntamente com seus componentes (Mysql);

2. Baixar o Mantis, descompactar o arquivo;

3. Colar na pasta htdocs do diretório de instalação do xammp;

4. Executar o xammp e iniciar os serviços Apache e Mysql;

5. Abrir o Navegador e digitar localhost/(nome da pasta que foi colocada no htdocs);

6. Configurar os dados para acesso no Mantis

OBS: se não definir um usuário e senha, os padrões são: usuário (Administrator), senha (root);


#### Componentes

  .Java
  .Cucumber
  .Relatórios com ExtentReport
  .Testes agendados pelo Gitlab-ci


## Execução agendada no Gitlab-ci

- Após instalação do Gitlab-runner conforme documentação, o runner deve ser vinculado ao Gitlab por meio de um token
para que seja possível a manipulação da execução dos testes por meio do arquivo .gitlab-ci.yml

## Links de apoio:
*[GitLab-runner(vinculação)](https://docs.gitlab.com/runner/register/index.html)*