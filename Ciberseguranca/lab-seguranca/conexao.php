<?php
$conn = new mysqli("localhost", "root", "", "lab_seguranca");

if ($conn->connect_error) {
    die("Erro: " . $conn->connect_error);
}

session_start();
?>