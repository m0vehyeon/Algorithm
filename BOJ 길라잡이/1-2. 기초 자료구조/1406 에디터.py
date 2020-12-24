import sys

word = sys.stdin.readline().rstrip()
M = int(sys.stdin.readline().rstrip())

left = list(word)
right = []


for _ in range(M):
    v = sys.stdin.readline().rstrip().split()
    if (v[0] == 'L'):
        if (len(left)):
            right.append(left.pop())
            
    elif (v[0] == 'D'):
        if (len(right)):
            left.append(right.pop())
            
    elif (v[0] == 'B'):
        if (len(left)):
            left.pop()
            
    elif (v[0] == 'P'):
        left.append(v[1])
        

print(''.join(left)+''.join(right[::-1]))
