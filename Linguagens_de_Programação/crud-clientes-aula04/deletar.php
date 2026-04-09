<?php
// deletar.php
$apiBase = 'http://localhost:9090/api/clientes';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    header('Location: index.php?status=error&msg=' . urlencode('Requisição inválida.'));
    exit;
}

$id = isset($_POST['id']) ? intval($_POST['id']) : 0;
if ($id <= 0) {
    header('Location: index.php?status=error&msg=' . urlencode('ID inválido.'));
    exit;
}

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $apiBase . '/deletar/' . $id);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE');
curl_setopt($ch, CURLOPT_HTTPHEADER, ['Accept: application/json']);
$response = curl_exec($ch);
$httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

if ($httpCode === 200 || $httpCode === 204) {
    header('Location: index.php?status=success&msg=' . urlencode('Cliente deletado.'));
    exit;
} else {
    header('Location: index.php?status=error&msg=' . urlencode("Erro ao deletar. Código: $httpCode"));
    exit;
}
