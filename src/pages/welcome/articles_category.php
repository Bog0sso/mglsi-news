<?php
require_once $_SERVER['DOCUMENT_ROOT']. "/welcome/topbar.php";
require_once $_SERVER['DOCUMENT_ROOT']. "/../config/db.php";

//SHOW ARTICLE WITH SPECIFIC CATEGORY
if(isset($_GET['categorie'])){
    $categorie=$_GET['categorie'];
    $query="SELECT Article.titre, Article.contenu, Article.dateCreation FROM Article INNER JOIN Categorie ON Article.categorie=Categorie.id  WHERE Categorie.libelle=?";
    $prepartedStatement=$connexion->prepare($query);
    $prepartedStatement->execute([$categorie]);
    $categorisedArticles=$prepartedStatement->fetch();
}
    $arrayArticles=array();
    foreach($categorisedArticles as $categorisedArticle){
        array_push($arrayArticles,$categorisedArticle);
    }

    for ($i = 1; $i <= count($arrayArticles); $i++) {
        echo "<br>$arrayArticles[$i]";
    }
?>
