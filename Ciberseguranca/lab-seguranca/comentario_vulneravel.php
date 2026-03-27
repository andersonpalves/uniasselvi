<?php include 'conexao.php'; ?>

<form method="POST">
    <input name="texto">
    <button>Enviar</button>
</form>

<?php
if ($_POST) {
    $conn->query("INSERT INTO comentarios(texto) VALUES ('{$_POST['texto']}')");
}

$res = $conn->query("SELECT * FROM comentarios");

while ($row = $res->fetch_assoc()) {
    echo "<p>" . $row['texto'] . "</p>";
}
?>