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