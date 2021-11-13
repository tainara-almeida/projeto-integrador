
/* LEGENDA SIGLAS BANCO DE DADOS
	COD = CODIGO 	EXE: COD_PRODUTO
	NM 	= NOME 		EXE: NM_PRODUTO
    DC 	= DESCRICAO EXE: DC_PRODUTO
    DT  = DATA		EXE: DT_PEDIDO
    VL  = VALOR 	EXE: VL_PRODUTO
    NR  = NUMERO	EXE: NR_QUANTIDADE
    
    VL -> PARA NUMEROS DE PONTO FLUTUANTE EXE: 12,5
    NR -> PARA NUMEROS INTEIROS	EXE: 12

    */

CREATE DATABASE LOJA_BRINQUEDOS;

USE LOJA_BRINQUEDOS;

DROP TABLE ESTRUTURA;
CREATE TABLE ESTRUTURA(
	COD_ESTRUTURA INT AUTO_INCREMENT,
    COD_EMPRESA INT NOT NULL,
    COD_SETOR INT NOT NULL,
    COD_FUNCIONARIO INT NOT NULL,
    PRIMARY KEY (COD_ESTRUTURA)
);

DROP TABLE EMPRESA;
CREATE TABLE EMPRESA(
	COD_EMPRESA INT AUTO_INCREMENT,
    DC_ENDERECO VARCHAR(100) NOT NULL,
    NM_EMPRESA VARCHAR(100) NOT NULL,
    DC_CNPJ VARCHAR(14) NOT NULL,
    PRIMARY KEY (COD_EMPRESA)
);

DROP TABLE SETOR;
CREATE TABLE SETOR(
	COD_SETOR INT AUTO_INCREMENT,
    NM_SETOR VARCHAR(50) NOT NULL,
    PRIMARY KEY (COD_SETOR)
);

DROP TABLE FUNCIONARIO;
CREATE TABLE FUNCIONARIO(
	COD_FUNCIONARIO INT AUTO_INCREMENT,
    NM_FUNCIONARIO VARCHAR(100) NOT NULL,
    DC_CPF VARCHAR(16) UNIQUE NOT NULL,
	DC_EMAIL VARCHAR(100),
    DT_NASCIMENTO DATE,
    DC_TELEFONE VARCHAR(15),
    DC_ENDERECO VARCHAR(100),
    PRIMARY KEY (COD_FUNCIONARIO)
);

DROP TABLE ACESSO;
CREATE TABLE ACESSO(
	COD_FUNCIONARIO INT NOT NULL,
    DC_LOGIN VARCHAR(50) NOT NULL,
    DC_SENHA VARCHAR(50) NOT NULL
);

DROP TABLE CLIENTE;
CREATE TABLE CLIENTE(
	COD_CLIENTE INT AUTO_INCREMENT,
    DC_CPF VARCHAR(16) UNIQUE NOT NULL,
    NM_CLIENTE VARCHAR(40) NOT NULL,
    DC_EMAIL VARCHAR(40) NOT NULL,
    DT_NASCIMENTO DATE NOT NULL, 
    DC_TELEFONE VARCHAR(15) NOT NULL,
    DC_ENDERECO VARCHAR(100) NOT NULL,
    PRIMARY KEY (COD_CLIENTE)
);

DROP TABLE PRODUTO;
CREATE TABLE PRODUTO (
    COD_PRODUTO INT AUTO_INCREMENT,
    DC_CATEGORIA_PRODUTO VARCHAR(50) NOT NULL,
    NM_PRODUTO VARCHAR(50) NOT NULL,
    DC_PRODUTO VARCHAR(50) NULL,
    DC_CLASSIFICACAO_IDADE VARCHAR(10) NULL,
    VL_PRECO_UNITARIO DOUBLE NOT NULL,
    DC_IMG_URL VARCHAR(100) NOT NULL,
    PRIMARY KEY (COD_PRODUTO)
);

DROP TABLE ESTOQUE;
CREATE TABLE ESTOQUE (
	COD_ESTOQUE INT AUTO_INCREMENT,
    COD_PRODUTO INT NOT NULL,
    DC_CODIGO_BARRAS VARCHAR(50) NOT NULL,
    NR_QUANTIDADE INT NOT NULL,
    PRIMARY KEY (COD_ESTOQUE),
	FOREIGN KEY (COD_PRODUTO) REFERENCES PRODUTO(COD_PRODUTO)
);

