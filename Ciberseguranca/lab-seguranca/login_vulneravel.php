<?php include 'conexao.php'; ?>

<form method="POST">
    Email: <input name="email"><br>
    Senha: <input name="senha"><br>
    <button>Login</button>
</form>

<?php
if ($_POST) {
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    $sql = "SELECT * FROM usuarios WHERE email='$email' AND senha='$senha'";
    $res = $conn->query($sql);

    if ($res->num_rows > 0) {
        $_SESSION['usuario'] = $email;
        echo "Login OK";
    } else {
        echo "Erro";
    }

    echo "<br>Query: $sql";
}
?>