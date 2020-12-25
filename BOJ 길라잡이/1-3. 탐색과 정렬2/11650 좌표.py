import sys
N = int(sys.stdin.readline())

num = []

for _ in range(N):
    num.append(list(map(int,sys.stdin.readline().split())))

num.sort(key = lambda x:(x[0],x[1]))
for v in num:
    print(v[0],v[1])
    