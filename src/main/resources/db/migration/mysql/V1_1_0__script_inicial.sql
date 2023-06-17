
    create table if not exists usuarios (
       id  BIGINT(19) auto_increment not null,
       foto varchar(255),
       nome varchar(100) not null,
       senha varchar(100) not null,
       usuario varchar(255) not null,
       primary key (id)
    );

    create table if not exists clientes  (
   	    id BIGINT(19) auto_increment not null,
   		contato varchar(255),
        nome varchar(255),
        usuario_id BIGINT(19),
        primary key (id),
        foreign key (usuario_id) references usuarios(id)
        );

    create table if not exists veiculos (
       id  BIGINT(19) auto_increment not null,
        mensalidade float4,
        nome varchar(255),
        placa varchar(255),
        tipos_veiculos varchar(255),
        uber boolean,
        vencimento_boleto varchar(255),
        cliente_id BIGINT(19),
        primary key (id),
        foreign key (cliente_id) references clientes(id)
    );
