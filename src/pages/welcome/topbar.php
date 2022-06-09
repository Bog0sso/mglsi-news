
<?php
    require_once  $_SERVER['DOCUMENT_ROOT'].'./../config/db.php';
    //get different categories from database
    $query_categories="SELECT libelle FROM Categorie";
    //insert pure database data to php array
    $categories=array();
    foreach ($connexion->query($query_categories) as $row) 
    {
    array_push($categories,$row["libelle"]);
    }
?>

<nav>
    <ul id="categories">
    <?php 
        foreach($categories as $categorie) { ?>
            <li class='categorie'><a href="./articles_category.php?categorie=<?=$categorie?>"> <?=$categorie?> </a>  </li>
    <?php } ?>
    
    </ul>
</nav>

