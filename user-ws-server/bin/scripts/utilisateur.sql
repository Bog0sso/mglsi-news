CREATE TABLE Utilisateur(
    id INTEGER AUTO_INCREMENT,
    login VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_Utilisateur PRIMARY KEY (id)
);