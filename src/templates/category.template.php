<nav>
    <ul id="categories">
    <?php 
        foreach($categories as $categorie) { ?>
            <li class='categorie'><a href="./articlecategory.controller.php?categorie=<?= urlencode($categorie) ?>"> <?=$categorie?> </a>  </li>
    <?php } ?>
    
    </ul>
</nav>

