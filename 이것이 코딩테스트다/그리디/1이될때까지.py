import sys

n, k = map(int,sys.stdin.readline().split()))
count = 0

""" 내 풀이
while ( n != 1 ):
    if(n % k == 0):
        count += 1
        n /= k
    else:
        count += 1
        n -= 1

print(count)
"""

""" 정석 풀이
