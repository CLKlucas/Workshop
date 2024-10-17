def contido(num_vetor):
    estar = int(input('Digite um número qualquer para saber se ele estar contido ou não no vetor\n'))
    for num in range(len(num_vetor)):
        if estar == num_vetor[num]:
            print(f'o número {estar} está contido no vetor {num_vetor}')

def posiçao(num_vetor):
    index = int(input('Digite um número qualquer para saber a posição dele no vetor\n'))
    for num in range(len(num_vetor)):
        if index == num_vetor[num]:
            print(f'O número {index} está na posição {num} do vetor {num_vetor}')

def posiçao_positivo(num_vetor):
    prox_zero = 0
    for num in range(len(num_vetor)):
        if num_vetor[num] > 0:
            return num
        elif num == 0:
            prox_zero = num_vetor[num]
        elif num_vetor[num] > prox_zero:
            prox_zero = num_vetor[num]     
    return prox_zero     

def menor(num_vetor):
    num_menor = 0
    index = 0
    for num in range(len(num_vetor)):
        if num == 0:
            num_menor = num_vetor[num]
            index = num
        else:
            if num_menor > num_vetor[num]:
                num_menor = num_vetor[num]
                index = num
    return index

def menor_posiçao_positivo(num_vetor):
    menor = 0
    menor_negativo = 0
    cont = 0
    index_positivo = 0
    index_negativo = 0
    for num in range(len(num_vetor)):
        if num == 0:
            menor = num_vetor[num]
            index_positivo = num
        if num_vetor[num] > 0 and num_vetor[num] < menor:
            menor = num_vetor[num]
            index_positivo = num    
        elif num_vetor[num] < 0:
            cont += 1
            if cont == 1:
                menor_negativo = num_vetor[num]
                index_negativo = num
            else:
                if num_vetor[num] > menor_negativo:
                    menor_negativo = num_vetor[num]
                    index_negativo = num
    if cont == len(num_vetor):
        return index_negativo
    else:
        return index_positivo

vetor = list(map(int,input().split(' ')))
res = menor_posiçao_positivo(vetor)
print(res)