<?php
include 'conexao.php';

// Verifica se o ID foi passado
$id = $_GET['id'] ?? null;
if (!$id) {
    header("Location: index.php");
    exit;
}

// Busca o cliente pelo ID
$stmt = $conn->prepare("SELECT * FROM clientes WHERE id = ?");
$stmt->bind_param("i", $id);
$stmt->execute();
$result = $stmt->get_result();
$cliente = $result->fetch_assoc();

// Se não encontrar o cliente, redireciona
if (!$cliente) {
    header("Location: index.php");
    exit;
}

// Se o formulário foi enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = trim($_POST['nome']);
    $email = trim($_POST['email']);
    $telefone = trim($_POST['telefone']);
    $cidade = trim($_POST['cidade']);
    $estado = trim($_POST['estado']);

    // Validação dos campos obrigatórios
    if ($nome === "" || $email === "" || $telefone === "" || $cidade === "" || $estado === "") {
        echo "<script>alert('Todos os campos são obrigatórios.'); history.back();</script>";
        exit;
    }

    // Atualiza os dados
    $stmt = $conn->prepare("UPDATE clientes SET nome=?, email=?, telefone=?, cidade=?, estado=? WHERE id=?");
    $stmt->bind_param("sssssi", $nome, $email, $telefone, $cidade, $estado, $id);
    $stmt->execute();
    header("Location: index.php");
    exit;
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
    function validarFormulario() {
        const form = document.forms["formCliente"];
        const campos = ["nome", "email", "telefone", "cidade", "estado"];
        for (let campo of campos) {
            if (form[campo].value.trim() === "") {
                alert("Todos os campos são obrigatórios.");
                form[campo].focus();
                return false;
            }
        }
        return true;
    }
    </script>
</head>
<body class="container mt-5">
    <h2>Editar Cliente</h2>
    <form name="formCliente" method="POST" onsubmit="return validarFormulario();">
        <div class="mb-3">
            <label>Nome:</label>
            <input type="text" name="nome" class="form-control" value="<?= htmlspecialchars($cliente['nome']) ?>" required>
        </div>
        <div class="mb-3">
            <label>Email:</label>
            <input type="email" name="email" class="form-control" value="<?= htmlspecialchars($cliente['email']) ?>" required>
        </div>
        <div class="mb-3">
            <label>Telefone:</label>
            <input type="text" name="telefone" class="form-control" value="<?= htmlspecialchars($cliente['telefone']) ?>" required>
        </div>
        <div class="mb-3">
            <label>Cidade:</label>
            <input type="text" name="cidade" class="form-control" value="<?= htmlspecialchars($cliente['cidade']) ?>" required>
        </div>
        <div class="mb-3">
            <label>Estado:</label>
            <input type="text" name="estado" class="form-control" maxlength="2" value="<?= htmlspecialchars($cliente['estado']) ?>" required>
        </div>
        <button type="submit" class="btn btn-success">Atualizar</button>
        <a href="index.php" class="btn btn-secondary">Cancelar</a>
    </form>
</body>
</html>