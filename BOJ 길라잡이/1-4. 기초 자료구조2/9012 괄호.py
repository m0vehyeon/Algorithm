import sys

N = int(sys.stdin.readline())
vps = []
for _ in range(N):
    vps.append(sys.stdin.readline().rstrip())

for v in vps:
    count = 0
    
    for w in v:
        if w == '(':
            count += 1
        elif w == ')':
            count -= 1
        if(count < 0):
            break
    if count == 0:
        print("YES")
    else:
        print("NO")
