import sys
from collections import deque
N = int(sys.stdin.readline())

count = 1
check = True
oper = []
stack = []
for _ in range(N):
    num = int(sys.stdin.readline())
    while count <= num:
        stack.append(count)
        oper.append('+')
        count += 1
    if stack[-1] == num:
        stack.pop()
        oper.append('-')
    else:
        check = False

if check == True:
    for v in oper:
        print(v)
else:
    print("NO")
    