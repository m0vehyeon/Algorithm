locate = input()

dic = {'a' : 1, 'b' : 2 , 'c' : 3, 'd' : 4, 'e' : 5, 'f' : 6, 'g' : 7, 'h' : 8}
x = dic[locate[0]]
y = int(locate[1])

dx = [0,0,-1,1]
dy = [-1,1,0,0]

#LRUD
moves = [[0,0,2],[0,0,3],[1,1,2],[1,1,3],[2,2,0],[2,2,1],[3,3,0],[3,3,1]]
count = 0

for move in moves:
    check = 0
    nx, ny = x, y
    for v in move:
        nx += dx[v]
        ny += dy[v]
        if nx < 1 or ny < 1 or nx > 8 or ny > 8:
            check = 1
            break
        
    if check == 0:
        count += 1
    
print(count)