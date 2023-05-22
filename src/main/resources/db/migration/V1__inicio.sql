    create table corretores (
       id_cliente  bigserial not null,
        contato varchar(255),
        nome varchar(255),
        usuario_id int8,
        primary key (id_cliente)
    );

    create table imagens (
       id_imagem  bigserial not null,
        base64 varchar(255),
        veiculo_id_veiculo int8,
        primary key (id_imagem)
    );

    create table tipos_veiculos (
       id_tipo_veiculo  bigserial not null,
        tipo_veiculo varchar(255),
        primary key (id_tipo_veiculo)
    );

    create table usuarios (
       id  bigserial not null,
        foto varchar(255),
        nome varchar(100) not null,
        senha varchar(100) not null,
        usuario varchar(255) not null,
        primary key (id)
    );

    create table veiculos (
       id_veiculo  bigserial not null,
        mensalidade float4 not null,
        nome varchar(255),
        placa varchar(255),
        uber boolean not null,
        vencimento_boleto varchar(255),
        cliente_id_cliente int8,
        tipos_veiculos_id_tipo_veiculo int8,
        primary key (id_veiculo)
    );

    alter table corretores
       add constraint FKmrpljmdlthvpufkrgn5cuw7l4
       foreign key (usuario_id)
       references usuarios;

    alter table imagens
       add constraint FK32tvg4de0cct4uha178vinn7u
       foreign key (veiculo_id_veiculo)
       references veiculos;

    alter table veiculos
       add constraint FK7ljg1am3c0d0c9xb1pol1ugyh
       foreign key (cliente_id_cliente)
       references corretores;

    alter table veiculos
       add constraint FKlqpoem1p640hass0aijr69jqd
       foreign key (tipos_veiculos_id_tipo_veiculo)
       references tipos_veiculos;

    create table corretores (
       id_cliente  bigserial not null,
        contato varchar(255),
        nome varchar(255),
        usuario_id int8,
        primary key (id_cliente)
    );

    create table imagens (
       id_imagem  bigserial not null,
        base64 varchar(255),
        veiculo_id_veiculo int8,
        primary key (id_imagem)
    );

    create table tipos_veiculos (
       id_tipo_veiculo  bigserial not null,
        tipo_veiculo varchar(255),
        primary key (id_tipo_veiculo)
    );

    create table usuarios (
       id  bigserial not null,
        foto varchar(255),
        nome varchar(100) not null,
        senha varchar(100) not null,
        usuario varchar(255) not null,
        primary key (id)
    );

    create table veiculos (
       id_veiculo  bigserial not null,
        mensalidade float4 not null,
        nome varchar(255),
        placa varchar(255),
        uber boolean not null,
        vencimento_boleto varchar(255),
        cliente_id_cliente int8,
        tipos_veiculos_id_tipo_veiculo int8,
        primary key (id_veiculo)
    );

    alter table corretores
       add constraint FKmrpljmdlthvpufkrgn5cuw7l4
       foreign key (usuario_id)
       references usuarios;

    alter table imagens
       add constraint FK32tvg4de0cct4uha178vinn7u
       foreign key (veiculo_id_veiculo)
       references veiculos;

    alter table veiculos
       add constraint FK7ljg1am3c0d0c9xb1pol1ugyh
       foreign key (cliente_id_cliente)
       references corretores;

    alter table veiculos
       add constraint FKlqpoem1p640hass0aijr69jqd
       foreign key (tipos_veiculos_id_tipo_veiculo)
       references tipos_veiculos;

    create table corretores (
       id_cliente  bigserial not null,
        contato varchar(255),
        nome varchar(255),
        usuario_id int8,
        primary key (id_cliente)
    );

    create table imagens (
       id_imagem  bigserial not null,
        base64 varchar(255),
        veiculo_id_veiculo int8,
        primary key (id_imagem)
    );

    create table tipos_veiculos (
       id_tipo_veiculo  bigserial not null,
        tipo_veiculo varchar(255),
        primary key (id_tipo_veiculo)
    );

    create table usuarios (
       id  bigserial not null,
        foto varchar(255),
        nome varchar(100) not null,
        senha varchar(100) not null,
        usuario varchar(255) not null,
        primary key (id)
    );

    create table veiculos (
       id_veiculo  bigserial not null,
        mensalidade float4 not null,
        nome varchar(255),
        placa varchar(255),
        uber boolean not null,
        vencimento_boleto varchar(255),
        cliente_id_cliente int8,
        tipos_veiculos_id_tipo_veiculo int8,
        primary key (id_veiculo)
    );

    alter table corretores
       add constraint FKmrpljmdlthvpufkrgn5cuw7l4
       foreign key (usuario_id)
       references usuarios;

    alter table imagens
       add constraint FK32tvg4de0cct4uha178vinn7u
       foreign key (veiculo_id_veiculo)
       references veiculos;

    alter table veiculos
       add constraint FK7ljg1am3c0d0c9xb1pol1ugyh
       foreign key (cliente_id_cliente)
       references corretores;

    alter table veiculos
       add constraint FKlqpoem1p640hass0aijr69jqd
       foreign key (tipos_veiculos_id_tipo_veiculo)
       references tipos_veiculos;
