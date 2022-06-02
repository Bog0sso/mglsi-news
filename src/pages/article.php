<?php
if(isset($_GET['id'])){
    $id=$_GET['id'];
    echo "Valeur de ID".$id;
}

?>

<main>
    <h1></h1>
    <section>
            <?php 
                foreach($articles as $article){
                    echo 
                        "<article class='article' href=''>
                            <h2>$article->categorie</h2><h3>$article->titre</h3>
                            <p>$article->contenu</p>
                            <small>$article->dateCreation</small>
                        </article>";
                }
            ?>
    </section>
</main>