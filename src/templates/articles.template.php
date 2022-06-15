<main>
    <h1> Toute l'actualité</h1>
    <section>
        <ul id="articles">
            <?php
            foreach ($articles as $article) { ?>
                <a href='../article.controller.php?id=<?= $article->id ?>'>
                    <li>
                        <article class='article'>
                            <h2> <?= $article->categorie ?> </h2>
                            <h3> <?= $article->titre ?> </h3>
                            <p> <?= $article->contenu ?> </p>
                            <small> <?= $article->dateCreation ?> </small>
                        </article>
                    </li>
                </a>
            <?php } ?>
        </ul>
    </section>
</main>