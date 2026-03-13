contador = 0
soma = 0

for i in range(3):
    valor = float(input("Digite um valor: "))
    soma += valor
    contador += 1

media = soma / contador
print(f"Média: {media:.2f}")