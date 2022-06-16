<?php
//SHOW ARTICLES WITH SPECIFIC CATEGORY
require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/articles.model.php");
$id = (int)$_GET['id'];
$article = getArticle($id);
require_once $_SERVER['DOCUMENT_ROOT'] . ("/templates/article.template.php");
?>