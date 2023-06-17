
    create table if not exists usuarios (
       id SERIAL not null,
       foto varchar,
       nome varchar not null,
       senha varchar not null,
       usuario varchar not null,
       primary key (id)
    );

    create table if not exists clientes(
   	    id SERIAL not null,
   		contato varchar,
        nome varchar,
        usuario_id SERIAL,
        primary key (id),
        constraint fk_usuario foreign key (usuario_id) references usuarios(id)
        );

    create table if not exists veiculos (
       id SERIAL not null,
        mensalidade float4,
        nome varchar,
        placa varchar,
        tipos_veiculos varchar,
        uber boolean,
        vencimento_boleto varchar,
        cliente_id SERIAL,
        primary key (id),
        constraint fk_cliente foreign key (cliente_id) references clientes(id)
    );
