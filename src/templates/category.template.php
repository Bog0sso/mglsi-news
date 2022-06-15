<nav>
    <ul id="categories">
    <li class='categorie'><a href="./index.php"> Accueil</a>  </li>
    <?php 
            
        foreach($categories as $categorie) { ?>
            <li class='categorie'><a href="./index.php?categorie=<?= urlencode($categorie) ?>"> <?=$categorie?> </a>  </li>
    <?php } ?>
    
    </ul>
</nav>

