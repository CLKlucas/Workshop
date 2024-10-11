maior = 0
menor = 0
lista = []

for i in range(3):
    num = int(input('Digite um numero: '))
    if i == 0:
        maior = num
        menor = num    
    else:    
        if num > maior:
            maior = num
        elif num < menor:
            menor = num 
    lista.append(num)

for i in range(len(lista)):
    if lista[i] < maior and lista[i] > menor:
        print(lista[i])    
    
