<?php include 'conexao.php'; ?>

<form method="POST">
    <input name="texto">
    <button>Enviar</button>
</form>

<?php
if ($_POST) {
    $stmt = $conn->prepare("INSERT INTO comentarios(texto) VALUES (?)");
    $stmt->bind_param("s", $_POST['texto']);
    $stmt->execute();
}

$res = $conn->query("SELECT * FROM comentarios");

while ($row = $res->fetch_assoc()) {
    echo "<p>" . htmlspecialchars($row['texto'], ENT_QUOTES, 'UTF-8') . "</p>";
}
?>