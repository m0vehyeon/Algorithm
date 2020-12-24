N = int(input())
stack = []
command = []
for _ in range(N):
    command.append(input().split())
for v in command:    
    if (v[0] == 'push'):
        stack.append(int(v[1]))
    elif (v[0] == 'pop'):
        if (len(stack) == 0):
            print(-1)
        else:
            print(stack.pop())
    elif (v[0] == 'size'):
        print(len(stack))
    elif(v[0] == 'empty'):
        if(len(stack) == 0):
            print(1)
        else:
            print(0)
    elif(v[0] == 'top'):
        if(len(stack) == 0):
            print(-1)
        else:
            print(stack[len(stack)-1])