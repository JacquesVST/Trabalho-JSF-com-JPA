# Trabalho-JSF-com-JPA

## Contexto do projeto
Entidades:
- Estilo Musical
- Banda
- Integrante

## SQL
Tabelas

```
Create table estilo(
  id int primary key,
  nome varchar(50),
  bpm varchar(10)
);

Create table banda(
  id int primary key,
  nome varchar(50),
  origem varchar(10)
);

Create table integrante(
  id int primary key,
  nome varchar(50),
  data_nascimento varchar(10)
);
```

Dados

```
insert into estilo values(1, 'Rock', '120');
insert into banda values(1, 'Queen', 'Inglaterra');
insert into integrante values(1, 'Brian May', '19-07-1947');
insert into integrante values(2, 'Freddie Mercury', '05-09-1946');
insert into integrante values(3, 'John Deacon', '19-08-1951');
insert into integrante values(4, 'Roger Meddows-Taylor', '26-07-1949');
```

Chaves Estrangeiras

```
alter table banda add id_estilo int;
alter table banda add constraint fk_estilo foreign key (id_estilo) references estilo (id);

alter table integrante add id_banda int;
alter table integrante add constraint fk_banda foreign key (id_banda) references banda (id);
```


Sequências

```
CREATE SEQUENCE SEQUENCE_ESTILO;
CREATE SEQUENCE SEQUENCE_BANDA;
CREATE SEQUENCE SEQUENCE_INTEGRANTE;
```