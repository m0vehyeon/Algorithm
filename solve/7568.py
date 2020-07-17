N=int(input())
arr=[]
for _ in range(N):
    temp=list(map(int,input().split()))
    temp.append(_)
    arr.append(temp)
arr.sort(key=lambda x:(x[0],x[1]))
ans=[0]*N
for i in range(len(arr)):
    cnt=0
    for j in range(i+1,len(arr)):
        if(arr[i][0]<arr[j][0] and arr[i][1]<arr[j][1]):
            cnt+=1
    ans[arr[i][2]]=cnt+1
print(*ans)