DROP TABLE ITEM_PEDIDO;
CREATE TABLE ITEM_PEDIDO (
	COD_ITEM_PEDIDO INT AUTO_INCREMENT,
    COD_PRODUTO INT,
	NR_QUANTIDADE INT NOT NULL,
    VL_PRECO_UNITARIO DOUBLE NOT NULL,
    PRIMARY KEY (COD_ITEM_PEDIDO),
    FOREIGN KEY (COD_PRODUTO) REFERENCES PRODUTO(COD_PRODUTO)
); 

DROP TABLE PEDIDO;
CREATE TABLE PEDIDO (
	COD_PEDIDO INT AUTO_INCREMENT,
    COD_ITEM_PEDIDO INT,
    DC_STATUS_PEDIDO VARCHAR(50),
    VL_TOTAL_PEDIDO DOUBLE,
	PRIMARY KEY (COD_PEDIDO),
    FOREIGN KEY (COD_ITEM_PEDIDO) REFERENCES ITEM_PEDIDO(COD_ITEM_PEDIDO)
);

DROP TABLE VENDA;
CREATE TABLE VENDA (
	COD_VENDA INT AUTO_INCREMENT,
    COD_PEDIDO INT NOT NULL,
    COD_CLIENTE INT NOT NULL,
    VL_TOTAL_VENDA DOUBLE NOT NULL,
    DT_VENDA DATE NOT NULL, 
    DC_STATUS_VENDA VARCHAR(25) NOT NULL, 
	PRIMARY KEY (COD_VENDA),
	FOREIGN KEY (COD_PRODUTO) REFERENCES PRODUTO(COD_PRODUTO),
	FOREIGN KEY (COD_CLIENTE) REFERENCES CLIENTE(COD_CLIENTE)
);

/* DEFINIR SE SERÁ NECESSARIO A TABELA ESTOQUE, PRODUTO JÁ DEVE GERENCIAR TODO ESSE PROCESSO DE CONTROLE DE ESTOQUE
(ENTRADA E SAIDA / QUANTIDADE DE ITENS A SEREM VENDIDOS) */

/* PROCEDURES 

	LEGENDA PROCEDURES
		
	SPS = STORAGE PROCEDURE SELECT
    SPI = STORAGE PROCEDURE INSERT
    SPD = STORAGE PROCEDURE DELETE
    SPU = STORAGE PROCEDURE UPDATE
    */

USE LOJA_BRINQUEDOS;

/*CRIAR PROCEDURE*/
DELIMITER $$
CREATE PROCEDURE SPI_FUNCIONARIO(
	IN PAR_NM_FUNCIONARIO 	VARCHAR(100),
    IN PAR_DC_CPF			VARCHAR(16),
    IN PAR_DC_EMAIL			VARCHAR(100),
	IN PAR_DT_NASCIMENTO	DATE,
	IN PAR_DC_TELEFONE		VARCHAR(15),
    IN PAR_DC_ENDERECO		VARCHAR(100))
BEGIN
INSERT INTO FUNCIONARIO (
	NM_FUNCIONARIO,
    DC_CPF,
    DC_EMAIL,
    DT_NASCIMENTO,
    DC_TELEFONE,
    DC_ENDERECO)
VALUES(
	PAR_NM_FUNCIONARIO,
	PAR_DC_CPF,
	PAR_DC_EMAIL,
    PAR_DT_NASCIMENTO,
    PAR_DC_TELEFONE,
    PAR_DC_ENDERECO);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SPI_CLIENTE(
	IN PAR_NM_CLIENTE		VARCHAR(100),
    IN PAR_DC_CPF			VARCHAR(16),
    IN PAR_DC_EMAIL			VARCHAR(100),
	IN PAR_DT_NASCIMENTO	DATE,
	IN PAR_DC_TELEFONE		VARCHAR(15),
    IN PAR_DC_ENDERECO		VARCHAR(100))
BEGIN
INSERT INTO CLIENTE (
	NM_CLIENTE,
    DC_CPF,
    DC_EMAIL,
    DT_NASCIMENTO,
    DC_TELEFONE,
    DC_ENDERECO)
