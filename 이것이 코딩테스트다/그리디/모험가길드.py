import sys
from collections import Counter as c
n = int(sys.stdin.readline())
member = list(map(int,sys.stdin.readline().split()))

""" 내 풀이
result = 0
for v in list(c(member)):
    if(c(member)[v] >= v):
        result+=1
print(result)
"""

member.sort()

result = 0
count = 0

for v in member:
    count += 1
    if count >= v:
        result += 1
        count = 0

print(result)
