from collections import deque

deque = deque()
N = int(input())
com = []

for _ in range(N):
    com.append(input().split())

for v in com:
    if (v[0] == "push_front"):
        deque.appendleft(v[1])
    elif (v[0] == "push_back"):
        deque.append(v[1])
    elif (v[0] == "pop_front"):
        if (len(deque) == 0):
            print(-1)
        else:
            print(deque.popleft())
    elif (v[0] == "pop_back"):
        if (len(deque) == 0):
            print(-1)
        else:
            print(deque.pop())
    elif (v[0] == "size"):
        print(len(deque))
    elif (v[0] == "empty"):
        if (len(deque) == 0):
            print(1)
        else:
            print(0)
    elif (v[0] == "front"):
        if (len(deque) == 0):
            print(-1)
        else:
            print(deque[0])
    elif (v[0] == "back"):
        if (len(deque) == 0):
            print(-1)
        else:
            print(deque[len(deque)-1])