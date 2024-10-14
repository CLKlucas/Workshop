num = int(input('Digite um número: '))
for i in range(2,num):
    contador = 0
    while num % i == 0:
        contador += 1
        num = num / i
    if contador > 0:
        print(f'{i} {contador}')