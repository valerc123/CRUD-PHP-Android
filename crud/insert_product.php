<?php
    include "bd_connection.php";
    $id = $_POST['id'];
    $producto = $_POST['producto'];
    $valor = $_POST['valor'];
    $categoria = $_POST['categoria'];
    $descripcion = $_POST['descripcion'];

    $consulta = "INSERT INTO productos(id,producto,valor,categoria,descripcion) VALUES(".$id.",'".$producto."','".$valor."','".$categoria."','".$descripcion."')";
    mysqli_query($connection,$consulta);
    mysqli_close($connection);

?>