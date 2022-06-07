<?php
/*
FILE:   THIS IS A CONFIGURATION FILE FOR ESTABLISHING CONNECTION TO A DATABASE 
AUTHOR: Abdoulaye SAMBE 
 */
$servername = "localhost";
$username = "mglsi_user";
$password = "passer";
$database="mglsi_news";
try {
  $connexion = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
  // set the PDO error mode to exception
  $connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  // print "Connected successfully";
} catch(PDOException $e) {
  print "Connection failed: " . $e->getMessage();
}
?>