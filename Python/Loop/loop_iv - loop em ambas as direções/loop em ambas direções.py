começo,fim = map(int,input().split(' '))
if fim <= 0:
    print('[', end=' ')
    for i in range(começo,fim, -1):
        print(i,end=' ')
    print(']')            
else:
    print('[',end=' ')
    for i in range(começo,fim):
        print(i,end=' ')
    print(']')            