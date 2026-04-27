# Sistema de Gerenciamento Acadêmico

Sistema desenvolvido em PHP para alunos, professores e técnicos-administrativos, permitindo cadastro, edição e exclusão de registros.

## Status do Projeto

Projeto estável e pronto para uso.

Este projeto não está mais em manutenção, sendo mantido apenas como demonstração de conceito e aprendizado.

---

## Objetivos
- Praticar desenvolvimento backend com Java
- Implementar operações de CRUD com integração ao banco de dados MySQL
- Trabalhar com manipulação de dados no servidor (requisições e respostas)
- Consolidar o uso de SQL em operações reais dentro de uma aplicação

## Funcionalidades
- Cadastrar entidades
- Editar entidades
- Excluir entidades
- Listar entidades em uma tabela
- Buscar entidade por matrícula na tabela

## Tecnologias usadas
- Java
- Java Swing
- JDBC
- SQL
- MySQL
- XAMPP
- GitHub Desktop
- VS Code

---

## Como Executar 

### Requisitos
- JDK 8 ou superior
- XAMPP
- MySQL

### Execução
1. Baixe e extraia o arquivo `.zip` do projeto
2. Abra o projeto na IDE de sua preferência
3. Abra o phpMyAdmin e execute o script do arquivo `script_banco.txt`
4. Abra o XAMPP e inicie o Apache e o MySQL
5. Execute a classe `Main.java`
6. Teste o projeto

> Execute o projeto no modo janela, na resolução previamente criada, para não causar erros de escala.

> Este projeto também pode funcionar em outros servidores locais e sistemas de banco de dados compatíveis com Java e SQL, com pequenas adaptações de configuração.

---

## Como Usar
- Para buscar um registro, digite a matrícula desejada no campo **Digite matrícula** e clique em **Buscar**
- Para criar um registro, preencha os dados do formulário e clique em **Create**
- Para editar ou excluir, selecione o registro na tabela e os dados aparecerão no formulário. Faça as alterações, se necessário, e clique em **Update** ou **Delete**

---

## Telas do Sistema

A seguir, estão algumas telas do sistema que ilustram sua interface e funcionamento.

### Tela Inicial
<img width="381" height="188" alt="image" src="https://github.com/user-attachments/assets/0dd4e3d6-5214-4053-bdcb-9fc1a286302c" />
<br>
<img width="381" height="188" alt="Screenshot 2026-03-27 133236" src="https://github.com/user-attachments/assets/6e143a5b-2c92-4b5e-81f4-3c6338fe06c5" />

### Tela de Gerenciamento de Entidades (Modo Cadastro)
<img width="880" height="338" alt="image" src="https://github.com/user-attachments/assets/e436b3b5-5417-45e1-a44f-cfedefcca9fb" />

### Tela de Gerenciamento de Entidades (Modo Edição)
<img width="880" height="338" alt="image" src="https://github.com/user-attachments/assets/8b257795-6dad-4324-9779-5b43bc81f7a4" />
