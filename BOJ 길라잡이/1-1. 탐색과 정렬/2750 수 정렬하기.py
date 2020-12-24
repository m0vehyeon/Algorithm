N = int(input())
num = []

for _ in range(N):
    num.append(int(input()))

for v in sorted(num):
    print(v)