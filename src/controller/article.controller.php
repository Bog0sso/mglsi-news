<?php
$id = $_GET['id'];
require_once $_SERVER['DOCUMENT_ROOT'] . ("/models/articles.model.php");
$article = getArticle($id);
require_once $_SERVER['DOCUMENT_ROOT'] . ("/templates/article.template.php");
?>