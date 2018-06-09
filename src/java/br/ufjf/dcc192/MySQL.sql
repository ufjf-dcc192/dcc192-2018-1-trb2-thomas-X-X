Create table EVENTO(codigo integer primary key GENERATED ALWAYS AS IDENTITY,
titulo varchar(400),
minimo decimal(10,2),
dataInicio timestamp not null,
dataSorteio timestamp not null,
);

Create table PARTICPANTE(   id integer primary key GENERATED ALWAYS AS IDENTITY,
nome varchar(400) not null,
email varchar(400) not null,
senha varchar(400) not null,
);
