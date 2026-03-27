<?php include 'conexao.php'; ?>

<form method="POST">
    Email: <input name="email"><br>
    Senha: <input name="senha"><br>
    <button>Login</button>
</form>

<?php
if ($_POST) {
    $stmt = $conn->prepare("SELECT * FROM usuarios WHERE email=?");
    $stmt->bind_param("s", $_POST['email']);
    $stmt->execute();

    $res = $stmt->get_result();
    $user = $res->fetch_assoc();

    if ($user && password_verify($_POST['senha'], $user['senha'])) {
        $_SESSION['usuario'] = $user['email'];
        echo "Login OK";
    } else {
        echo "Erro";
    }
}
?>