VALUES(
	PAR_NM_CLIENTE,
	PAR_DC_CPF,
	PAR_DC_EMAIL,
    PAR_DT_NASCIMENTO,
    PAR_DC_TELEFONE,
    PAR_DC_ENDERECO);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SPI_PRODUTO(
	IN PAR_DC_CATEGORIA_PRODUTO		VARCHAR(50),
    IN PAR_NM_PRODUTO				VARCHAR(50),
    IN PAR_DC_PRODUTO				VARCHAR(50),
	IN PAR_DC_CLASSIFICACAO_IDADE	VARCHAR(10),
	IN PAR_VL_PRECO_UNITARIO		DOUBLE,
    IN PAR_DC_IMG_URL				VARCHAR(100))
BEGIN
INSERT INTO PRODUTO (
	DC_CATEGORIA_PRODUTO,
	NM_PRODUTO,
	DC_PRODUTO,
	DC_CLASSIFICACAO_IDADE,
    VL_PRECO_UNITARIO,
    DC_IMG_URL)
VALUES(
	PAR_DC_CATEGORIA_PRODUTO,	
    PAR_NM_PRODUTO,			
    PAR_DC_PRODUTO,			
    PAR_DC_CLASSIFICACAO_IDADE,
    PAR_VL_PRECO_UNITARIO,	
    PAR_DC_IMG_URL);		
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SPI_SETOR(
	IN PAR_NM_SETOR	VARCHAR(50))
BEGIN
INSERT INTO SETOR (
	NM_SETOR)
VALUES(
	PAR_NM_SETOR);		
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SPI_EMPRESA(
	IN PAR_DC_ENDERECO	VARCHAR(100),
    IN PAR_NM_EMPRESA	VARCHAR(100),
    IN PAR_DC_CNPJ		VARCHAR(14))
BEGIN
INSERT INTO EMPRESA (
	DC_ENDERECO,	
	NM_EMPRESA,	    
	DC_CNPJ)	
VALUES(
	PAR_DC_ENDERECO,	
    PAR_NM_EMPRESA,	
    PAR_DC_CNPJ);		
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SPI_ESTRUTURA(
    IN PAR_COD_EMPRESA INT,
    IN PAR_COD_SETOR INT,
    IN PAR_COD_FUNCIONARIO INT)
BEGIN
INSERT INTO ESTRUTURA (
	COD_EMPRESA,
	COD_SETOR,
	COD_FUNCIONARIO)
VALUES(
	PAR_COD_EMPRESA,
	PAR_COD_SETOR,
	PAR_COD_FUNCIONARIO);
END $$
DELIMITER ;

-- RELAÇÃO FUNCIONARIOS, SETOR, EMPRESA
SELECT A.*, B.NM_FUNCIONARIO, C.NM_SETOR, D.NM_EMPRESA FROM ESTRUTURA A
INNER JOIN FUNCIONARIO B
ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO
INNER JOIN SETOR C
ON A.COD_SETOR = C.COD_SETOR
INNER JOIN EMPRESA D
ON A.COD_EMPRESA = D.COD_EMPRESA
WHERE B.COD_FUNCIONARIO = 6;

-- PESQUISA FUNCIONARIO POR NOME
SELECT A.*, B.NM_FUNCIONARIO, C.NM_SETOR, D.NM_EMPRESA FROM ESTRUTURA A
INNER JOIN FUNCIONARIO B
ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO
INNER JOIN SETOR C
ON A.COD_SETOR = C.COD_SETOR
INNER JOIN EMPRESA D
ON A.COD_EMPRESA = D.COD_EMPRESA
WHERE B.NM_FUNCIONARIO LIKE '%Y%';

-- PESQUISA FUNCIONARIO POR SETOR
SELECT A.*, B.NM_FUNCIONARIO, C.NM_SETOR, D.NM_EMPRESA FROM ESTRUTURA A
INNER JOIN FUNCIONARIO B
ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO
INNER JOIN SETOR C
ON A.COD_SETOR = C.COD_SETOR
INNER JOIN EMPRESA D
ON A.COD_EMPRESA = D.COD_EMPRESA
WHERE C.COD_SETOR = 1;

