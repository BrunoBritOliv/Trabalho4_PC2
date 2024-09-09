CREATE TABLE cliente
(
	codCliente int not null,
	nomeCliente varchar(50) not null,
	rgCliente varchar(20) not null,
	endereco text,
	bairro text,
	cidade text,
	estado text,
	cepCliente text,
	nascCliente date,
	PRIMARY KEY (codCliente)
);

CREATE TABLE chale
(
	codChale int not null,
	localizacao text,
	capacidade int,
	valorAltaEstacao decimal(8,2),
	valorBaixaEstacao decimal(8,2),
	PRIMARY KEY (codChale)
);

CREATE TABLE hospedagem
(
	codHospedagem int not null,
	codChale int not null,
	codCliente int not null,
	estado text,
	dataInicio date,
	dataFim date,
	qtdPessoas int,
	desconto decimal(8,2),
	valorFinal decimal(8,2),
	PRIMARY KEY (codHospedagem),
	FOREIGN KEY (codChale) REFERENCES chale (codChale),
	FOREIGN KEY (codCliente) REFERENCES cliente (codCliente)
);