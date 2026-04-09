<?php
$apiBase = 'http://localhost:9090/api/clientes';
$id = isset($_GET['id']) ? intval($_GET['id']) : 0;

if ($id <= 0) {
    header('Location: index.php?status=error&msg=' . urlencode('ID inválido.'));
    exit;
}

$errors = [];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = trim($_POST['nome'] ?? '');
    $email = trim($_POST['email'] ?? '');
    $telefone = trim($_POST['telefone'] ?? '');
    $cidade = trim($_POST['cidade'] ?? '');
    $estado = strtoupper(trim($_POST['estado'] ?? ''));

    if ($nome === '') $errors[] = 'Nome é obrigatório.';
    if ($email === '') $errors[] = 'Email é obrigatório.';

    if (empty($errors)) {
        $payload = json_encode([
            'nome' => $nome,
            'email' => $email,
            'telefone' => $telefone,
            'cidade' => $cidade,
            'estado' => $estado
        ]);

        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $apiBase . '/atualizar/' . $id);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
        curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);
        curl_setopt($ch, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json',
            'Accept: application/json'
        ]);
        $response = curl_exec($ch);
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        curl_close($ch);

        if ($httpCode === 200) {
            header('Location: index.php?status=success&msg=' . urlencode('Cliente atualizado.'));
            exit;
        } else {
            $errors[] = "Erro ao atualizar cliente. Código: $httpCode";
        }
    }
}

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $apiBase . '/listar/' . $id);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, ['Accept: application/json']);
$response = curl_exec($ch);
curl_close($ch);
$cliente = json_decode($response, true);
?>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <title>Editar Cliente</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="estilo.css">
</head>
<body>
<div class="container py-4">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h2>Editar Cliente #<?= htmlspecialchars($id) ?></h2>
    <a href="index.php" class="btn btn-secondary">Voltar</a>
  </div>

  <?php if (!empty($errors)): ?>
    <div class="alert alert-danger">
      <ul class="mb-0">
        <?php foreach ($errors as $e): ?>
          <li><?= htmlspecialchars($e) ?></li>
        <?php endforeach; ?>
      </ul>
    </div>
  <?php endif; ?>

  <form method="post" id="formEditar" novalidate>
    <div class="mb-3">
      <label class="form-label">Nome</label>
      <input name="nome" class="form-control" id="nome" value="<?= htmlspecialchars($cliente['nome'] ?? '') ?>" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Email</label>
      <input name="email" type="email" class="form-control" id="email" value="<?= htmlspecialchars($cliente['email'] ?? '') ?>" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Telefone</label>
      <input name="telefone" class="form-control" id="telefone" value="<?= htmlspecialchars($cliente['telefone'] ?? '') ?>">
    </div>
    <div class="row">
      <div class="col-md-8 mb-3">
        <label class="form-label">Cidade</label>
        <input name="cidade" class="form-control" id="cidade" value="<?= htmlspecialchars($cliente['cidade'] ?? '') ?>">
      </div>
      <div class="col-md-4 mb-3">
        <label class="form-label">Estado</label>
        <input name="estado" class="form-control" id="estado" maxlength="2" value="<?= htmlspecialchars($cliente['estado'] ?? '') ?>">
      </div>
    </div>

    <button class="btn btn-primary" type="submit">Salvar</button>
    <a href="index.php" class="btn btn-outline-secondary">Cancelar</a>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
document.getElementById('formEditar').addEventListener('submit', function(e) {
  const nome = document.getElementById('nome').value.trim();
  const email = document.getElementById('email').value.trim();
  const telefone = document.getElementById('telefone').value.trim();
  const cidade = document.getElementById('cidade').value.trim();
  const estado = document.getElementById('estado').value.trim().toUpperCase();

  let erros = [];

  if (nome === '') erros.push('O nome é obrigatório.');
  if (email === '') erros.push('O e-mail é obrigatório.');
  else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) erros.push('E-mail inválido.');
  if (estado && estado.length !== 2) erros.push('O estado deve ter 2 letras.');
  if (telefone && !/^[0-9()+\-\s]+$/.test(telefone)) erros.push('Telefone inválido.');
  if (estado && !cidade) erros.push('Se informar o estado, informe também a cidade.');

  if (erros.length > 0) {
    e.preventDefault();
    alert(erros.join('\n'));
  }
});
</script>
</body>
</html>
