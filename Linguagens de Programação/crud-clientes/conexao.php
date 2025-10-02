<?php
$host = 'localhost';
$db = 'clientes_db';
$user = 'root';
$pass = '';

$conn = new mysqli($host, $user, $pass, $db);
echo "123";
if ($conn->connect_error) {
    die("Erro na conexão: " . $conn->connect_error);
} 
?>