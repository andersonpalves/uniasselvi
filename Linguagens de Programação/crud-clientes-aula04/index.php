<?php
// index.php
$apiBase = 'http://localhost:9090/api/clientes';

// mensagens via query string (ex: ?status=success&msg=Cliente+criado)
$status = isset($_GET['status']) ? $_GET['status'] : null;
$msg = isset($_GET['msg']) ? urldecode($_GET['msg']) : null;

// busca lista de clientes
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $apiBase . '/listar');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, ['Accept: application/json']);
$response = curl_exec($ch);
$httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

$clientes = [];
$error = null;
if ($httpCode === 200 || $httpCode === 201) {
    $clientes = json_decode($response, true);
    // caso a API retorne um objeto com chave, adapte aqui (assumimos array)
} else {
    $error = "Erro ao buscar clientes. Código: $httpCode";
}
?>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <title>Clientes</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS (CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="estilo.css">
</head>
<body>
<div class="container py-4">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h2>Lista de Clientes</h2>
    <a href="criar.php" class="btn btn-primary">+ Novo Cliente</a>
  </div>

  <?php if ($status === 'success'): ?>
    <div class="alert alert-success"><?= htmlspecialchars($msg) ?></div>
  <?php elseif ($status === 'error'): ?>
    <div class="alert alert-danger"><?= htmlspecialchars($msg) ?></div>
  <?php endif; ?>

  <?php if ($error): ?>
    <div class="alert alert-danger"><?= htmlspecialchars($error) ?></div>
  <?php else: ?>
    <div class="table-responsive">
      <table class="table table-striped table-hover align-middle">
        <thead class="table-light">
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th class="text-end">Ações</th>
          </tr>
        </thead>
        <tbody>
        <?php if (empty($clientes)): ?>
          <tr><td colspan="7" class="text-center">Nenhum cliente encontrado.</td></tr>
        <?php else: ?>
          <?php foreach ($clientes as $c): ?>
            <tr>
              <td><?= htmlspecialchars($c['id'] ?? '') ?></td>
              <td><?= htmlspecialchars($c['nome'] ?? '') ?></td>
              <td><?= htmlspecialchars($c['email'] ?? '') ?></td>
              <td><?= htmlspecialchars($c['telefone'] ?? '') ?></td>
              <td><?= htmlspecialchars($c['cidade'] ?? '') ?></td>
              <td><?= htmlspecialchars($c['estado'] ?? '') ?></td>
              <td class="text-end">
                <a href="editar.php?id=<?= urlencode($c['id']) ?>" class="btn btn-sm btn-outline-secondary">Editar</a>

                <!-- deletar via form POST (faz DELETE para a API) -->
                <form action="deletar.php" method="post" class="d-inline" onsubmit="return confirm('Deseja realmente deletar este cliente?');">
                  <input type="hidden" name="id" value="<?= htmlspecialchars($c['id']) ?>">
                  <button type="submit" class="btn btn-sm btn-outline-danger">Deletar</button>
                </form>
              </td>
            </tr>
          <?php endforeach; ?>
        <?php endif; ?>
        </tbody>
      </table>
    </div>
  <?php endif; ?>
</div>

<!-- Bootstrap JS (CDN) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
