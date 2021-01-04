N = int(input())
vec = input().split()
x, y = 1, 1

""" 내 풀이
def check(x,y,vec):
    
    x += dx[vec]
    y += dy[vec]
    check =  True
    if x < 1 or x > N:
        check = False
    if y < 1 or y > N:
        check = False
    
    return check

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
#     R  U   L  D
for v in vec:
    if v == 'R' and check(x, y, 0):
        x += dx[0]
        y += dy[0]
        
    elif v == 'L' and check(x, y, 2):
        x += dx[2]
        y += dy[2]
        
    elif v == 'D' and check(x, y, 3):
        x += dx[3]
        y += dy[3]
        
    elif v == 'U' and check(x, y, 1):
        x += dx[1]
        y += dy[1]

print(x,y)
"""
# 동빈나 풀이
dx = [0, 0 , -1, 1]
dy = [-1, 1 ,0 ,0]
move_types = ['L', 'R', 'U', 'D']

for v in vec:
    for i in range(4):
        if v == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx < 1 or ny < 1 or nx > N or ny > N:
        continue
    x, y = nx, ny

print(x, y)