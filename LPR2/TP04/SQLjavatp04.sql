CREATE DATABASE aulajava;
GO

USE aulajava;
GO

CREATE TABLE tbcargos (
    cd_cargo smallint NOT NULL PRIMARY KEY,
    ds_cargo char(20) NULL
);
GO

CREATE TABLE tbfuncs (
    cod_func decimal(9, 0) NOT NULL PRIMARY KEY,
    nome_func char(30) NULL,
    sal_func money NULL,
    cod_cargo smallint NULL,
    CONSTRAINT FK_tbfuncs_tbcargos FOREIGN KEY (cod_cargo) REFERENCES tbcargos(cd_cargo)
);
GO

INSERT INTO tbcargos (cd_cargo, ds_cargo) VALUES
(1, 'Administrativo'),
(2, 'Desenvolvedor'),
(3, 'Analista de Sistemas');
GO

INSERT INTO tbfuncs (cod_func, nome_func, sal_func, cod_cargo) VALUES
(1001, 'Marcelo', 2000.00, 1),
(1002, 'Marcelo Silva', 4500.00, 2),
(1003, 'Marcelo Santos', 5200.50, 3),
(1004, 'Ana Paula', 3800.00, 1),
(1005, 'Carlos Eduardo', 6100.00, 2);
GO