<?php
require_once "./welcome/topbar.php";
require_once "./../config/db.php";
if(isset($_GET['id'])){
    $id=$_GET['id'];
    $prepartedStatement=$connexion->prepare("SELECT titre,contenu,dateCreation FROM Article WHERE id=? LIMIT 1");
    $prepartedStatement->execute([$id]);
    $article=$prepartedStatement->fetch();

}

?>
<main>
    <h1></h1>
    <section> 
            <article class='article'>
                    <h2> <?=$article["categorie"]?> </h2>
                    <h3> <?=$article["titre"]?> </h3>
                    <p> <?=$article["contenu"]?> </p>
                    <small> <?=$article["dateCreation"] ?> </small>
                </article>
    </section>
</main>