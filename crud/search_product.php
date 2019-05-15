<?php
    include "bd_connection.php";
    $id = $_GET['id'];
    $consulta = "SELECT * FROM productos WHERE id = '$id'";
    $resultado = $connection ->query($consulta);

    while($fila = $resultado ->fetch_array()){
        $producto[] = array_map('utf8_encode',$fila);
    }

    echo json_encode($producto);
    $resultado ->close();
?>