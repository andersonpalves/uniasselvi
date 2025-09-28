<?php include 'conexao.php'; ?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2>Lista de Clientes</h2>
    <a href="criar.php" class="btn btn-primary mb-3">Novo Cliente</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Nome</th><th>Email</th><th>Telefone</th><th>Cidade</th><th>Estado</th><th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <?php
            $result = $conn->query("SELECT * FROM clientes");
            while ($row = $result->fetch_assoc()) {
                echo "<tr>
                    <td>{$row['nome']}</td>
                    <td>{$row['email']}</td>
                    <td>{$row['telefone']}</td>
                    <td>{$row['cidade']}</td>
                    <td>{$row['estado']}</td>
                    <td>
                        <a href='editar.php?id={$row['id']}' class='btn btn-warning btn-sm'>Editar</a>
                        <a href='deletar.php?id={$row['id']}' class='btn btn-danger btn-sm'>Excluir</a>
                    </td>
                </tr>";
            }
            ?>
        </tbody>
    </table>
</body>
</html>