<?php
    require_once "../../models/articleModel.php";

    $query_articles="SELECT Article.id,titre,contenu,dateCreation,Categorie.libelle FROM Article  LEFT JOIN Categorie ON categorie = Categorie.id";
    $articles=array();
    foreach ($connexion->query($query_articles) as $row) 
    {
        // Use of the article template object // play the role of ORM 
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
<main>
    <h1> Toutes l'actualité</h1>
    <section>
        <ul id="articles">
            <?php 
                foreach($articles as $article) {?>
                        <a href='../article.php?id=<?=$article->id?>'>
                            <li>
                                <article class='article'>
                                    <h2> <?=$article->categorie?> </h2>
                                    <h3> <?=$article->titre?> </h3>
                                    <p> <?=$article->contenu?> </p>
                                    <small> <?=$article->dateCreation?> </small>
                                </article>
                            </li>
                        </a>
                <?php } ?>        
        </ul>
    </section>
</main>
