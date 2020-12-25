import sys

N = int(sys.stdin.readline())
num = list(set(map(int,sys.stdin.readline().split())))

for v in num:
    print(v, end = " ")