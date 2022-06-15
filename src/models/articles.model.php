<?php
require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/articles.model.php");

class Article
{
    public $id;
    public $titre;
    public $contenu;
    public $dateCreation;
    public $categorie;
}

function getArticles()
{
    $connexion = getDBConnection();

    $query_articles = "SELECT Article.id,titre,contenu,dateCreation,Categorie.libelle FROM Article  LEFT JOIN Categorie ON categorie = Categorie.id";
    $articles = array();
    foreach ($connexion->query($query_articles) as $row) {
        // Use of the article template object | plays the role of ORM 
        $article = new Article();
        $article->id = $row["id"];
        $article->categorie = $row["libelle"];
        $article->titre = $row["titre"];
        $article->contenu = $row["contenu"];
        $article->dateCreation = $row["dateCreation"];
        $article->dateCreation = substr($article->dateCreation, 0, 10);
        array_push($articles, $article);
    }
    return $articles;
}

function getArticle($id)
{
    $connexion = getDBConnection();
    $prepartedStatement = $connexion->prepare("SELECT titre,contenu,dateCreation FROM Article WHERE id=? LIMIT 1");
    $prepartedStatement->execute([$id]);
    $article = $prepartedStatement->fetch();
    return $article;
}

function getCategorizedArticles($categorie)
{
    $connexion = getDBConnection();
    $query = "SELECT Article.titre, Article.contenu, Article.dateCreation FROM Article INNER JOIN Categorie ON Article.categorie=Categorie.id  WHERE Categorie.libelle=?";
    $prepartedStatement = $connexion->prepare($query);
    $prepartedStatement->execute([$categorie]);
    $article = $prepartedStatement->fetchAll();
    return $article;

}

function getDBConnection()
{
    $servername = "localhost";
    $username = "mglsi_user";
    $password = "passer";
    $database = "mglsi_news";
    try {
        $connexion = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
        // set the PDO error mode to exception
        $connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        // print "Connected successfully";
    } catch (PDOException $e) {
        print "Connection failed: " . $e->getMessage();
    }
    return $connexion;
}
