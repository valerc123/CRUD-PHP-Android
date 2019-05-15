<?php

include "bd_connection.php";
$id = $_POST['id'];
$producto = $_POST['producto'];
$valor = $_POST['valor'];
$categoria = $_POST['categoria'];
$descripcion = $_POST['descripcion'];

$consulta = "UPDATE productos SET producto = '" . $producto . "',valor='" . $valor . "',categoria='" . $categoria . "',descripcion='" . $descripcion . "' WHERE id = $id";
mysqli_query($connection, $consulta);
mysqli_close($connection);