-- PESQUISA FUNCIONARIO POR SETOR
SELECT A.*, B.NM_FUNCIONARIO, C.NM_SETOR, D.NM_EMPRESA FROM ESTRUTURA A
INNER JOIN FUNCIONARIO B
ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO
INNER JOIN SETOR C
ON A.COD_SETOR = C.COD_SETOR
INNER JOIN EMPRESA D
ON A.COD_EMPRESA = D.COD_EMPRESA
WHERE C.COD_SETOR = 1;

/*
  EXECUTAR PROCEDURE
  TABELA DE FUNCIONARIO FAZER INSERTS COM OS INTEGRANTES DO GRUPO,
  TABELA DE CLEINTE FAZER UNS 15 INSERTS
  TABELA DE PRODUTO FAZER UNS 15 INSERTS
  PRA EXECUTAR A PROCEDURE USAR OS EXEMPLOS ABAIXO
*/

CALL SPI_FUNCIONARIO('MATHEUS', '87609836220', 'MATHEUS.TESTE@HOTMAIL.COM', '20020724', '(11) 983746153', 'RUA POPPYZINHA');
CALL SPI_FUNCIONARIO('TAINARA', '15648698702', 'TAINARA.TESTE@HOTMAIL.COM', '19990711', '11994574825', 'RUA SENAC, 40');
CALL SPI_FUNCIONARIO('VITOR AKIRA', '12598632584','AKIRA.TESTE@HOTMAIL.COM', '20000217', '11455632541', 'RUA BENTO, 30');
CALL SPI_FUNCIONARIO('ANDREW', '15489326457', 'ANDREW.TESTE@HOTMAIL.COM', '20010521', '11566842375', 'RUA ALCINO FERREIRA, 55');
CALL SPI_FUNCIONARIO('YVENS', '58932101484', 'YVENS.TESTE@HOTMAIL.COM', '20000217', '11455847845', 'RUA INTERLAGOS, 114');
CALL SPI_FUNCIONARIO('JOAO', '65487693123', 'JOAO.TESTE@HOTMAIL.COM', '20010118', '11876953422', 'RUA MANUEL FREITAS, 87');

CALL SPI_CLIENTE('MATHEUS', '876.098.362-20', 'MATHEUS.TESTE@HOTMAIL.COM', '2002-07-24', '(11) 983746153', 'RUA POPPYZINHA');
CALL SPI_CLIENTE('ANTONIO', '10977978052', 'ANTONIO.FREITAS@GMAIL.COM', '19800504', '11455214896', 'RUA ANTONIA NEVES, 25');
CALL SPI_CLIENTE('MARIA', '25948788040', 'MARIA.ALMEIDA@GMAIL.COM', '19990612', '11589541235', 'RUA AFONSO MEIRES, 255');
CALL SPI_CLIENTE('CARLOS', '86921248003', 'CARLOS.FERREIRA@HOTMAIL.COM', '20011205', '11256312485', 'RUA PANDORA, 35A');
CALL SPI_CLIENTE('EDUARDA', '78378423085', 'EDUARDA.SANTOS@GMAIL.COM', '20000415', '11895478523', 'RUA NELSON, 78');
CALL SPI_CLIENTE('GIOVANNA', '35151354051', 'GIOVANNA.ANDRADE@GMAIL.COM', '19980526', '11852346174', 'RUA JUMA, 15');
CALL SPI_CLIENTE('JOAO', '33805827008', 'JOAO.PEREIRA@GMAIL.COM', '20000516', '11563214785', 'RUA ALEM DOURO, 445');
CALL SPI_CLIENTE('JHONATAN', '60579330010', 'JHONATAN.SILVA@GMAIL.COM', '20020915', '11456214785', 'RUA LUISA RIBEIRO, 500');
CALL SPI_CLIENTE('CAMILA', '90344815064', 'CAMILA.ALVARES@HOTMAIL.COM', '19990819', '11548752156', 'RUA MANUEL CALDEIRA, 750');
CALL SPI_CLIENTE('CARLA', '63308781026', 'CARLA.SOARES@GMAIL.COM', '20000518', '11953147854', 'RUA GILBERTO FREIRE, 56');
CALL SPI_CLIENTE('JORGE', '43504424052', 'JORGE.BATISTA@OUTLOOK.COM', '19980504', '1197412354', 'RUA GOMES ESPERANÇA, 30C');
CALL SPI_CLIENTE('MATHEUS', '34024189085', 'MATHEUS.SALES@HOTMAIL.COM', '20010830', '11965124153', 'RUA SILVES, 45');
CALL SPI_CLIENTE('TIAGO', '62303452007', 'TIAGO.SANTOS@GMAIL.COM', '20000807', '11852146574', 'RUA ALBERTO ALVANI, 150');
CALL SPI_CLIENTE('VITOR', '46566561005', 'VITOR.MENDES@HOTMAIL.COM', '20021125', '11852102147', 'RUA ENVIRA, 566');
CALL SPI_CLIENTE('SARAH', '04003907019', 'SARAH.ALVES@OUTLOOK.COM', '20000625', '11452369875','RUA GUARUVA, 155');


