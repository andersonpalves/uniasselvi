nota = float(input("Digite a nota do aluno: "))

if nota < 0 or nota > 10:
    print("Insira um valor entre 0 e 10")
elif nota >= 7:
    print("Aluno aprovado.")
elif nota >= 5:
    print("Aluno em recuperação.")
else:
    print("Aluno reprovado.")
