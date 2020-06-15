word=input()
wordarr=["c=","c-","dz=","d-","lj","nj","s=","z="]
count=0
i=0
while(i<len(word)):
    check=False
    for v in wordarr:
        if(word.find(v,i)==i):
            count+=1
            i+=len(v)
            check=True
            break
    if(check==False):
        count+=1
        i+=1
print(count)
