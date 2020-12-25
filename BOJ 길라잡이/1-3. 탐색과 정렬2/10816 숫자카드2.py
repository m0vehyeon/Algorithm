import sys
from collections import Counter as c
N = int(sys.stdin.readline())
card = list(map(int,sys.stdin.readline().split()))
M = int(sys.stdin.readline())
num = list(map(int,sys.stdin.readline().split()))
""" 
1. 카운터 이용하기
count = c(card)

for v in num:
    print(count[v], end = ' ')
"""
# 2. 딕셔너리
dic = dict()
for v in card:
    if (v in dic):
        dic[v] += 1
    else:
        dic[v] = 1

for v in num:
    if (v in dic):
        print(dic[v], end = ' ')
    else:
        print(0, end = ' ')