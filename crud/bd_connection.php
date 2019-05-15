<?php
error_reporting(0);
    $hostname = 'localhost';
    $database = 'crudandroid';
    $username = 'root';
    $password = '';

    $connection = new mysqli($hostname,$username,$password,$database);
    if($connection->connect_errno){
        echo "Conection problem";
    }
?>