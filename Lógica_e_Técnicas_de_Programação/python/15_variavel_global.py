contador = 0  # variável global

def incrementar():
    global contador
    contador += 1

incrementar()
print("Contador:", contador)