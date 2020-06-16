N=int(input())
ex=input()
temp=[]
for _ in range(N):
    temp.append(input())

if(len(ex)>=3):
    for v in temp:
        #print(ex[:ex.index("*")],ex[-(len(ex)-ex.index("*"))+1:])
        #print(v[:ex.index("*")],v[-(len(ex)-ex.index("*"))+1:])
        if(len(v)>=len(ex)-1):
            if(ex[:ex.index("*")]==v[:ex.index("*")]
                    and ex[-(len(ex)-ex.index("*"))+1:]==v[-(len(ex)-ex.index("*"))+1:]):
                print("DA")
            else:
                print("NE")
        else:
            print("NE")

elif(len(ex)==2):
    if(ex.index("*")>0): #a*a
        for v in temp:
            if v[:1]==ex[0]:
                print("DA")
            else:
                print("NE")
    else: #*d
        for v in temp:
            if v[-1:]==ex[1]:
                print("DA")
            else:
                print("NE")
else:
    for v in temp:
        print("DA")