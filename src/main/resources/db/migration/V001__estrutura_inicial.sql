
create table usuario(
id bigint auto_increment not null,
nome varchar(100) not null,
usuario varchar(100) not null,
senha varchar(200) not null,
foto varchar(100) not null,
primary key(id)
);


create table imagem (
id bigint auto_increment not null ,
url varchar(100) not null,
primary key(id)
);

create table veiculo (
id bigint auto_increment,
nome varchar(100) not null,
placa varchar(15) not null,
tipo_veiculo varchar(20) not null,
uber boolean default(false) not null,
mensalidade decimal(5,2) not null,
vencimento_boleto varchar(2) not null,
imagem_id bigint,
primary key(id),
foreign key(imagem_id) references imagem(id)
);

create table cliente (
	id bigint auto_increment not null,
    nome varchar(100) not null,
    contato varchar(11) not null,
    veiculo_id bigint,
    usuario_id bigint,
    primary key(id),
    foreign key(usuario_id) references usuario(id),
    foreign key(veiculo_id) references veiculo(id)
);