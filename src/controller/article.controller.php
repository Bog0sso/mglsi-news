<?php
    if(!isset($_GET["id"]) && !isset($_GET["categorie"])){
        require_once "./../models/article.model.php";
        require_once "./../views/articles.view.php";
    }
?>