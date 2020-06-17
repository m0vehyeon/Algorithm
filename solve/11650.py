arr=input()
arr=int(arr)
arr1=[]

for r in range(arr):
    arr1.append(list(map(int,input().split())))
arr1=sorted(arr1,key=lambda x:(x[0],x[1]))
map(str,arr1)
for v in arr1:
    print(v[0],v[1])
