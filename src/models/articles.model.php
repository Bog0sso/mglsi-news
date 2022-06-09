<?php
    class Article{
        public $id;
        public $titre;
        public $contenu;
        public $dateCreation;
        public $categorie;
    }
    $query_articles="SELECT Article.id,titre,contenu,dateCreation,Categorie.libelle FROM Article  LEFT JOIN Categorie ON categorie = Categorie.id";
    $articles=array();
    foreach ($connexion->query($query_articles) as $row) 
    {
        // Use of the article template object | plays the role of ORM 
        $article=new Article();
        $article->id=$row["id"];
        $article->categorie=$row["libelle"];
        $article->titre=$row["titre"];
        $article->contenu=$row["contenu"];
        $article->dateCreation=$row["dateCreation"];
        $article->dateCreation=substr($article->dateCreation,0,10);
        array_push($articles,$article);
    }

?>