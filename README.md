# Voejar
#### Feito por Gustavo Gil

o nome de usuário é "voejar" e a senha é "@application", o arquivo db.sql possui as inserções do exemplo da tarefa

caso apresente problemas para executar pelo VSCode, crie um novo projeto no Eclipse e mova a pasta src nele, adicione a dependência do mysql-connector no pom.xml e tudo funcionará corretamente

>Observação: Caso queira rodar no Eclipse o programa, modifique o context.xml tirando a primeira letra maiúscula da tag "Context"

#### Tabela SQL:
```sql
create table voos(
    id int auto_increment not null,
    origem varchar(3),
    destino varchar(3),
    data varchar(10),
    valor double,
    horario varchar(5),
    
    primary key(id)
);
```