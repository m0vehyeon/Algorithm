num=int(input())

for i in range(1,num+1):
    sum = 0
    sum+=i
    for j in str(i):
        sum+=int(j)

    if(sum==num):
        print(i)
        break
if(i==num):
    print(0)