package unidade2

fun main() {
    // -------------------------------
    // Operadores Aritméticos
    // -------------------------------
    val a = 10
    val b = 3

    println("Soma: ${a + b}")        // 13
    println("Subtração: ${a - b}")   // 7
    println("Multiplicação: ${a * b}") // 30
    println("Divisão: ${a / b}")     // 3 (divisão inteira)
    println("Módulo: ${a % b}")      // 1 (resto da divisão)

    // -------------------------------
    // Operadores Relacionais
    // -------------------------------
    println("a > b: ${a > b}")       // true
    println("a < b: ${a < b}")       // false
    println("a >= b: ${a >= b}")     // true
    println("a <= b: ${a <= b}")     // false
    println("a == b: ${a == b}")     // false
    println("a != b: ${a != b}")     // true

    // -------------------------------
    // Operadores Lógicos
    // -------------------------------
    val x = true
    val y = false

    println("x && y: ${x && y}")     // false (AND)
    println("x || y: ${x || y}")     // true  (OR)
    println("!x: ${!x}")             // false (NOT)

    // -------------------------------
    // Operadores de Atribuição
    // -------------------------------
    var numero = 5
    numero += 2   // equivalente a numero = numero + 2
    println("numero += 2: $numero")  // 7

    numero -= 1   // equivalente a numero = numero - 1
    println("numero -= 1: $numero")  // 6

    numero *= 3   // equivalente a numero = numero * 3
    println("numero *= 3: $numero")  // 18

    numero /= 2   // equivalente a numero = numero / 2
    println("numero /= 2: $numero")  // 9

    numero %= 4   // equivalente a numero = numero % 4
    println("numero %= 4: $numero")  // 1

    // -------------------------------
    // Incremento e Decremento
    // -------------------------------
    var contador = 10

    println("contador++: ${contador++}") // imprime 10, depois contador = 11
    println("contador após incremento: $contador") // 11

    println("++contador: ${++contador}") // incrementa antes de imprimir -> 12

    println("contador--: ${contador--}") // imprime 12, depois contador = 11
    println("contador após decremento: $contador") // 11

    println("--contador: ${--contador}") // decrementa antes de imprimir -> 10
}