dia = input("Digite o dia da semana: ").lower()

match dia:
    case "sabado" | "domingo":
        print("Final de semana!")
    case "segunda" | "terca" | "quarta" | "quinta" | "sexta":
        print("Dia útil.")
    case _:
        print("Dia inválido.")