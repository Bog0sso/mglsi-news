<?php

    //SHOW ARTICLES WITH SPECIFIC CATEGORY
    require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/articles.model.php");
    $categorie=$_GET['categorie'];
    $articles=getCategorizedArticles($categorie);
    require_once $_SERVER['DOCUMENT_ROOT'] . ("/templates/articles.templates.php");
?>