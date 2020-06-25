import sys

N = int(sys.stdin.readline())
stack = list()

for i in range(N):
    lt = sys.stdin.readline().split()

    if lt[0] == "push":
        stack.append(int(lt[1]))
    elif lt[0] == "pop":

        if len(stack):
            print(stack.pop())
        else:
            print(-1)
    elif lt[0] == "size":
        print(len(stack))
    elif lt[0] == "empty":
        if len(stack):
            print(0)
        else:
            print(1)
    elif lt[0] == "top":
        if len(stack):
            print(stack[-1])
        else:
            print(-1)
