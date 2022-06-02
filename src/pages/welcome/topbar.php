<?php
    $query_categories="SELECT libelle FROM Categorie";
    $categories=array();
    foreach ($connexion->query($query_categories) as $row) 
    {
    array_push($categories,$row["libelle"]);
    }
//   NAVIGATION

// 

?>
<nav>
    <ul id="categories">
    <?php 
        foreach($categories as $categorie){
            echo "<li class='categorie'>$categorie</li>";
        }
    ?>
    </ul>
</nav>
