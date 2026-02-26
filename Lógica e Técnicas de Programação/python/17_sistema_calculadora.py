def menu():
    print("1 - Somar")
    print("2 - Subtrair")
    print("3 - Sair")

while True:
    menu()
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        a = float(input("Digite o primeiro número: "))
        b = float(input("Digite o segundo número: "))
        print("Resultado:", a + b)

    elif opcao == "2":
        a = float(input("Digite o primeiro número: "))
        b = float(input("Digite o segundo número: "))
        print("Resultado:", a - b)

    elif opcao == "3":
        print("Encerrando sistema...")
        break

    else:
        print("Opção inválida!")