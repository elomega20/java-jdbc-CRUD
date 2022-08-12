-----------------------------------------------------------------------
-- - reconstruction de la base de donnees
-----------------------------------------------------------------------
DROP DATABASE IF EXISTS crud_db;
CREATE DATABASE crud_db;
USE crud_db;

-----------------------------------------------------------------------
-- - construction de la table etudiant
-----------------------------------------------------------------------

CREATE TABLE etudiant(
    codeEtudiant    varchar(20) PRIMARY KEY,
    login           varchar(20) NOT NULL,
    passworld       varchar(20) NOT NULL,
    nom             varchar(20) NOT NULL,
    prenom          varchar(20) NOT NULL,
    email           varchar(30) NOT NULL
);

------------------------------------------------------------------------
-- - contruction de la table module
------------------------------------------------------------------------

CREATE TABLE module(
    codeModule      varchar(20) PRIMARY KEY,
    libelle         varchar(20) NOT NULL,
    credit          int(4)      NOT NULL
);

------------------------------------------------------------------------
-- - construction de la table etudiant_module
------------------------------------------------------------------------

CREATE TABLE etudiant_module(
    codeEtudiant    varchar(20) NOT NULL,
    codeModule      varchar(20) NOT NULL,
    CONSTRAINT fk_code_etudiant FOREIGN KEY(codeEtudiant)
    REFERENCES etudiant(codeEtudiant) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_code_module FOREIGN KEY(codeModule)
    REFERENCES module(codeModule) ON DELETE CASCADE ON UPDATE CASCADE
);

