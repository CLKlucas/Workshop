matriz = []
soma = 0
for i in range(2):
    notas = list(map(int,input().split(' ')))
    matriz.append(notas)

for linha in range(len(matriz)):
    for coluna in range(len(matriz) + 1):
        soma += matriz[linha][coluna]
print(soma)            