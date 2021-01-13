
T = int(input())
answer = []
for _ in range(T):
    com = input()
    n = int(input())
    if n == 0:
        in_arr = input()
        in_arr = []
    else:
        in_arr = list(map(int,input()[1:-1].split(',')))
    
    reverse = False
    front = 0
    back = 0

    for v in com:
        if v == 'R':
            reverse = not reverse
        elif v == 'D' and reverse == True:
            back += 1
        elif v == 'D' and reverse == False: 
            front += 1
    
    if front + back <= len(in_arr):
        in_arr = in_arr[front:n - back]
        if reverse == True:
            in_arr.reverse()

        answer.append(in_arr)
    else:
        answer.append('error')    
    

for v in answer:
    if v == 'error':
        print('error')
    else:
        print(str(v).replace(' ', ''))

