<?php include 'conexao.php'; ?>
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = trim($_POST['nome']);
    $email = trim($_POST['email']);
    $telefone = trim($_POST['telefone']);
    $cidade = trim($_POST['cidade']);
    $estado = trim($_POST['estado']);

    if ($nome === "" || $email === "" || $telefone === "" || $cidade === "" || $estado === "") {
        echo "<script>alert('Todos os campos são obrigatórios.'); history.back();</script>";
        exit;
    }

    $stmt = $conn->prepare("INSERT INTO clientes (nome, email, telefone, cidade, estado) VALUES (?, ?, ?, ?, ?)");
    $stmt->bind_param("sssss", $nome, $email, $telefone, $cidade, $estado);
    $stmt->execute();
    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Criar Cliente</title>
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
    <h2>Novo Cliente</h2>
    <form name="formCliente" method="POST" onsubmit="return validarFormulario();">
        <div class="mb-3">
            <label>Nome:</label>
            <input type="text" name="nome" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Telefone:</label>
            <input type="text" name="telefone" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Cidade:</label>
            <input type="text" name="cidade" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Estado:</label>
            <input type="text" name="estado" class="form-control" maxlength="2" required>
        </div>
        <button type="submit" class="btn btn-success">Salvar</button>
        <a href="index.php" class="btn btn-secondary">Voltar</a>
    </form>
</body>
</html>