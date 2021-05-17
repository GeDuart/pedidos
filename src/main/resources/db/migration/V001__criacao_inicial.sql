/* Criação Cliente */
create table cliente(
  id bigint not null auto_increment,
  nome varchar(150),
  email_principal varchar(150),
  status int,
  data_criacao datetime,
  data_atualizacao datetime,
  
  primary key(id)
)engine=InnoDB default charset=utf8;

/* Criação Telefone */
create table telefone(
  id bigint not null auto_increment,
  numero varchar(20) not null,
  tipo int not null,
  cliente_id bigint not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Cidade */
create table cidade(
  id bigint not null auto_increment,
  nome varchar(80) not null,
  estado_id bigint not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Estado */
create table estado(
  id bigint not null auto_increment,
  nome varchar(80) not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Empresa */

create table empresa(
  id bigint not null auto_increment,
  nome varchar(200) not null,
  cnpj varchar(18) not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Produto */
create table produto(
  id bigint not null auto_increment,
  nome varchar(200) not null,
  valor_unitario decimal(10,2) not null,
  status int not null,
  data_criacao datetime not null,
  data_atualizacao datetime not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Pedido */
create table pedido(
  id bigint not null auto_increment,
  cliente_id bigint not null,
  empresa_id bigint not null,
  valor_total decimal(10,2) not null,
  data_criacao datetime not null,
  data_atualizacao datetime not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;

/* Criação Pedido Itens */
create table pedidoItens(
  id bigint not null auto_increment,
  pedido_id bigint not null,
  quantidade double not null,
  produto_id bigint not null,
  valor_unitario decimal(10,2) not null,
  
  primary key (id)
)engine=InnoDB default charset=utf8;



alter table cidade add constraint fk_cidade_estado foreing key (estado_id) references estado (id);