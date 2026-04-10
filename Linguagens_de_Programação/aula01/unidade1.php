<?php
// HELLO WORLD
echo "<h2>Hello World</h2>";
echo "Olá, mundo!<br><br>";


// VARIÁVEIS E TIPOS DE DADOS
echo "<h2>Variáveis e Tipos de Dados</h2>";
$nome = "Anderson";   // string
$idade = 30;          // inteiro
$altura = 1.75;       // float
$ativo = true;        // boolean

echo "Nome: $nome <br>";
echo "Idade: $idade <br>";
echo "Altura: $altura <br>";
echo "Ativo: " . ($ativo ? "Sim" : "Não") . "<br><br>";


// DECLARAÇÃO DE CONSTANTES
echo "<h2>Constantes</h2>";
define("SITE_NOME", "MeuSitePHP");
echo "Nome do site: " . SITE_NOME . "<br><br>";


// OPERADORES
echo "<h2>Operadores</h2>";
$a = 10;
$b = 5;

echo "Soma: " . ($a + $b) . "<br>";
echo "Subtração: " . ($a - $b) . "<br>";
echo "Multiplicação: " . ($a * $b) . "<br>";
echo "Divisão: " . ($a / $b) . "<br>";

echo "Lógico (AND): " . (($a > 5 && $b < 10) ? "Verdadeiro" : "Falso") . "<br><br>";


// CONTROLE DE FLUXO
echo "<h2>Controle de Fluxo</h2>";

// IF / ELSE
if ($idade >= 18) {
    echo "Maior de idade<br>";
} else {
    echo "Menor de idade<br>";
}

// SWITCH
$dia = 3;
switch ($dia) {
    case 1: echo "Domingo<br>"; break;
    case 2: echo "Segunda<br>"; break;
    case 3: echo "Terça<br>"; break;
    default: echo "Outro dia<br>";
}

// WHILE
echo "While: ";
$i = 0;
while ($i < 3) {
    echo "$i ";
    $i++;
}
echo "<br>";

// FOR
echo "For: ";
for ($j = 0; $j < 3; $j++) {
    echo "$j ";
}
echo "<br><br>";


// STRINGS
echo "<h2>Strings</h2>";
$texto = "PHP é incrível";
echo strtoupper($texto) . "<br>"; // maiúsculo
echo strtolower($texto) . "<br>"; // minúsculo
echo strlen($texto) . "<br>";     // tamanho
echo "<br>";

// ARRAYS
echo "<h2>Arrays</h2>";
$frutas = ["Maçã", "Banana", "Laranja"];

foreach ($frutas as $fruta) {
    echo $fruta . "<br>";
}
echo "<br>";


// FUNÇÕES
echo "<h2>Funções</h2>";
function saudacao($nome) {
    return "Olá, $nome!";
}

echo saudacao("Anderson") . "<br><br>";


// MÚLTIPLOS ARQUIVOS
echo "<h2>Múltiplos Arquivos</h2>";
echo "Exemplo de include/require:<br>";
echo "// include 'arquivo.php';<br>";
echo "// require 'arquivo.php';<br>";
?>