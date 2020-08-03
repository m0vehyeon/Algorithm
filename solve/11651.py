N=int(input())
arr=[]
for v in range(N):
    arr.append(list(map(int,input().split())))
for v in sorted(arr,key=lambda x:(x[1],x[0])):
    print(*v)