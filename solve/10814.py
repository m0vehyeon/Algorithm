n=int(input())
temp=[]
for _ in range(n):
    temp.append(list(input().split()))
temp.sort(key=lambda x:int(x[0]))
for v in temp:
    print(' '.join(v))