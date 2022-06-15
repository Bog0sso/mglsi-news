<?php
/*
    index.php : it is the main controller
    it calls the other controller depending on the 
    content of the URL REQUEST
    */

require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/category.model.php");
require_once $_SERVER['DOCUMENT_ROOT'] . ("/templates/category.template.php");

if(!isset($_GET["id"]) && !isset($_GET["categorie"])){
    require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/articles.model.php");
    $articles=getArticles();
    require_once $_SERVER['DOCUMENT_ROOT'] . ("/templates/articles.template.php");
    print("je viens");

}

if (isset($_GET["id"])) {

    require_once $_SERVER['DOCUMENT_ROOT'] . ("/controller/article.controller.php");

} 

if (isset($_GET["categorie"])) {

    require_once $_SERVER['DOCUMENT_ROOT'] . ("/controller/articlecategory.controller.php");

}
