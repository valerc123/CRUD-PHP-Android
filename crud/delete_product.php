<?php
include "bd_connection.php";
$id = $_POST['id'];
$consulta = "DELETE FROM productos WHERE id = $id";
mysqli_query($connection,$consulta);
mysqli_close($connection);