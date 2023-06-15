
    create table clientes if not exists (
       id  bigserial not null,
        contato varchar(255),
        nome varchar(255),
        usuario_id int8,
        primary key (id)
    );

    create table usuarios if not exists (
       id  bigserial not null,
        foto varchar(255),
        nome varchar(100) not null,
        senha varchar(100) not null,
        usuario varchar(255) not null,
        primary key (id)
    );

    create table veiculos if not exists (
       id  bigserial not null,
        mensalidade float4,
        nome varchar(255),
        placa varchar(255),
        tipos_veiculos varchar(255),
        uber boolean,
        vencimento_boleto varchar(255),
        cliente_id int8,
        primary key (id)
    );

    alter table clientes
       add constraint FKk6iwsq3kts1bblivkjy6epajx
       foreign key (usuario_id)
       references usuarios;

    alter table veiculos
       add constraint FKo6t7kavymtdqlsm2ytuyvhor2
       foreign key (cliente_id)
       references clientes;
