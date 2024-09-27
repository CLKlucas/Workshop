def blackjack(contador_As,vetor):
    inde = 0
    somador = 0
    decremento = 0
    if contador_As > 0:
        while inde < len(vetor):
            if vetor[inde] == 1:
                somador += 11
                if somador > 21:
                    decremento += 1   
            elif vetor[inde] == 11 or vetor[inde] == 12 or vetor[inde] == 13:
                somador += 10
                if somador > 21:
                    decremento += 1   
            else:
                somador += vetor[inde]
            inde += 1
    else:
        while inde < len(vetor):
            if vetor[inde] == 11 or vetor[inde] == 12 or vetor[inde] == 13:
                somador += 10
            else:
                somador = vetor[inde]
            inde += 1
    
    if somador > 21:
        somador -= decremento * 11
        somador += decremento * 1    
        return somador
    else:   
        return somador   

qtd_elementos = int(input())
lista = []
soma = 0
cont1 = 0
decremento = 0
for i in range(qtd_elementos):
    elementos = int(input())
    lista.append(elementos)
for elem in range(len(lista)):
    if lista[elem] == 1:
        cont1 += 1        

soma = blackjack(cont1,lista)

print(soma)         