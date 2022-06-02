<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LUX-News</title>
    <!-- STYLESHEET -->
    <link rel="stylesheet" href="./welcome.css">
    <!-- STYLESHEET -->

</head>
<body>
    <!-- TOPBAR -->
    <?php
    require_once "../../config/db.php";
    require_once "./topbar.php";
    
    // <!-- CONTENT -->
    require_once "./articles.php";

    ?>

</body>
</html>
