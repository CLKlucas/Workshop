def qual_animal(animal_desejado):
    if animal_desejado == 'g':
        return 2
    elif animal_desejado == 'c' or animal_desejado == 'v':
        return 4   


qtd_patas = 0
cont = 0
chute_chico = int(input('Digite o chute do Chico bento\n'))
chute_cebolinha = int(input('Digite o chute do Cebolinha\n'))
qtd_animais = int(input('Quantidade de animais no campo: '))
lista_animais = list()
while cont < qtd_animais:
    print('ANIMAIS [Galinha = g | Cavalo = c | Vaca = v]')
    animal = str(input('Digite a primeira letra do animal desejado:').lower()[:1])
    lista_animais.append(animal)
    cont += 1

for i in range(len(lista_animais)):
    qtd_patas += qual_animal(lista_animais[i])


if abs(qtd_patas - chute_chico) == abs(qtd_patas - chute_cebolinha):
    print('Empate') 
elif abs(qtd_patas - chute_chico) < abs(qtd_patas - chute_cebolinha):
    print('Chico bento')
else:
    print('Cebolinha')
    
print(qtd_patas)                    