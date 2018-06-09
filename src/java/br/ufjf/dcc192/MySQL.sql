Create table USUARIO.EVENTO(codigo integer primary key GENERATED ALWAYS AS IDENTITY,
titulo varchar(400),
minimo decimal(10,2),
dataInicio timestamp not null,
dataSorteio timestamp not null,
);

Create table USUARIO.PARTICIPANTE(   id integer primary key GENERATED ALWAYS AS IDENTITY,
nome varchar(400) not null,
email varchar(400) not null,
senha varchar(400) not null,
);
