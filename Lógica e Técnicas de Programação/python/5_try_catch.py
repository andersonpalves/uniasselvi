try:
    numero = int(input("Digite um número inteiro: "))
    resultado = 10 / numero
except ValueError:
    print("Erro: você deve digitar um número válido.")
except ZeroDivisionError:
    print("Erro: divisão por zero não permitida.")
else:
    print("Resultado:", resultado)