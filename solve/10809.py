arr=input()
arr=str(arr)
alpha="abcdefghijklmnopqrstuvwxyz"
al=[-1]*len(alpha)
answer=""
for i,v in enumerate(arr):

    if(alpha.find(v)==-1):
        if(al[alpha.find(v)]!=-1):
            al[alpha.find(v)]=-1
    elif(alpha.find(v)>=0):
        if(al[alpha.find(v)]==-1):
            al[alpha.find(v)]=arr.find(v)


for i1,j in enumerate(al):
    answer+=str(j)
    if(i1!=len(al)-1):
        answer+=" "

print(answer)