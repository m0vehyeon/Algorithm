import sys

N = int(sys.stdin.readline())
queue = list()

for i in range(N):
    lt = sys.stdin.readline().split()

    if lt[0] == "push":
        queue.append(int(lt[1]))
    elif lt[0] == "pop":

        if len(queue):
            print(queue.pop(0))
        else:
            print(-1)
    elif lt[0] == "size":
        print(len(queue))
    elif lt[0] == "empty":
        if len(queue):
            print(0)
        else:
            print(1)
    elif lt[0] == "back":
        if len(queue):
            print(queue[-1])
        else:
            print(-1)
    elif lt[0] == "front":
        if len(queue):
            print(queue[0])
        else:
            print(-1)
