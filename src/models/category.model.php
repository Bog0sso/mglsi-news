<?php
    // THIS MODEL FILE IS INTENDED TO GET ALL CATEGORIZE FROM THE DATABASE
    require_once $_SERVER['DOCUMENT_ROOT'].("/models/articles.model.php");
    $connexion=getDBConnection();    //get different categories from database
    $query_categories="SELECT libelle FROM Categorie";
    //insert pure database data to php array
    $categories=array();
    foreach ($connexion->query($query_categories) as $row) 
    {
    array_push($categories,$row["libelle"]);
    }
    return $categories;
?>