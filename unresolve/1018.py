m,n=map(int,input().split())
chess=[[x for x in input().split()]for y in range(m)]
count=0
temp=''
for i in chess:
    for j in chess[i]:
        temp=chess[i][j]

