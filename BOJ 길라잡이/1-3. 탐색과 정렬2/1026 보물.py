N = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))

A.sort()
B.sort(reverse = True)

hap = 0
for i, j in zip(A,B):
    hap += i * j
print(hap)