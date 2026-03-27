<?php 
/*include 'conexao.php';

if (!isset($_SESSION['usuario'])) {
    die("Acesso negado");
}*/
?>

<h2>Área Admin</h2>
<p>Bem-vindo <?php echo $_SESSION['usuario']; ?></p>

<a href="logout.php">Sair</a>