CALL SPI_PRODUTO('PELUCIAS', 'URSO', 'URSO POLAR', '+4', 10, 'IMG.ULR');
CALL SPI_PRODUTO('CONTROLE REMOTO', 'CARROS', 'CARRINHO', '+8', 20, 'IMG.URL');
CALL SPI_PRODUTO('ACTION FIGURE', 'MARVEL', 'HOMEM DE FERRO', '+12', 15, 'IMG.URL');
CALL SPI_PRODUTO('ACTION FIGURE', 'MARVEL', 'HULK', '+12', 16, 'IMG.URL');
CALL SPI_PRODUTO('ACTION FIGURE', 'BANDAI', 'GOKU', '+12', 25, 'IMG.URL');
CALL SPI_PRODUTO('ACTION FIGURE', 'BANDAI', 'VEGETA', '+12', 20, 'IMG.URL');
CALL SPI_PRODUTO('ACTION FIGURE', 'MARVEL', 'HOMEM ARANHA', 15, '+12', 'IMG.URL');
CALL SPI_PRODUTO('PUZZLE', 'MATTEL', 'QUEBRA CABEÇA', '+10', 23, 'IMG.URL');
CALL SPI_PRODUTO('PUZZLE', 'CUBO', 'CUBO MAGICO 3X3', '+13', 15, 'IMG.URL');
CALL SPI_PRODUTO('PUZZLE', 'CUBO', 'CUBO MAGICO 4X4', '+13', 15, 'IMG.URL');
CALL SPI_PRODUTO('PUZZLE', 'CUBO', 'CUBO MAGICO 5X5', '+13', 12, 'IMG.URL');
CALL SPI_PRODUTO('PELUCIA', 'PERSONAGEM', 'HARRY POTTER', '+4', 15, 'IMG.URL');
CALL SPI_PRODUTO('COLECIONAVEIS', 'CAVALEIROS DO ZODIACO', 'CAMUS DE AQUARIO', '+17', 15, 'IMG.URL');
CALL SPI_PRODUTO('COLECIONAVEIS', 'CAVALEIROS DO ZODIACO', 'SAGA DE GEMEMOS', '+17', 15, 'IMG.URL');
CALL SPI_PRODUTO('COLECIONAVEIS', 'CAVALEIROS DO ZODIACO', 'ALDEBARAN DE TOURO', '+17', 15, 'IMG.URL');

CALL SPI_SETOR('VENDAS');
CALL SPI_SETOR('ADMINISTRACAO');
CALL SPI_SETOR('ESTOQUE');
CALL SPI_SETOR('T.I');

CALL SPI_EMPRESA('AVENIDA QUINZE DE MAIO, 503', 'MATRIZ - SENAC TOYS',  '47221915000190');
CALL SPI_EMPRESA('AVENIDA ROBERTO FRAGA, 180', 'FILIAL - SENAC TOYS', '21478034000166');
CALL SPI_EMPRESA('AVENIDA GERALDO MAIA, 76', 'FILIAL - SENAC TOYS', '08344963000114');

CALL SPI_ESTRUTURA(1,4,6);
CALL SPI_ESTRUTURA(2,1,5);
CALL SPI_ESTRUTURA(2,3,4);
CALL SPI_ESTRUTURA(3,2,3);
CALL SPI_ESTRUTURA(3,1,2);
CALL SPI_ESTRUTURA(1,3,1);
