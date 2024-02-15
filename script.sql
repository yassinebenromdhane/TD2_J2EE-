DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Produits;

CREATE TABLE Users (
  login VARCHAR(255)  PRIMARY KEY ,
  mdp VARCHAR(255)
);

CREATE TABLE Produits (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    qte INT
);

-- Insertion dans la table Users
INSERT INTO Users (login, mdp) VALUES ('admin', 'password123');
INSERT INTO Users (login, mdp) VALUES ('user1', 'azerty123');

-- Insertion dans la table Produits
INSERT INTO Produits (id, nom, qte) VALUES (1, 'Produit 1', 10);
INSERT INTO Produits (id, nom, qte) VALUES (2, 'Produit 2', 20);