N=int(input())
temp=[]

for i in range(1,1000000000):
    if(str(i).find("666")>=0):
        temp.append(i)
    if(len(temp)==N):
        print(temp[N-1])
        break

