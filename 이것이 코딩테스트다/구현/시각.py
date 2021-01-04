import time
start = time.time()
N = int(input())
"""
clock = [0, 0, 0]
count = 0

while clock[0] != N or clock[1] != 59 or clock[2] != 59:
    if clock[2] == 59:
        if clock[1] == 59:
            clock[2] = 0
            clock[1] = 0
            clock[0] += 1
        else:
            clock[2] = 0
            clock[1] += 1
    else:
        clock[2] += 1
    
    if '3' in str(clock[0]) or '3' in str(clock[1]) or '3' in str(clock[2]):
        count += 1

print(count)
print("time :", time.time() - start)  # 현재시각 - 시작시간 = 실행 시간
"""
count = 0
for i in range(N+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                count += 1
print(count)