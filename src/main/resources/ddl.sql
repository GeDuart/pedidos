create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cliente (id bigint not null auto_increment, data_atualizacao datetime not null, data_criacao datetime not null, email_principal varchar(255) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, status integer not null, empresa_id bigint not null, endereco_cidade bigint, primary key (id)) engine=InnoDB
create table cliente_telefones (cliente_id bigint not null, telefones_id bigint not null) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, endereco_cidade bigint, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table pedido (id bigint not null auto_increment, data_atualizacao datetime not null, data_criacao datetime not null, valor_total decimal(19,2) not null, cliente_id bigint not null, empresa_id bigint not null, primary key (id)) engine=InnoDB
create table pedido_itens (id bigint not null auto_increment, quantidade double precision not null, valor_unitario decimal(19,2) not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, data_atualizacao datetime not null, data_criacao datetime not null, nome varchar(255) not null, status integer not null, valor_unitario decimal(19,2) not null, primary key (id)) engine=InnoDB
create table telefone (id bigint not null auto_increment, numero varchar(255) not null, tipo integer not null, cliente_id bigint not null, primary key (id)) engine=InnoDB
alter table cliente_telefones add constraint UK_9xlhxhyu3i5vw4vvg4fw63865 unique (telefones_id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table cliente add constraint FKkbui05oidjdj4nb0283u4t319 foreign key (empresa_id) references empresa (id)
alter table cliente add constraint FKjsf514thl1waovxqn18xh8hne foreign key (endereco_cidade) references cidade (id)
alter table cliente_telefones add constraint FK9fhkw2bv02pk2sypoftct8eef foreign key (telefones_id) references telefone (id)
alter table cliente_telefones add constraint FK55h0ud5ggf9e3wne0ldc9p4qu foreign key (cliente_id) references cliente (id)
alter table empresa add constraint FKmywg6e79sv13mb3irj4swg37o foreign key (endereco_cidade) references cidade (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FKt7rqpuedt7235kbgks5vdtbwi foreign key (empresa_id) references empresa (id)
alter table pedido_itens add constraint FKb5t2ga17uxph7bp32w97ssu4t foreign key (pedido_id) references pedido (id)
alter table pedido_itens add constraint FKg643g2v6jo93qic9tybfesskv foreign key (produto_id) references produto (id)
alter table telefone add constraint FK8aafha0njkoyoe3kvrwsy3g8u foreign key (cliente_id) references cliente (id)
