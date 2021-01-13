from collections import deque
N = int(input())
answer = []
for _ in range(N):
    n, i = map(int,input().split())
    task = deque(list(map(int, input().split())))
    for j in range(n):
        task[j] = [task[j], j]
    count = 1

    
    while len(task):
        imp = task[0][0]
        check = 0
        for k in range(1,len(task)):
            if imp < task[k][0]:
                check = 1
                task.append(task.popleft())
                break
        if check == 0:
            if task[0][1] != i:
                count += 1
                task.popleft()
            elif task[0][1] == i:
                answer.append(count)
                break

for v in answer:
    print(v)