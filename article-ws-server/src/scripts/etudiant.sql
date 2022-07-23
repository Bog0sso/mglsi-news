CREATE DATABASE IF NOT EXISTS mglsi_news;
USE mglsi_news;
DROP TABLE Articles;
CREATE TABLE Articles(
    id int  auto_increment NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    CONSTRAINT pk_Articles PRIMARY KEY (id)
);

CREATE USER 'etudiant'@'%' IDENTIFIED BY 'article';
GRANT ALL PRIVILEGES on mglsi_news.* to'etudiant'@'%';